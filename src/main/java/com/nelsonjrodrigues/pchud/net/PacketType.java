package com.nelsonjrodrigues.pchud.net;

public enum PacketType {
    TELEMETRY_DATA, PARTICIPANT_STRINGS, PARTICIPANT_STRING_ADDITIONAL;

    public static PacketType fromCode(int code) {
        return PacketType.values()[code];
    }

}
