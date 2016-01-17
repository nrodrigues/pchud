package com.nelsonjrodrigues.pchud;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nelsonjrodrigues.pchud.net.NetThread;

public class PcHud {

    private static final Logger log = LoggerFactory.getLogger(PcHud.class);

    public static void main(String[] args) {

        try {
            NetThread netThread = new NetThread();
            netThread.start();

            netThread.join();
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        log.debug("Exiting");

    }

}
