package xmlWriter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by akshayrajgollahalli on 2/10/15.
 */
@XmlRootElement
public class Customer {
    String name;
    int age;
    int id;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @XmlElement //@XmlAttribute - this  will give an id to the root attribute
    public void setId(int id) {
        this.id = id;
    }
}
