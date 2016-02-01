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

    public int s8() {
        if (offset > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return buffer[offset++];
    }

    public int u8() {
        if (offset > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return Byte.toUnsignedInt(buffer[offset++]);
    }

    public int[] u8(int length) {
        int[] u8 = new int[length];
        for (int i = 0; i < length; i++) {
            u8[i] = u8();
        }
        return u8;
    }

    public int s16() {
        return u8() ^
               s8() << 8;
    }

    public int[] s16(int length) {
        int[] s16 = new int[length];
        for (int i = 0; i < length; i++) {
            s16[i] = s16();
        }
        return s16;
    }

    public int u16() {
        return u8() ^
               u8() << 8;
    }

    public int[] u16(int length) {
        int[] u16 = new int[length];
        for (int i = 0; i < length; i++) {
            u16[i] = u16();
        }
        return u16;
    }

    public float f32() {
        return Float.intBitsToFloat(u8() ^
                                    u8() << 8 ^
                                    u8() << 16 ^
                                    u8() << 24);
    }

    public float[] f32(int length) {
        float[] f32 = new float[length];
        for (int i = 0; i < length; i++) {
            f32[i] = f32();
        }
        return f32;
    }

    public String[] str64(int length) {
        String[] strings = new String[length];
        for(int i=0; i<length; i ++) {
            strings[i] = str64();
        }
        return strings;
    }
    public String str64() {
        return str(64);
    }
    public String str(int length) {
        char[] charArr = new char[length];
        for (int i = 0; i < length; i++) {
            charArr[i] = (char) u8();
        }
        return new String(charArr);
    }
}
