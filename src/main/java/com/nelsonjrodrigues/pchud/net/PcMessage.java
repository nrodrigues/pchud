package com.nelsonjrodrigues.pchud.net;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class PcMessage {

    private int buildVersionNumber;
    private int packetType;

    // TelemetryData

    // Game states
    private int gameSessionState;

    // Participant info
    private int viewedParticipantIndex;
    private int numParticipants;

    // Unfiltered input
    private int unfilteredThrottle;
    private int unfilteredBrake;
    private int unfilteredSteering;
    private int unfilteredClutch;
    private int raceStateFlags;

    // Event information
    private int lapsInEvent;

    // Timings
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

}
