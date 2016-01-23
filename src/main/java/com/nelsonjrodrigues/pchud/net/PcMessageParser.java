package com.nelsonjrodrigues.pchud.net;

import java.net.DatagramPacket;

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

            default:
                break;
        }

        return message;
    }

    private TelemetryData telemetryData(Extractor e) {
        TelemetryData message = new TelemetryData();

        message.gameSessionState(e.u8());

        message.viewedParticipantIndex(e.u8())
               .numParticipants(e.u8());

        message.unfilteredThrottle(e.u8())
               .unfilteredBrake(e.u8())
               .unfilteredSteering(e.u8())
               .unfilteredClutch(e.u8())
               .raceStateFlags(e.u8());

        message.lapsInEvent(e.u8());

        message.bestLapTime(e.f32())
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

        return message;
    }

}
