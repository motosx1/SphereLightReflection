package structures;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement @ToString
public class Spheres {
    @XmlElement(name = "sphere")
    @Getter
    List<Sphere> spheres = new ArrayList<>();
}
