package com.nelsonjrodrigues.pchud;

import java.io.IOException;

import com.nelsonjrodrigues.pchud.net.MessageListener;
import com.nelsonjrodrigues.pchud.net.NetThread;
import com.nelsonjrodrigues.pchud.net.PcMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PcHud {

    public static void main(String[] args) {

        try {
            NetThread netThread = new NetThread();
            netThread.addMessageListener(new LogMessageListener());
            netThread.start();

            netThread.join();
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        log.debug("Exiting");

    }

    @Slf4j
    private static class LogMessageListener implements MessageListener {

        @Override
        public void onMessage(PcMessage message) {
            log.debug("OnMessage {}", message);
        }

        @Override
        public void onTimeout() {
            log.debug("OnTimeout");
        }

    }

}
