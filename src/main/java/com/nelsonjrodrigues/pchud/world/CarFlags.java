package com.nelsonjrodrigues.pchud.world;

public enum CarFlags {

    CAR_HEADLIGHT,
    CAR_ENGINE_ACTIVE,
    CAR_ENGINE_WARNING,
    CAR_SPEED_LIMITER,
    CAR_ABS,
    CAR_HANDBRAKE;

    public static CrashState fromCode(int code) {
        return CrashState.values()[code];
    }

}
