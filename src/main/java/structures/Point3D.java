package structures;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

@EqualsAndHashCode(callSuper = false)
public class Point3D extends Point2D {
    @XmlElement @Getter
    private double z;

    public Point3D() {
    }

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + getX() +
                "y=" + getY() +
                "z=" + z +
                '}';
    }
}
