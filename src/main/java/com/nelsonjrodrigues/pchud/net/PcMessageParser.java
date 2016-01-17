package com.nelsonjrodrigues.pchud.net;

public class PcMessageParser {

    public PcMessage fromByteArray(byte[] buffer, int offset, int length) {

        PcMessage message = new PcMessage();

        int buildVersionNumber = ((buffer[0]) << 8) + buffer[1];
        message.setBuildVersionNumber(buildVersionNumber);

        int packetType = buffer[3];
        message.setPacketType(packetType);

        return message;
    }

}
