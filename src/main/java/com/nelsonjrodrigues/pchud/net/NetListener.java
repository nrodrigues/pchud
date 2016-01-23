package com.nelsonjrodrigues.pchud.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.TimeUnit;



/**
 * Listens for Project Cars UDP messages on the network.
 *
 * @author nelson
 *
 */
public class NetListener implements AutoCloseable {

    private static final int MAX_PACKET_SIZE = 1367;

    private DatagramSocket socket;
    private PcMessageParser parser;

    public NetListener() throws IOException {
        this.socket = new DatagramSocket(5606);
        this.parser = new PcMessageParser();
    }

    public PcMessage listenForMessage(long timeout, TimeUnit unit) throws IOException {
        byte[] buffer = new byte[MAX_PACKET_SIZE];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.setSoTimeout((int) unit.toMillis(timeout));
        socket.receive(packet);

        return parser.fromDatagramPacket(packet);
    }

    /**
     * Closes the underlying socket and interrupts a {@link NetListener#listenForMessage()} call.
     * May be called from a different thread.
     *
     */
    @Override
    public void close() {
        socket.close();
    }

}
