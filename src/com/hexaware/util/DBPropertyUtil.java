package com.hexaware.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBPropertyUtil {
	public static String getPropertyString(String virtualartgallery) {
        Properties properties = new Properties();
        String connectionString = null;

        try (FileInputStream input = new FileInputStream(virtualartgallery)) {
            properties.load(input);
            String hostname = properties.getProperty("localhost");
            String dbname = properties.getProperty("hospitalmanagement");
            String username = properties.getProperty("root");
            String password = properties.getProperty("Diya.jaan@03");
            String port = properties.getProperty("3306");

            connectionString = String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s",
                    hostname, port, dbname, username, password);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as necessary
        }

        return connectionString;
    }
}