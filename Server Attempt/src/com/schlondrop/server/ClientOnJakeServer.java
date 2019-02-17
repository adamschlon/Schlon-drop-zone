package com.schlondrop.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientOnJakeServer {

    private static Socket client;

    public static void main(String[] args) {
        try {
            client = new Socket("10.141.63.22", 6969);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream input = null;
        OutputStream output = null;
        String s = "Hi, Jake";
        try {
            input = client.getInputStream();
            output = client.getOutputStream();
            System.out.println(input.read());
//            output.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
