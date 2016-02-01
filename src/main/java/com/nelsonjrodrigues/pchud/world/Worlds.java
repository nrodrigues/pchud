package com.nelsonjrodrigues.pchud.world;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.nelsonjrodrigues.pchud.net.MessageListener;
import com.nelsonjrodrigues.pchud.net.PcMessage;
import com.nelsonjrodrigues.pchud.net.PcMessage.Constants;
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

    private void parseTelemetryData(World world, TelemetryData td) {
        int gameSessionState = td.gameSessionState();

        world.gameState(GameState.fromCode(gameSessionState & 0x0F));
        world.sessionState(SessionState.fromCode((gameSessionState & 0xF0) >> 4));

        int raceStateFlags = td.raceStateFlags();

        world.raceState(RaceState.fromCode(raceStateFlags & 0x7));
        world.lapTimeInvalidated((raceStateFlags & 0x8) != 0);

        world.tyreFrontLeft(parseTyre(td, Constants.TYRE_FRONT_LEFT));
        world.tyreFrontRight(parseTyre(td, Constants.TYRE_FRONT_RIGHT));
        world.tyreRearLeft(parseTyre(td, Constants.TYRE_REAR_LEFT));
        world.tyreRearRight(parseTyre(td, Constants.TYRE_REAR_RIGHT));
    }

    private Tyre parseTyre(TelemetryData td, int tyre) {
        Tyre t = new Tyre();

        t.tyreFlags(EnumSet.noneOf(TyreFlags.class));
        int tyreFlags = td.tyreFlags()[tyre];

        if ((tyreFlags & Constants.TYRE_ATTACHED) != 0) {
            t.tyreFlags().add(TyreFlags.TYRE_ATTACHED);
        }
        if ((tyreFlags & Constants.TYRE_INFLATED) != 0) {
            t.tyreFlags().add(TyreFlags.TYRE_INFLATED);
        }
        if ((tyreFlags & Constants.TYRE_IS_ON_GROUND) != 0) {
            t.tyreFlags().add(TyreFlags.TYRE_IS_ON_GROUND);
        }

        t.terrain(TerrainMaterial.fromCode(td.terrain()[tyre]))
         .tyreY(td.tyreY()[tyre])
         .tyreRPS(td.tyreRPS()[tyre])
         .tyreSlipSpeed(td.tyreSlipSpeed()[tyre])
         .tyreTemp(td.tyreTemp()[tyre])
         .tyreGrip(td.tyreGrip()[tyre])
         .tyreHeightAboveGround(td.tyreHeightAboveGround()[tyre])
         .tyreLateralStiffness(td.tyreLateralStiffness()[tyre])
         .tyreWear(td.tyreWear()[tyre])
         .brakeDamage(td.brakeDamage()[tyre])
         .suspensionDamage(td.suspensionDamage()[tyre])
         .brakeTempCelsius(td.brakeTempCelsius()[tyre])
         .tyreTreadTemp(td.tyreTreadTemp()[tyre])
         .tyreLayerTemp(td.tyreLayerTemp()[tyre])
         .tyreCarcassTemp(td.tyreCarcassTemp()[tyre])
         .tyreRimTemp(td.tyreRimTemp()[tyre])
         .tyreInternalAirTemp(td.tyreInternalAirTemp()[tyre])
         .wheelLocalPositionY(td.wheelLocalPositionY()[tyre])
         .rideHeight(td.rideHeight()[tyre])
         .suspensionTravel(td.suspensionTravel()[tyre])
         .suspensionVelocity(td.suspensionVelocity()[tyre])
         .airPressure(td.airPressure()[tyre]);

        return t;
    }

}
