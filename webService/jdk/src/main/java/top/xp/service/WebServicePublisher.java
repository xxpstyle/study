package top.xp.service;

import javax.xml.ws.Endpoint;

public class WebServicePublisher {
    public static void main(String[] args){
        Endpoint endpoint=Endpoint.publish("http://127.0.0.1/webservice/hello",new HelloServiceImpl());
    }
}
