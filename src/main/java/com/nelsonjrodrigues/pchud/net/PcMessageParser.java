package com.nelsonjrodrigues.pchud.net;

public class PcMessageParser {

    public PcMessage fromByteArray(byte[] buffer, int offset) {
        Extractor e = new Extractor(buffer, offset);
        PcMessage message = new PcMessage();

        message.setBuildVersionNumber(e.u16());

        int packetType = e.u8() & 0x3;
        message.setPacketType(packetType);

        return message;
    }

}
