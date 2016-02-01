package com.nelsonjrodrigues.pchud.world;

import java.util.Set;

import lombok.Data;
import lombok.experimental.Accessors;



@Data
@Accessors(fluent = true)
public class Tyre {

    private Set<TyreFlags> tyreFlags;
    private TerrainMaterial terrain;
    private float tyreY;
    private float tyreRPS;
    private float tyreSlipSpeed;
    private int tyreTemp;
    private int tyreGrip;
    private float tyreHeightAboveGround;
    private float tyreLateralStiffness;
    private int tyreWear;
    private int brakeDamage;
    private int suspensionDamage;
    private int brakeTempCelsius;
    private int tyreTreadTemp;
    private int tyreLayerTemp;
    private int tyreCarcassTemp;
    private int tyreRimTemp;
    private int tyreInternalAirTemp;
    private float wheelLocalPositionY;
    private float rideHeight;
    private float suspensionTravel;
    private float suspensionVelocity;
    private int airPressure;

}
