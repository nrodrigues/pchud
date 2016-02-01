package com.nelsonjrodrigues.pchud.world;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;



@Data
@Accessors(fluent = true)
public class World {

    private final String id;

    private WorldState worldState;
    private GameState gameState;
    private SessionState sessionState;
    private RaceState raceState;

    private ParticipantInfo viewedParticipant;
    private List<ParticipantInfo> participantInfo = new ArrayList<>();

    private boolean lapTimeInvalidated;
    private float bestLapTime;
    private float lastLapTime;
    private float currentTime;
    private float splitTimeAhead;
    private float splitTimeBehind;
    private float splitTime;
    private float eventTimeRemaining;
    private float personalFastestLapTime;
    private float worldFastestLapTime;
    private float currentSector1Time;
    private float currentSector2Time;
    private float currentSector3Time;
    private float fastestSector1Time;
    private float fastestSector2Time;
    private float fastestSector3Time;
    private float personalFastestSector1Time;
    private float personalFastestSector2Time;
    private float personalFastestSector3Time;
    private float worldFastestSector1Time;
    private float worldFastestSector2Time;
    private float worldFastestSector3Time;

    private Car car;

    public ParticipantInfo getParticipantInfoItem(int participantNumber) {
        if (participantInfo != null && participantInfo.size() > participantNumber) {
            return participantInfo.get(participantNumber);
        }
        return null;
    }
}
