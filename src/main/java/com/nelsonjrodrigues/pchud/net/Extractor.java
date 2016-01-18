package com.nelsonjrodrigues.pchud.net;

import static java.lang.Byte.toUnsignedInt;

public class Extractor {

    private byte[] buffer;
    private int offset;

    public Extractor(byte[] buffer, int offset) {
        this.buffer = buffer;
        this.offset = offset;
    }

    public int u8() {
        int u8 = toUnsignedInt(buffer[offset]);
        offset += 1;

        return u8;
    }

    public int u16() {
        int u16 = (toUnsignedInt(buffer[offset + 1]) << 8) + toUnsignedInt(buffer[offset]);
        offset += 2;

        return u16;
    }

}
