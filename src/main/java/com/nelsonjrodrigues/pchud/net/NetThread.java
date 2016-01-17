package com.nelsonjrodrigues.pchud.net;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetThread extends Thread {

    public static final Logger log = LoggerFactory.getLogger(NetThread.class);

    private volatile boolean running;
    private NetListener listener;

    public NetThread() throws IOException {
        super("NetThread");
        this.listener = new NetListener();
    }

    /**
     * Shutdown this thread, will block until it's stopped.
     */
    public void shutdown() {
        if (running) {
            running = false;

            if (listener != null) {
                listener.close();
            }
        }
    }

    @Override
    public void run() {
        running = true;
        log.debug("Starting NetThread loop");
        while (running) {
            try {
                PcMessage listenForMessage = listener.listenForMessage();
                log.debug("Received message {}", listenForMessage);
            } catch (IOException e) {
                log.error("Exception receiving message", e);
            }

        }
    }

}