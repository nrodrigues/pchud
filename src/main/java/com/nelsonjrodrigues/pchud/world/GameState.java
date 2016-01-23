package com.nelsonjrodrigues.pchud.world;

public enum GameState {

    GAME_EXITED,
    GAME_FRONT_END,
    GAME_INGAME_PLAYING,
    GAME_INGAME_PAUSED,
    GAME_INGAME_RESTARTING,
    GAME_INGAME_REPLAY,
    GAME_FRONT_END_REPLAY;

    public static GameState fromCode(int code) {
        return GameState.values()[code];
    }

}
