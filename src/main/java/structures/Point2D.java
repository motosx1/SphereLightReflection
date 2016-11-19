package structures;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

public class Point2D {
    @XmlElement @Getter
    private double x;
    @XmlElement @Getter
    private double y;

    public Point2D() {
    }

    public Point2D(double x, double y){
        this.x = x;
        this.y = y;

    }
}
