package com.example;

import java.io.IOException;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.load(App.class.getClassLoader().getResourceAsStream("config.properties"));
        System.out.println("Database URL: " + props.getProperty("database.url"));
    }
}