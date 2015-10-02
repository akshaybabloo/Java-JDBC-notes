package xml.propertieFromXML;

import java.io.*;
import java.util.Properties;

/**
 * Created by akshayrajgollahalli on 2/10/15.
 */
public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        InputStream is = null;



        try {
            File file = new File("test.xml");
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            is = null;
        }

        try {
            properties.loadFromXML(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String test = properties.getProperty("Name");
        String test1 = properties.getProperty("CompanyName");
        String test3 = properties.getProperty("Address");
        String test2 = properties.getProperty("ContactNumber");
        System.out.println(test);
        System.out.println(test1);
        System.out.println(test3);
        System.out.println(test2);

    }
}
