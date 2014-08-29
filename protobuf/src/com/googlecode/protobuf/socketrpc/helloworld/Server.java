package com.googlecode.protobuf.socketrpc.helloworld;

import java.io.IOException;

public class Server {
     public static void main(String[] args) throws IOException {
        RpcServer server = new RpcServer("localhost", 33789);
        MockArithmeticService service = new MockArithmeticService();
        RpcServer.registerServiceImpl(service);
        server.start();
    }
}