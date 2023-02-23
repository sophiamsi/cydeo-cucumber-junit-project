package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1 Create object of Properties
    //- make it "private"so we are limiting access to the object
    //-"static" is to make sure it's created and loaded before everything else
    private static Properties properties= new Properties();
    static {

        //we cannot type directly in the class it should go somewhere block, method ,test so we created static block




        try {
            //2 We need to open file in Java memory using File InputStream

            FileInputStream file = new FileInputStream("configuration.properties");
            //3 Load the properties file in the Properties object
            properties.load(file);
            //close the file to save memory.File has been opened , loaded in the object,ready to be used.We can

            file.close();
        } catch (IOException e) {

            System.out.println("FILE NO FOUND WITH GIVEN PATH");
            e.printStackTrace();
        }

    }

    //4Use the"properties" object to read value from file
//create the method to use the object/read
    public static String getProperty(String keyword){
        return  properties.getProperty(keyword);
    }

}
