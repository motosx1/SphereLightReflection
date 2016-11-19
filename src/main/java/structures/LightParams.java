package structures;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

public class LightParams {
    @XmlElement @Getter
    private Point3D lightPosition;
    @XmlElement @Getter
    private double someParam;

    public LightParams() {
    }

    public LightParams(Point3D lightPosition, double someParam) {
        this.lightPosition = lightPosition;
        this.someParam = someParam;
    }
}
