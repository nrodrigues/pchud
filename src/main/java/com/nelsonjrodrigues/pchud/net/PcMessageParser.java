package com.nelsonjrodrigues.pchud.net;

import static com.nelsonjrodrigues.pchud.net.PcMessage.Constants.PARTICIPANT_INFO_MAX;
import static com.nelsonjrodrigues.pchud.net.PcMessage.Constants.TYRE_MAX;
import static com.nelsonjrodrigues.pchud.net.PcMessage.Constants.VEC_MAX;

import java.net.DatagramPacket;

import com.nelsonjrodrigues.pchud.net.PcMessage.ParticipantInfo;
import com.nelsonjrodrigues.pchud.net.PcMessage.ParticipantInfoStrings;
import com.nelsonjrodrigues.pchud.net.PcMessage.ParticipantInfoStringsAdditional;
import com.nelsonjrodrigues.pchud.net.PcMessage.TelemetryData;



public class PcMessageParser {

    public PcMessage fromDatagramPacket(DatagramPacket packet) {
        Extractor e = new Extractor(packet.getData(), packet.getOffset(), packet.getLength());

        PcMessage message = new PcMessage();

        message.sourceIpAddress(packet.getAddress().getHostAddress());

        message.buildVersionNumber(e.u16())
               .packetType(PacketType.fromCode(e.u8() & 0x3));

        switch (message.packetType()) {
            case TELEMETRY_DATA:
                message.telemetryData(telemetryData(e));
                break;
            case PARTICIPANT_STRINGS:
                message.participantInfoStrings(participantInfoStrings(e));
                break;
            case PARTICIPANT_STRING_ADDITIONAL:
                message.participantInfoStringsAdditional(participantInfoStringsAdditional(e));
                break;
            default:
                break;
        }

        return message;
    }

    private ParticipantInfoStringsAdditional participantInfoStringsAdditional(Extractor e) {
        ParticipantInfoStringsAdditional pisa = new ParticipantInfoStringsAdditional();

        pisa.offset(e.u8());
        pisa.name(e.str64(16));

        return pisa;
    }

    private ParticipantInfoStrings participantInfoStrings(Extractor e) {
        ParticipantInfoStrings pis = new ParticipantInfoStrings();

        pis.carName(e.str64());
        pis.carClassName(e.str64());
        pis.trackLocation(e.str64());
        pis.trackVariation(e.str64());
        pis.name(e.str64(16));

        return pis;
    }

    private TelemetryData telemetryData(Extractor e) {
        TelemetryData td = new TelemetryData();

        td.gameSessionState(e.u8());

        td.viewedParticipantIndex(e.s8())
          .numParticipants(e.s8());

        td.unfilteredThrottle(e.u8())
          .unfilteredBrake(e.u8())
          .unfilteredSteering(e.s8())
          .unfilteredClutch(e.u8())
          .raceStateFlags(e.u8());

        td.lapsInEvent(e.u8());

        td.bestLapTime(e.f32())
          .lastLapTime(e.f32())
          .currentTime(e.f32())
          .splitTimeAhead(e.f32())
          .splitTimeBehind(e.f32())
          .splitTime(e.f32())
          .eventTimeRemaining(e.f32())
          .personalFastestLapTime(e.f32())
          .worldFastestLapTime(e.f32())
          .currentSector1Time(e.f32())
          .currentSector2Time(e.f32())
          .currentSector3Time(e.f32())
          .fastestSector1Time(e.f32())
          .fastestSector2Time(e.f32())
          .fastestSector3Time(e.f32())
          .personalFastestSector1Time(e.f32())
          .personalFastestSector2Time(e.f32())
          .personalFastestSector3Time(e.f32())
          .worldFastestSector1Time(e.f32())
          .worldFastestSector2Time(e.f32())
          .worldFastestSector3Time(e.f32());

        td.joypad(e.u16());

        td.highestFlag(e.u8());

        td.pitModeSchedule(e.u8());

        td.oilTempCelsius(e.s16())
          .oilPressureKPa(e.u16())
          .waterTempCelsius(e.s16())
          .waterPressureKPa(e.u16())
          .fuelPressureKPa(e.u16())
          .carFlags(e.u8())
          .fuelCapacity(e.u8())
          .brake(e.u8())
          .throttle(e.u8())
          .clutch(e.u8())
          .steering(e.s8())
          .fuelLevel(e.f32())
          .speed(e.f32())
          .rpm(e.u16())
          .maxRpm(e.u16())
          .gearNumGears(e.u8())
          .boostAmount(e.u8())
          .enforcedPitStopLap(e.s8())
          .crashState(e.s8());

        td.odometerKM(e.f32())
          .orientation(e.f32(VEC_MAX))
          .localVelocity(e.f32(VEC_MAX))
          .worldVelocity(e.f32(VEC_MAX))
          .angularVelocity(e.f32(VEC_MAX))
          .localAcceleration(e.f32(VEC_MAX))
          .worldAcceleration(e.f32(VEC_MAX))
          .extentsCentre(e.f32(VEC_MAX));

        td.tyreFlags(e.u8(TYRE_MAX))
          .terrain(e.u8(TYRE_MAX))
          .tyreY(e.f32(TYRE_MAX))
          .tyreRPS(e.f32(TYRE_MAX))
          .tyreSlipSpeed(e.f32(TYRE_MAX))
          .tyreTemp(e.u8(TYRE_MAX))
          .tyreGrip(e.u8(TYRE_MAX))
          .tyreHeightAboveGround(e.f32(TYRE_MAX))
          .tyreLateralStiffness(e.f32(TYRE_MAX))
          .tyreWear(e.u8(TYRE_MAX))
          .brakeDamage(e.u8(TYRE_MAX))
          .suspensionDamage(e.u8(TYRE_MAX))
          .brakeTempCelsius(e.s16(TYRE_MAX))
          .tyreTreadTemp(e.u16(TYRE_MAX))
          .tyreLayerTemp(e.u16(TYRE_MAX))
          .tyreCarcassTemp(e.u16(TYRE_MAX))
          .tyreRimTemp(e.u16(TYRE_MAX))
          .tyreInternalAirTemp(e.u16(TYRE_MAX))
          .wheelLocalPositionY(e.f32(TYRE_MAX))
          .rideHeight(e.f32(TYRE_MAX))
          .suspensionTravel(e.f32(TYRE_MAX))
          .suspensionVelocity(e.f32(TYRE_MAX))
          .airPressure(e.u16(TYRE_MAX));

        td.engineSpeed(e.f32())
          .engineTorque(e.f32());

        td.ambientTemperature(e.s8())
          .trackTemperature(e.s8())
          .rainDensity(e.u8())
          .windSpeed(e.s8())
          .windDirectionX(e.s8())
          .windDirectionY(e.s8());

        td.participantInfo(participantInfo(PARTICIPANT_INFO_MAX, e));

        td.trackLength(e.f32())
          .wings(e.u8(2))
          .dPad(e.u8());

        return td;
    }

    private ParticipantInfo[] participantInfo(int length, Extractor e) {
        ParticipantInfo[] pi = new ParticipantInfo[length];
        for (int i = 0; i < length; i++) {
            pi[i] = participantInfo(e);
        }
        return pi;
    }

    private ParticipantInfo participantInfo(Extractor e) {
        ParticipantInfo pi = new ParticipantInfo();

        pi.worldPosition(e.s16(VEC_MAX))
          .currentLapDistance(e.u16())
          .racePosition(e.u8())
          .lapsCompleted(e.u8())
          .currentLap(e.u8())
          .sector(e.u8())
          .lastSectorTime(e.f32());

        return pi;
    }

}
