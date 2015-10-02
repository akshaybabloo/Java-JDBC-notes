package xml.propertiesToXML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by akshayrajgollahalli on 2/10/15.
 */
public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("CompanyName", "test");
        properties.setProperty("Name", "test name");
        properties.setProperty("Address", "some address");
        properties.setProperty("ContactNumber", "1234567");


        try {
            File file = new File("test.xml");

            FileOutputStream fileOutputStream = null;
            fileOutputStream = new FileOutputStream(file);
            properties.storeToXML(fileOutputStream, "test xml");
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
