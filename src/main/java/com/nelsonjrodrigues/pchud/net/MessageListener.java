package com.nelsonjrodrigues.pchud.net;

public interface MessageListener {

    void onMessage(PcMessage message);

    void onTimeout();

}
