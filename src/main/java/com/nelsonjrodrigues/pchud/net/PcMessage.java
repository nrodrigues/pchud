package com.nelsonjrodrigues.pchud.net;

public class PcMessage {

    private int buildVersionNumber;
    private int packetType;

    public int getBuildVersionNumber() {
        return buildVersionNumber;
    }

    public void setBuildVersionNumber(int buildVersionNumber) {
        this.buildVersionNumber = buildVersionNumber;
    }

    public int getPacketType() {
        return packetType;
    }

    public void setPacketType(int packetType) {
        this.packetType = packetType;
    }

    @Override
    public String toString() {
        return "PcMessage [buildVersionNumber=" + buildVersionNumber + ", packetType=" + packetType
                + "]";
    }

}
