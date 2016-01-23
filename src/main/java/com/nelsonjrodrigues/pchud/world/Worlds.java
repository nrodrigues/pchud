package com.nelsonjrodrigues.pchud.world;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

import com.nelsonjrodrigues.pchud.net.MessageListener;
import com.nelsonjrodrigues.pchud.net.PcMessage;
import com.nelsonjrodrigues.pchud.net.PcMessage.TelemetryData;

import lombok.Data;



@Data
public class Worlds implements MessageListener {

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    private Map<String, World> worlds = new HashMap<>();

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    private void firePropertyChange() {
        pcs.firePropertyChange("worlds", null, null);
    }

    public Map<String, World> getWorlds() {
        return worlds;
    }

    public World getWorldByWorldId(String worldId) {
        World world = worlds.get(worldId);
        if (world == null) {
            world = new World(worldId);
            worlds.put(worldId, world);
        }
        return world;
    }

    @Override
    public void onMessage(PcMessage message) {
        World world = getWorldByWorldId(message.sourceIpAddress());

        world.worldState(WorldState.WORLD_ONLINE);

        switch (message.packetType()) {
            case TELEMETRY_DATA:
                parseTelemetryData(world, message.telemetryData());
                break;

            default:
                break;

        }

        firePropertyChange();
    }

    @Override
    public void onTimeout() {
        for (World world : worlds.values()) {
            world.worldState(WorldState.WORLD_OFFLINE);
        }
        firePropertyChange();
    }

    private void parseTelemetryData(World world, TelemetryData telemetryData) {
        int gameSessionState = telemetryData.gameSessionState();

        world.gameState(GameState.fromCode(gameSessionState & 0x0F));
        world.sessionState(SessionState.fromCode((gameSessionState & 0xF0) >> 4));

        int raceStateFlags = telemetryData.raceStateFlags();

        world.raceState(RaceState.fromCode(raceStateFlags & 0x7));
        world.lapTimeInvalidated((raceStateFlags & 0x8) != 0);

    }

}
