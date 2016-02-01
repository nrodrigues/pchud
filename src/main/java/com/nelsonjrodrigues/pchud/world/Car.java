package com.nelsonjrodrigues.pchud.world;

import java.util.Set;

import lombok.Data;
import lombok.experimental.Accessors;



@Data
@Accessors(fluent = true)
public class Car {

    private int oilTempCelsius;
    private int oilPressureKPa;
    private int waterTempCelsius;
    private int waterPressureKPa;
    private int fuelPressureKPa;
    private Set<CarFlags> carFlags;
    private int fuelCapacity;
    private int brake;
    private int throttle;
    private int clutch;
    private int steering;
    private float fuelLevel;
    private float speed;
    private int rpm;
    private int maxRpm;
    private int gear;
    private int numGears;
    private int boostAmount;
    private int enforcedPitStopLap;

    private float engineSpeed;
    private float engineTorque;

    private CrashState crashState;
    private int aeroDamage;
    private int engineDamage;

    private float odometerKM;
    private Vector orientation;
    private Vector localVelocity;
    private Vector worldVelocity;
    private Vector angularVelocity;
    private Vector localAccelaration;
    private Vector worldAccelaration;
    private Vector extentsCentre;

    private Tyre tyreFrontLeft;
    private Tyre tyreFrontRight;
    private Tyre tyreRearLeft;
    private Tyre tyreRearRight;

}
