package com.nelsonjrodrigues.pchud.world;

import lombok.Data;
import lombok.experimental.Accessors;



@Data
@Accessors(chain = true)
public class ParticipantInfo {

    private boolean isActive;
    private String name;
    private float[] worldPosition;
    private float currentLapDistance;
    private int racePosition;
    private int lapsCompleted;
    private int currentLap;
    private int currentSector;
    
    private String carName;
    private String carClassName;
    private String trackLocation;
    private String trackVariation;

}
