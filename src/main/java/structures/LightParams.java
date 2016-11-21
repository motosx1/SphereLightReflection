package structures;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

public class LightParams {
    @XmlElement @Getter
    private Point3D lightPosition;
    @XmlElement @Getter
    private double ks;
    @XmlElement @Getter
    private double kd;
    @XmlElement @Getter
    private double n;

    public LightParams() {
    }

    public LightParams(Point3D lightPosition, double ks) {
        this.lightPosition = lightPosition;
        this.ks = ks;
    }
}
