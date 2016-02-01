package com.nelsonjrodrigues.pchud.world;

public enum TyreFlags {

    TYRE_ATTACHED,
    TYRE_INFLATED,
    TYRE_IS_ON_GROUND;

    public static TerrainMaterial fromCode(int code) {
        return TerrainMaterial.values()[code];
    }

}
