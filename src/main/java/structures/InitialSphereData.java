package structures;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

public class InitialSphereData {
    @XmlElement @Getter
    private Point3D centerPoint;
    @XmlElement @Getter
    private int radius;

    public InitialSphereData() {
    }

    public InitialSphereData(Point3D centerPoint, int radius) {
        this.centerPoint = centerPoint;
        this.radius = radius;
    }
}
