package com.jding05.avaj_launcher.simulator;

import java.io.*;


public class Logger {
    private static PrintWriter writer = null;
    private static final String fileName = "simulate.txt";

    private static PrintWriter getFile() {
        try {
            if (writer == null) {
                writer = new PrintWriter(fileName);
            }
        } catch (IOException ioe){
            System.out.println("failed to create a file");
            ioe.printStackTrace();
        }
        return writer;
    }

    public static void log(String message) {
        getFile().println(message);
    }

     static void close() {
        if (writer != null) {
            writer.close();
        }
    }
}

