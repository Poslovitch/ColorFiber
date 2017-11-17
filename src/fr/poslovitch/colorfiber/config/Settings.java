package fr.poslovitch.colorfiber.config;

import fr.poslovitch.colorfiber.ColorFiber;

import java.io.*;
import java.util.Properties;

public class Settings {

    public static String mode;
    public static int outPinRed, outPinGreen, outPinBlue;
    public static int inPinRed, inPinGreen, inPinBlue;

    public static void load() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            File propertiesFile = new File("config.properties");
            if (!propertiesFile.exists()) {
                input = ColorFiber.class.getClassLoader().getResourceAsStream("config.properties");
            } else {
                input = new FileInputStream(propertiesFile.getPath());
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            mode = prop.getProperty("mode");
            outPinRed = Integer.valueOf(prop.getProperty("out-pin-red"));
            outPinGreen = Integer.valueOf(prop.getProperty("out-pin-green"));
            outPinBlue = Integer.valueOf(prop.getProperty("out-pin-blue"));
            inPinRed = Integer.valueOf(prop.getProperty("in-pin-red"));
            inPinGreen = Integer.valueOf(prop.getProperty("in-pin-green"));
            inPinBlue = Integer.valueOf(prop.getProperty("in-pin-blue"));
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void save() {
        Properties prop = new Properties();
        OutputStream output = null;

        try {
            output = new FileOutputStream("config.properties");

            // set the properties value
            prop.setProperty("mode", mode);
            prop.setProperty("out-pin-red", String.valueOf(outPinRed));
            prop.setProperty("out-pin-green", String.valueOf(outPinGreen));
            prop.setProperty("out-pin-blue", String.valueOf(outPinBlue));
            prop.setProperty("in-pin-red", String.valueOf(inPinRed));
            prop.setProperty("in-pin-green", String.valueOf(inPinGreen));
            prop.setProperty("in-pin-blue", String.valueOf(inPinBlue));

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
