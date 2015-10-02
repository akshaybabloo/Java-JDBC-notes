package xmlReader;

import xmlWriter.Customer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by akshayrajgollahalli on 2/10/15.
 */
public class XMLReader {
    public static void main(String[] args) {
        try {
            File file = new File("test.property");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Customer customer = (Customer)jaxbUnmarshaller.unmarshal(file);
            System.out.println(customer.getName());
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
