package com.nelsonjrodrigues.pchud.world;

public enum CrashState {

    CRASH_DAMAGE_NONE,
    CRASH_DAMAGE_OFFTRACK,
    CRASH_DAMAGE_LARGE_PROP,
    CRASH_DAMAGE_SPINNING,
    CRASH_DAMAGE_ROLLING;

    public static CrashState fromCode(int code) {
        return CrashState.values()[code];
    }

}
