package structures;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

public class InitialSphereData {
    @XmlElement @Getter
    private Point3D centerPoint;
    @XmlElement @Getter
    private int radius;
    @XmlElement @Getter
    private int colorR;
    @XmlElement @Getter
    private int colorG;
    @XmlElement @Getter
    private int colorB;

    public InitialSphereData() {
    }

    public InitialSphereData(Point3D centerPoint, int radius) {
        this.centerPoint = centerPoint;
        this.radius = radius;
    }
}
