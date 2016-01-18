package com.nelsonjrodrigues.pchud.net;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NetThread extends Thread {

    private volatile boolean running;
    private List<MessageListener> listeners = new CopyOnWriteArrayList<>();
    private NetListener listener;

    public NetThread() throws IOException {
        super("NetThread");
        this.listener = new NetListener();
    }

    public void addMessageListener(MessageListener listener) {
        listeners.add(listener);
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
                PcMessage message = listener.listenForMessage(2, TimeUnit.SECONDS);
                fireOnMessage(message);
            } catch (SocketTimeoutException e) {
                fireOnTimeout();
            } catch (IOException e) {
                log.error("Exception receiving message", e);
            }
        }
    }

    private void fireOnMessage(PcMessage message) {
        listeners.forEach(listener -> {
            listener.onMessage(message);
        });
    }

    private void fireOnTimeout() {
        listeners.forEach(MessageListener::onTimeout);
    }

}