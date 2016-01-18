package com.nelsonjrodrigues.pchud.net;

import lombok.Data;

@Data
public class PcMessage {

    private int buildVersionNumber;
    private int packetType;

}
