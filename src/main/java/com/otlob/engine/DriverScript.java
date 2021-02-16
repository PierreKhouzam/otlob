package com.otlob.engine;


import java.io.FileInputStream;
import java.util.Properties;

public class DriverScript {

    public static Properties objectRepo;
    public static String objectRepoPath;

    public static void objectRepoLoad() {
        try {
            objectRepoPath = System.getProperty("user.dir") + "/config/ObjectRepo.txt";
            FileInputStream fs = new FileInputStream(objectRepoPath);
            objectRepo = new Properties(System.getProperties());
            objectRepo.load(fs);

        } catch (Exception e) {
            System.out.println("Couldn't load object Repo " + e.getMessage());
        }
    }


}

