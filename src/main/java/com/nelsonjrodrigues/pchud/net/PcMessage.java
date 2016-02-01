package com.nelsonjrodrigues.pchud.net;

import lombok.Data;
import lombok.experimental.Accessors;



@Data
@Accessors(fluent = true)
public class PcMessage {

    private String sourceIpAddress;

    private int buildVersionNumber;
    private PacketType packetType;

    private TelemetryData telemetryData;
    
    private ParticipantInfoStrings participantInfoStrings;

    private ParticipantInfoStringsAdditional participantInfoStringsAdditional;

    public static abstract class Constants {
        public static final int VEC_X = 0;
        public static final int VEC_Y = 1;
        public static final int VEC_Z = 2;
        public static final int VEC_MAX = 3;

        public static final int TYRE_FRONT_LEFT = 0;
        public static final int TYRE_FRONT_RIGHT = 1;
        public static final int TYRE_REAR_LEFT = 2;
        public static final int TYRE_REAR_RIGHT = 3;
        public static final int TYRE_MAX = 4;

        public static final int TYRE_ATTACHED = (1 << 0);
        public static final int TYRE_INFLATED = (1 << 1);
        public static final int TYRE_IS_ON_GROUND = (1 << 2);

        public static final int PARTICIPANT_INFO_MAX = 56;
    }

    @Data
    @Accessors(fluent = true)
    public static class TelemetryData {

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

        // Joypad
        private int joypad;

        // Flags
        private int highestFlag;

        // Pit info
        private int pitModeSchedule;

        // Car state
        private int oilTempCelsius;
        private int oilPressureKPa;
        private int waterTempCelsius;
        private int waterPressureKPa;
        private int fuelPressureKPa;
        private int carFlags;
        private int fuelCapacity;
        private int brake;
        private int throttle;
        private int clutch;
        private int steering;
        private float fuelLevel;
        private float speed;
        private int rpm;
        private int maxRpm;
        private int gearNumGears;
        private int boostAmount;
        private int enforcedPitStopLap;
        private int crashState;

        private float odometerKM;
        private float[] orientation;
        private float[] localVelocity;
        private float[] worldVelocity;
        private float[] angularVelocity;
        private float[] localAcceleration;
        private float[] worldAcceleration;
        private float[] extentsCentre;

        // Wheels / Tyres
        private int[] tyreFlags;
        private int[] terrain;
        private float[] tyreY;
        private float[] tyreRPS;
        private float[] tyreSlipSpeed;
        private int[] tyreTemp;
        private int[] tyreGrip;
        private float[] tyreHeightAboveGround;
        private float[] tyreLateralStiffness;
        private int[] tyreWear;
        private int[] brakeDamage;
        private int[] suspensionDamage;
        private int[] brakeTempCelsius;
        private int[] tyreTreadTemp;
        private int[] tyreLayerTemp;
        private int[] tyreCarcassTemp;
        private int[] tyreRimTemp;
        private int[] tyreInternalAirTemp;
        private float[] wheelLocalPositionY;
        private float[] rideHeight;
        private float[] suspensionTravel;
        private float[] suspensionVelocity;
        private int[] airPressure;

        // Extras
        private float engineSpeed;
        private float engineTorque;

        // Car damage
        private int aeroDamage;
        private int engineDamage;

        // Weather
        private int ambientTemperature;
        private int trackTemperature;
        private int rainDensity;
        private int windSpeed;
        private int windDirectionX;
        private int windDirectionY;

        private ParticipantInfo[] participantInfo;

        private float trackLength;
        private int[] wings;
        private int dPad;

    }

    @Data
    @Accessors(fluent = true)
    public static class ParticipantInfo {
        private int[] worldPosition;
        private int currentLapDistance;
        private int racePosition;
        private int lapsCompleted;
        private int currentLap;
        private int sector;
        private float lastSectorTime;
    }

    @Data
    @Accessors(fluent = true)
    public static class ParticipantInfoStrings {
        private String carName;
        private String carClassName;
        private String trackLocation;
        private String trackVariation;
        private String[] name;
    }

    @Data
    @Accessors(fluent = true)
    public static class ParticipantInfoStringsAdditional {
        private int offset;
        private String[] name;
    }

}
