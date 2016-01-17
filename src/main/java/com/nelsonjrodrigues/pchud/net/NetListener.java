package com.nelsonjrodrigues.pchud.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Listens for Project Cars UDP messages on the network.
 *
 * @author nelson
 *
 */
public class NetListener implements AutoCloseable {

    private static final int MAX_PACKET_SIZE = 1367;

    private DatagramSocket ms;
    private PcMessageParser parser;

    public NetListener() throws IOException {
        this.ms = new DatagramSocket(5606);
        this.parser = new PcMessageParser();
    }

    public PcMessage listenForMessage() throws IOException {
        byte[] buffer = new byte[MAX_PACKET_SIZE];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        ms.receive(packet);

        return parser.fromByteArray(packet.getData(), packet.getOffset(), packet.getLength());
    }

    /**
     * Closes the underlying socket and interrupts a
     * {@link NetListener#listenForMessage()} call. May be called from a
     * different thread.
     *
     */
    @Override
    public void close() {
        ms.close();
    }

}
