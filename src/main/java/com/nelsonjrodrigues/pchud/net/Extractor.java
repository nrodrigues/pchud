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
        return toUnsignedInt(buffer[offset++]);
    }

    public int u16() {
        return u8() ^
               u8() << 8;
    }

    public float f32() {
        return Float.intBitsToFloat(u8() ^
                                    u8() << 8 ^
                                    u8() << 16 ^
                                    u8() << 24);
    }

}
