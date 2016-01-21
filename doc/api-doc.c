struct sParticipantInfo
{
  s16   sWorldPosition[3];           // 0
  u16   sCurrentLapDistance;         // 6
  u8    sRacePosition;               // 8
  u8    sLapsCompleted;              // 9
  u8    sCurrentLap;                 // 10
  u8    sSector;                     // 11
  f32   sLastSectorTime;             // 14
                                     // 16
};

struct sParticipantInfoStrings
{
  static const			u32 sPacketSize = 1347;
  u16   sBuildVersionNumber;         // 0
  u8    sPacketType;                 // 2
  char  sCarName[64];                // 3
  char  sCarClassName[64];           // 131
  char  sTrackLocation[64];          // 195
  char  sTrackVariation[64];         // 259
  char  sName[16][64];               // 323
                                     // 1347
};

struct sParticipantInfoStringsAdditional
{
  static const             u32 sPacketSize = 1028;
  u16   sBuildVersionNumber;         // 0
  u8    sPacketType;                 // 2
  u8    sOffset;                     // 3
  char  sName[16][64];               // 4				
                                     // 1028
};

struct sTelemetryData
{
  static const            u32 sPacketSize = 1367;
  u16   sBuildVersionNumber;	     // 0
  u8    sPacketType;                  // 2
  
  // Game states
  u8    sGameSessionState;            // 3

  // Participant info
  s8    sViewedParticipantIndex;      // 4
  s8    sNumParticipants;             // 5

  // Unfiltered input
  u8    sUnfilteredThrottle;          // 6
  u8    sUnfilteredBrake;             // 7
  s8    sUnfilteredSteering;          // 8
  u8    sUnfilteredClutch;            // 9
  u8    sRaceStateFlags;              // 10

  // Event information
  u8    sLapsInEvent;                 // 11

  // Timings
  f32   sBestLapTime;                 // 12
  f32   sLastLapTime;                 // 16
  f32   sCurrentTime;                 // 20
  f32   sSplitTimeAhead;              // 24
  f32   sSplitTimeBehind;             // 28
  f32   sSplitTime;                   // 32
  f32   sEventTimeRemaining;          // 36
  f32   sPersonalFastestLapTime;      // 40
  f32   sWorldFastestLapTime;         // 44
  f32   sCurrentSector1Time;          // 48
  f32   sCurrentSector2Time;          // 52
  f32   sCurrentSector3Time;          // 56
  f32   sFastestSector1Time;          // 60
  f32   sFastestSector2Time;          // 64
  f32   sFastestSector3Time;          // 68
  f32   sPersonalFastestSector1Time;  // 72
  f32   sPersonalFastestSector2Time;  // 76
  f32   sPersonalFastestSector3Time;  // 80
  f32   sWorldFastestSector1Time;     // 84
  f32   sWorldFastestSector2Time;     // 88
  f32   sWorldFastestSector3Time;     // 92

  u16   sJoyPad;                      // 96

  // Flags
  u8    sHighestFlag;                 // 98

  // Pit info
  u8    sPitModeSchedule;             // 99

  // Car state
  s16   sOilTempCelsius;              // 100
  u16   sOilPressureKPa;              // 102
  s16   sWaterTempCelsius;            // 104
  u16   sWaterPressureKpa;            // 106
  u16   sFuelPressureKpa;             // 108
  u8    sCarFlags;                    // 110
  u8    sFuelCapacity;                // 111
  u8    sBrake;                       // 112
  u8    sThrottle;                    // 113
  u8    sClutch;                      // 114
  s8    sSteering;                    // 115
  f32   sFuelLevel;                   // 116
  f32   sSpeed;                       // 120
  u16   sRpm;                         // 124
  u16   sMaxRpm;                      // 126
  u8    sGearNumGears;                // 128
  u8    sBoostAmount;                 // 129
  s8    sEnforcedPitStopLap;          // 130
  u8    sCrashState;                  // 131

  f32   sOdometerKM;                  // 132
  f32   sOrientation[3];              // 136
  f32   sLocalVelocity[3];            // 148
  f32   sWorldVelocity[3];            // 160
  f32   sAngularVelocity[3];          // 172
  f32   sLocalAcceleration[3];        // 184
  f32   sWorldAcceleration[3];        // 196
  f32   sExtentsCentre[3];            // 208

  // Wheels / Tyres
  u8    sTyreFlags[4];                // 220
  u8    sTerrain[4];                  // 224
  f32   sTyreY[4];                    // 228
  f32   sTyreRPS[4];                  // 244
  f32   sTyreSlipSpeed[4];            // 260
  u8    sTyreTemp[4];                 // 276
  u8    sTyreGrip[4];                 // 280
  f32   sTyreHeightAboveGround[4];    // 284
  f32   sTyreLateralStiffness[4];     // 300
  u8    sTyreWear[4];                 // 316
  u8    sBrakeDamage[4];              // 320
  u8    sSuspensionDamage[4];         // 324
  s16   sBrakeTempCelsius[4];         // 328
  u16   sTyreTreadTemp[4];            // 336
  u16   sTyreLayerTemp[4];            // 344
  u16   sTyreCarcassTemp[4];          // 352
  u16   sTyreRimTemp[4];              // 360
  u16   sTyreInternalAirTemp[4];      // 368
  f32   sWheelLocalPositionY[4];      // 376
  f32   sRideHeight[4];               // 392
  f32   sSuspensionTravel[4];         // 408
  f32   sSuspensionVelocity[4];       // 424
  u16   sAirPressure[4];              // 440

  // Extras
  f32   sEngineSpeed;                 // 448
  f32   sEngineTorque;                // 452

  // Car damage
  u8    sAeroDamage;                  // 456
  u8    sEngineDamage;                // 457

  // Weather
  s8    sAmbientTemperature;          // 458
  s8    sTrackTemperature;            // 459
  u8    sRainDensity;                 // 460
  s8    sWindSpeed;                   // 461
  s8    sWindDirectionX;              // 462
  s8    sWindDirectionY;              // 463

  sParticipantInfo sParticipantInfo[56];  // 464
                                      // 56*16=896
  f32   sTrackLength;                 // 1360
  u8    sWings[2];                    // 1364
  u8    sDPad;                        // 1366				
                                      // 1368	struct is padded to
};


mBuildVersionNumber=mTelemetryData.sBuildVersionNumber=(u16)pMemory->mBuildVersionNumber;												// u32->u16
mTelemetryData.sPacketType=0|((mCount&63)<<2);																							// Packet type | (sequence<<2)

// Game state
mTelemetryData.sGameSessionState=((u8)pMemory->mGameState)|(((u8)pMemory->mSessionState)<<4);											// (enum 3 bits/enum 3 bits)->u8
mTelemetryData.sRaceStateFlags=((u8)pMemory->mRaceState) |																				// (enum 3 bits)->u8
    (pMemory->mLapInvalidated?8:0)|(pMemory->mAntiLockActive?16:0)|(pMemory->mBoostActive?32:0);										// (bool/bool/bool)->u8

// Participant info
mTelemetryData.sViewedParticipantIndex=(s8)pMemory->mViewedParticipantIndex;															// s32->s8
mTelemetryData.sNumParticipants=(s8)pMemory->mNumParticipants;																			// s32->s8

// Unfiltered input
mTelemetryData.sUnfilteredThrottle=(u8)(Clamp(pMemory->mUnfilteredThrottle, 0.0f, 1.0f)*255.0f);										// f32->u8
mTelemetryData.sUnfilteredBrake=(u8)(Clamp(pMemory->mUnfilteredBrake, 0.0f, 1.0f)*255.0f);												// f32->u8
mTelemetryData.sUnfilteredSteering=(s8)(Clamp(pMemory->mUnfilteredSteering, -1.0f, 1.0f)*127.0f);										// f32->s8
mTelemetryData.sUnfilteredClutch=(u8)(Clamp(pMemory->mUnfilteredClutch, 0.0f, 1.0f)*255.0f);											// f32->u8

// Event information
mTelemetryData.sTrackLength=(f32)pMemory->mTrackLength;																					// f32->f32
mTelemetryData.sLapsInEvent=(u8)min(pMemory->mLapsInEvent,255);																			// u32->u8

// Timings
mTelemetryData.sBestLapTime=pMemory->mBestLapTime;																						// f32->f32
mTelemetryData.sLastLapTime=pMemory->mLastLapTime;																						// f32->f32
mTelemetryData.sCurrentTime=pMemory->mCurrentTime;																						// f32->f32
mTelemetryData.sSplitTimeAhead=pMemory->mSplitTimeAhead;																				// f32->f32
mTelemetryData.sSplitTimeBehind=pMemory->mSplitTimeBehind;																				// f32->f32
mTelemetryData.sSplitTime=pMemory->mSplitTime;																							// f32->f32
mTelemetryData.sEventTimeRemaining=pMemory->mEventTimeRemaining;																		// f32->f32
mTelemetryData.sPersonalFastestLapTime=pMemory->mPersonalFastestLapTime;																// f32->f32
mTelemetryData.sWorldFastestLapTime=pMemory->mWorldFastestLapTime;																		// f32->f32
mTelemetryData.sCurrentSector1Time=pMemory->mCurrentSector1Time;																		// f32->f32
mTelemetryData.sCurrentSector2Time=pMemory->mCurrentSector2Time;																		// f32->f32
mTelemetryData.sCurrentSector3Time=pMemory->mCurrentSector3Time;																		// f32->f32
mTelemetryData.sFastestSector1Time=pMemory->mFastestSector1Time;																		// f32->f32
mTelemetryData.sFastestSector2Time=pMemory->mFastestSector2Time;																		// f32->f32
mTelemetryData.sFastestSector3Time=pMemory->mFastestSector3Time;																		// f32->f32
mTelemetryData.sPersonalFastestSector1Time=pMemory->mPersonalFastestSector1Time;														// f32->f32
mTelemetryData.sPersonalFastestSector2Time=pMemory->mPersonalFastestSector2Time;														// f32->f32
mTelemetryData.sPersonalFastestSector3Time=pMemory->mPersonalFastestSector3Time;														// f32->f32
mTelemetryData.sWorldFastestSector1Time=pMemory->mWorldFastestSector1Time;																// f32->f32
mTelemetryData.sWorldFastestSector2Time=pMemory->mWorldFastestSector2Time;																// f32->f32
mTelemetryData.sWorldFastestSector3Time=pMemory->mWorldFastestSector3Time;																// f32->f32

// Flags
mTelemetryData.sHighestFlag=((u8)pMemory->mHighestFlagColour) | (((u8)pMemory->mHighestFlagReason)<<4);									// (enum 3 bits/enum 2 bits)

// Pit info
mTelemetryData.sPitModeSchedule=((u8)pMemory->mPitMode) | (((u8)pMemory->mPitSchedule)<<4);												// (enum 3 bits/enum 2 bits)

// Car state
mTelemetryData.sCarFlags=(u8)pMemory->mCarFlags;																						// enum->u8
mTelemetryData.sOilTempCelsius=(s16)pMemory->mOilTempCelsius;																			// f32->s16
mTelemetryData.sOilPressureKPa=(u16)pMemory->mOilPressureKPa;																			// f32->u16
mTelemetryData.sWaterTempCelsius=(s16)pMemory->mWaterTempCelsius;																		// f32->s16
mTelemetryData.sWaterPressureKpa=(u16)pMemory->mWaterPressureKPa;																		// f32->u16
mTelemetryData.sFuelPressureKpa=(u16)pMemory->mFuelPressureKPa;																			// f32->u16
mTelemetryData.sFuelCapacity=(u8)pMemory->mFuelCapacity;																				// f32->u8
mTelemetryData.sBrake=(u8)(Clamp(pMemory->mBrake, 0.0f, 1.0f)*255.0f);																	// f32->u8
mTelemetryData.sFuelLevel=pMemory->mFuelLevel;																							// f32->f32
mTelemetryData.sSpeed=pMemory->mSpeed;																									// f32->f32
mTelemetryData.sRpm=(u16)pMemory->mRpm;																									// f32->u16
mTelemetryData.sMaxRpm=(u16)pMemory->mMaxRPM;																							// f32->u16
mTelemetryData.sThrottle=(u8)(Clamp(pMemory->mThrottle, 0.0f, 1.0f)*255.0f);															// f32->u8
mTelemetryData.sClutch=(u8)(Clamp(pMemory->mClutch, 0.0f, 1.0f)*255.0f);																// f32->u8
mTelemetryData.sSteering=(s8)(Clamp(pMemory->mSteering, -1.0f, 1.0f)*127.0f);															// f32->s8
u8 gear=pMemory->mGear<0?0x0f:min((u8)(pMemory->mGear&0xff), 7);
u8 numGears=max((u8)(pMemory->mNumGears&0xff), 0);
mTelemetryData.sGearNumGears=(gear&0x0f)|((numGears&0x0f)<<4);																			// s32/s32->u8
mTelemetryData.sOdometerKM=pMemory->mOdometerKM;																						// f32->f32
mTelemetryData.sBoostAmount=(u8)pMemory->mBoostAmount;																					// f32->u8
mTelemetryData.sOrientation[0]=pMemory->mOrientation[0];																				// f32->f32
mTelemetryData.sOrientation[1]=pMemory->mOrientation[1];																				// f32->f32
mTelemetryData.sOrientation[2]=pMemory->mOrientation[2];																				// f32->f32
mTelemetryData.sLocalVelocity[0]=pMemory->mLocalVelocity[0];																			// f32->f32
mTelemetryData.sLocalVelocity[1]=pMemory->mLocalVelocity[1];																			// f32->f32
mTelemetryData.sLocalVelocity[2]=pMemory->mLocalVelocity[2];																			// f32->f32
mTelemetryData.sWorldVelocity[0]=pMemory->mWorldVelocity[0];																			// f32->f32
mTelemetryData.sWorldVelocity[1]=pMemory->mWorldVelocity[1];																			// f32->f32
mTelemetryData.sWorldVelocity[2]=pMemory->mWorldVelocity[2];																			// f32->f32
mTelemetryData.sAngularVelocity[0]=pMemory->mAngularVelocity[0];																		// f32->f32
mTelemetryData.sAngularVelocity[1]=pMemory->mAngularVelocity[1];																		// f32->f32
mTelemetryData.sAngularVelocity[2]=pMemory->mAngularVelocity[2];																		// f32->f32
mTelemetryData.sLocalAcceleration[0]=pMemory->mLocalAcceleration[0];																	// f32->f32
mTelemetryData.sLocalAcceleration[1]=pMemory->mLocalAcceleration[1];																	// f32->f32
mTelemetryData.sLocalAcceleration[2]=pMemory->mLocalAcceleration[2];																	// f32->f32
mTelemetryData.sWorldAcceleration[0]=pMemory->mWorldAcceleration[0];																	// f32->f32
mTelemetryData.sWorldAcceleration[1]=pMemory->mWorldAcceleration[1];																	// f32->f32
mTelemetryData.sWorldAcceleration[2]=pMemory->mWorldAcceleration[2];																	// f32->f32
mTelemetryData.sExtentsCentre[0]=pMemory->mExtentsCentre[0];																			// f32->f32
mTelemetryData.sExtentsCentre[1]=pMemory->mExtentsCentre[1];																			// f32->f32
mTelemetryData.sExtentsCentre[2]=pMemory->mExtentsCentre[2];																			// f32->f32

// Wheels / Tyres
u32 i;
for (i=0;i<4;i++)
{
    mTelemetryData.sTyreFlags[i]=(u8)pMemory->mTyreFlags[i];																			// (enum 3 bits)->u8
    mTelemetryData.sTerrain[i]=(u8)pMemory->mTerrain[i];																				// (enum 6 bits)->u8
    mTelemetryData.sTyreY[i]=pMemory->mTyreY[i];																						// f32->f32
    mTelemetryData.sTyreRPS[i]=pMemory->mTyreRPS[i];																					// f32->f32
    mTelemetryData.sTyreSlipSpeed[i]=pMemory->mTyreSlipSpeed[i];																		// f32->f32
    mTelemetryData.sTyreTemp[i]=(u8)Clamp(pMemory->mTyreTemp[i], 0.0f, 255.0f);															// f32->u8
    mTelemetryData.sTyreGrip[i]=(u8)Clamp(pMemory->mTyreGrip[i], 0.0f, 1.0f)*255.0f);													// f32->u8
    mTelemetryData.sTyreHeightAboveGround[i]=pMemory->mTyreHeightAboveGround[i];														// f32->f32
    mTelemetryData.sTyreLateralStiffness[i]=pMemory->mTyreLateralStiffness[i];															// f32->f32
    mTelemetryData.sTyreWear[i]=(u8)(Clamp(pMemory->mTyreWear[i], 0.0f, 1.0f)*255.0f);													// f32->u8
    mTelemetryData.sBrakeDamage[i]=(u8)(Clamp(pMemory->mBrakeDamage[i], 0.0f, 1.0f)*255.0f);											// f32->u8
    mTelemetryData.sSuspensionDamage[i]=(u8)(Clamp(pMemory->mSuspensionDamage[i], 0.0f, 1.0f)*255.0f);									// f32->u8
    mTelemetryData.sBrakeTempCelsius[i]=(s16)pMemory->mBrakeTempCelsius[i];																// f32->s16
    mTelemetryData.sTyreTreadTemp[i]=(u16)pMemory->mTyreTreadTemp[i];																	// f32->u16
    mTelemetryData.sTyreLayerTemp[i]=(u16)pMemory->mTyreLayerTemp[i];																	// f32->u16
    mTelemetryData.sTyreCarcassTemp[i]=(u16)pMemory->mTyreCarcassTemp[i];																// f32->u16
    mTelemetryData.sTyreRimTemp[i]=(u16)pMemory->mTyreRimTemp[i];																		// f32->u16
    mTelemetryData.sTyreInternalAirTemp[i]=(u16)pMemory->mTyreInternalAirTemp[i];														// f32->u16
    mTelemetryData.sWheelLocalPositionY[i]=pMemoryExtras->mWheelLocalPositionY[i];														// f32->f32
    mTelemetryData.sRideHeight[i]=pMemoryExtras->mRideHeight[i];																		// f32->f32
    mTelemetryData.sSuspensionTravel[i]=pMemoryExtras->mSuspensionTravel[i];															// f32->f32
    mTelemetryData.sSuspensionVelocity[i]=pMemoryExtras->mSuspensionVelocity[i];														// f32->f32
    mTelemetryData.sAirPressure[i]=pMemoryExtras->mAirPressure[i];																		// f32->u16
}

// Extras
mTelemetryData.sEngineSpeed=pMemoryExtras->mEngineSpeed;																				// f32->f32
mTelemetryData.sEngineTorque=pMemoryExtras->mEngineTorque;																				// f32->f32
mTelemetryData.sWings[0]=pMemoryExtras->mWings[0];																						// f32->u8
mTelemetryData.sWings[1]=pMemoryExtras->mWings[1];																						// f32->u8
mTelemetryData.sEnforcedPitStopLap=(s8)pMemoryExtras->mEnforcedPitStopLap;																// S32->s8

//Car damage
mTelemetryData.sCrashState=(u8)pMemory->mCrashState;																					// (enum 3 bits)->u8
mTelemetryData.sAeroDamage=(u8)(Clamp(pMemory->mAeroDamage, 0.0f, 1.0f)*255.0f);														// f32->u8
mTelemetryData.sEngineDamage=(u8)(Clamp(pMemory->mEngineDamage, 0.0f, 1.0f)*255.0f);													// f32->u8

// Weather
mTelemetryData.sAmbientTemperature=(s8)Clamp(pMemory->mAmbientTemperature, -127.0f, 127.0f);											// f32->s8
mTelemetryData.sTrackTemperature=(s8)Clamp(pMemory->mTrackTemperature, -127.0f, 127.0f);												// f32->s8
mTelemetryData.sRainDensity=(u8)(Clamp(pMemory->mRainDensity, 0.0f, 1.0f)*255.0f);														// f32->u8
mTelemetryData.sWindSpeed=(u8)(Clamp(pMemory->mWindSpeed*0.5f, 0.0f, 255.0f));															// f32->u8
mTelemetryData.sWindDirectionX=(s8)Clamp(pMemory->mWindDirectionX*127.0f, -127.0f, 127.0f);												// f32->s8
mTelemetryData.sWindDirectionY=(s8)Clamp(pMemory->mWindDirectionY*127.0f, -127.0f, 127.0f);												// f32->s8

for (i=0;i<(u32)Clamp(pMemory->mNumParticipants, 0, 56);i++)
{
    mTelemetryData.sParticipantInfo[i].sWorldPosition[0]=(s16)Clamp(pMemory->mParticipantInfo[i].mWorldPosition[0], -32768.0f, 32767.0f);	// f32->s16
    mTelemetryData.sParticipantInfo[i].sWorldPosition[1]=(s16)Clamp(pMemory->mParticipantInfo[i].mWorldPosition[1], -32768.0f, 32767.0f);	// f32->s16
    mTelemetryData.sParticipantInfo[i].sWorldPosition[2]=(s16)Clamp(pMemory->mParticipantInfo[i].mWorldPosition[2], -32768.0f, 32767.0f);	// f32->s16
    mTelemetryData.sParticipantInfo[i].sCurrentLapDistance=(u16)min(pMemory->mParticipantInfo[i].mCurrentLapDistance, 65535.0f);			// f32->u16
    mTelemetryData.sParticipantInfo[i].sRacePosition=((u8)pMemory->mParticipantInfo[i].mRacePosition)|(pMemory->mParticipantInfo[i].mIsActive?128:0);	// u32+bool->u8 (top bit is active)
    mTelemetryData.sParticipantInfo[i].sLapsCompleted=((u8)min(pMemory->mParticipantInfo[i].mLapsCompleted, 127))|(pMemoryExtras->mLapInvalidated[i]?128:0);	// u32+bool->u8 (top bit is lap invalidated)
    mTelemetryData.sParticipantInfo[i].sCurrentLap=(u8)min(pMemory->mParticipantInfo[i].mCurrentLap, 255);								// u32->u8
    mTelemetryData.sParticipantInfo[i].sSector=(u8)pMemory->mParticipantInfo[i].mCurrentSector;											// (enum 3 bits)->u8
    // Extra accuracy bits for x/z
    u32 x=((u32)floorf(pMemory->mParticipantInfo[i].mWorldPosition[0]*4.0f))&3;
    u32 z=((u32)floorf(pMemory->mParticipantInfo[i].mWorldPosition[2]*4.0f))&3;
    mTelemetryData.sParticipantInfo[i].sSector=((u8)pMemory->mParticipantInfo[i].mCurrentSector)|((u8)x<<6)|((u8)z<<4);					// (enum 3 bits)+(x 2 bits, z 2 bits)->u8
    mTelemetryData.sParticipantInfo[i].sLastSectorTime=pMemoryExtras->mLastSectorTime[i];													// f32->f32
}

mTelemetryData.sJoyPad=(u16)JOYPAD BUTTON MASK
mTelemetryData.sDPad=(u8)JOYPAD DPAD MASK

// This packet below is sent less often
BStrcpy(mParticipantStrings.sCarName, 64, pMemory->mCarName);
BStrcpy(mParticipantStrings.sCarClassName, 64, pMemory->mCarClassName);
BStrcpy(mParticipantStrings.sTrackLocation, 64, pMemory->mTrackLocation);
BStrcpy(mParticipantStrings.sTrackVariation, 64, pMemory->mTrackVariation);
for (i=0;i<(u32)Clamp(pMemory->mNumParticipants, 0, 16);i++)
{
    BStrcpy(mParticipantStrings.sName[i], 64, pMemory->mParticipantInfo[i].mName);
}
mParticipantStrings.sBuildVersionNumber=mBuildVersionNumber;
mParticipantStrings.sPacketType=1|((mCount&63)<<2);																																		// Packet type | (sequence<<2)


// These extra packets are sent if participants>16
for (groups of 16)
{
    BStrcpy(mParticipantStringsAdditional.sName[i], 64, pMemory->mParticipantInfo[i].mName);
}
mParticipantStringsAdditional.sOffset=(u8)OFFSET IN 16's, so 1st packet of this type offset will be 16, 2nd 32 etc
mParticipantStringsAdditional.sBuildVersionNumber=mBuildVersionNumber;
mParticipantStringsAdditional.sPacketType=2|((mCount&63)<<2);																													// Packet type | (sequence<<2)
