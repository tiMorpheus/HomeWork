package timur.reader;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MyReader {

    public final static Logger LOGGER = Logger.getLogger(MyReader.class);

    public static String readFile(String filepath){
        LOGGER.info("Trying to get filename: " + filepath);


        String result = "";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filepath)))){
            LOGGER.trace("BufferedReader is ready to read text");
            StringBuilder text = new StringBuilder();

            while (bufferedReader.ready()){
                text.append(bufferedReader.readLine() + "\n");
            }

            result = text.toString();

            LOGGER.trace("file have been read");

        } catch (IOException e){
            LOGGER.info(e);
        }

        return result;
    }


}
