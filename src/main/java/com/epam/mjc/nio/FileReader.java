package com.epam.mjc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;


public class FileReader {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(FileReader.class));

    public Profile getDataFromFile(File file) {


        if (!file.exists()) {
            LOGGER.log(LOGGER.getLevel(), "FILE NOT FOUND");
            return null;
        }

        try (FileInputStream in = new FileInputStream(file)) {

            byte[] bytes = in.readAllBytes();

            String res = new String(bytes);


            String[] split = res.split("\n");


            String name = split[0].substring(split[0].lastIndexOf(" ")).trim();

            split[1] = split[1].substring(split[1].lastIndexOf(" ")).trim();

            int age = Integer.parseInt(split[1]);

            String email = split[2].substring(split[2].lastIndexOf(" ")).trim();

            String longStr = split[3].substring(split[3].lastIndexOf(" ")).trim();

            long phone = Long.parseLong(longStr);


            return new Profile(name, age, email, phone);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
