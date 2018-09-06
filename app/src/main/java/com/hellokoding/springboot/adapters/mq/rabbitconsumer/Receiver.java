package com.hellokoding.springboot.adapters.mq.rabbitconsumer;


public interface Receiver {

    public void receiveMessage(String message) throws Exception;

}