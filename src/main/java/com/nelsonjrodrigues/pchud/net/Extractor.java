package com.nelsonjrodrigues.pchud.net;

public class Extractor {

    private byte[] buffer;
    private int offset;
    private int length;

    public Extractor(byte[] buffer, int offset, int length) {
        this.buffer = buffer;
        this.offset = offset;
        this.length = length;
    }

    public int u8() {
        if (offset > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return Byte.toUnsignedInt(buffer[offset++]);
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
