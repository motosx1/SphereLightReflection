package structures;

import algorithms.DisplayAlgorithms;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Sphere {

    @Getter @XmlElement
    private String id;
    @XmlElement @Getter
    private InitialSphereData initialData;
    private List<Point3D> points3D = null;
    private List<ColorPoint2D> points2D = null;
    @XmlElement @Getter
    private LightParams lightParams = null;


    public Sphere() {
        initialData = new InitialSphereData(new Point3D(0, 0, -200), 50);
        lightParams = new LightParams(new Point3D(30, -20, -400), 0.7);
    }

    public Sphere(InitialSphereData initialData){
        this.initialData = initialData;
        this.lightParams = new LightParams(new Point3D(30, -20, -400), 0.7);
    }

    public List<Point3D> getPoints3D() {
        if (points3D == null) {
            List<Point3D> localPoints3D = new ArrayList<>();

            double radius = initialData.getRadius();
            double xCenter = initialData.getCenterPoint().getX();
            double yCenter = initialData.getCenterPoint().getY();
            double zCenter = initialData.getCenterPoint().getZ();

            double step = 0.1;
            for (double x = -radius-2; x <= radius+2; x += step) {
                for (double y = -radius-2; y <= radius+2; y += step) {
                    for (double z = -radius; z <= 0; z += step) {
                        double pointDistance = (x * x) + (y * y) + (z * z);

                        if (Math.abs(pointDistance - (radius * radius)) <= 6) {

                            localPoints3D.add(new Point3D(x + xCenter, y + yCenter, z + zCenter));
                        }
                    }
                }
            }

            points3D = localPoints3D;

        }

        return points3D;
    }

    public List<ColorPoint2D> getPoints2D() {
        if (points2D == null) {
            points2D = DisplayAlgorithms.getScaledReflectionStrengths(this, lightParams);
        }

        return points2D;
    }


}
