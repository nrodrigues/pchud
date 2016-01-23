package com.nelsonjrodrigues.pchud.world;

public enum RaceState {

    RACESTATE_INVALID,
    RACESTATE_NOT_STARTED,
    RACESTATE_RACING,
    RACESTATE_FINISHED,
    RACESTATE_DISQUALIFIED,
    RACESTATE_RETIRED,
    RACESTATE_DNF;

    public static RaceState fromCode(int code) {
        return RaceState.values()[code];
    }

}
