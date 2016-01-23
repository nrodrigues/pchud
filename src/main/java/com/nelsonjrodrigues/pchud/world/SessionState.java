package com.nelsonjrodrigues.pchud.world;

public enum SessionState {

    SESSION_INVALID,
    SESSION_PRACTICE,
    SESSION_TEST,
    SESSION_QUALIFY,
    SESSION_FORMATION_LAP,
    SESSION_RACE,
    SESSION_TIME_ATTACK;

    public static SessionState fromCode(int code) {
        return SessionState.values()[code];
    }

}
