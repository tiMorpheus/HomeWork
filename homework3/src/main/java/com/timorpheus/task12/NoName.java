package com.timorpheus.task12;

import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NoName {
    Map<String, Byte[] > cache = new HashMap<>();

    public Byte[] getFile(String path){

        Byte[] file = cache.get(path);

        if (file == null){

            try(FileInputStream fileInputStream = new FileInputStream(path)){
                fileInputStream.read();

            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }

        }




        return file;
    }
}
