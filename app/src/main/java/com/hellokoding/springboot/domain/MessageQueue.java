package com.hellokoding.springboot.domain;

public interface MessageQueue {
    void send(CustomMessage customMessage);
}
