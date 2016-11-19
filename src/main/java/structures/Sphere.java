package structures;

import algorithms.DisplayAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class Sphere {

    private InitialSphereData initialData;
    private static final int INITIAL_VIEWER_DISTANCE = 600;
    private List<Point3D> points3D = null;
    private List<ColorPoint2D> points2D = null;
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
            for (double x = -radius; x <= radius; x += step) {
                for (double y = -radius; y <= radius; y += step) {
                    for (double z = -radius; z <= 0; z += step) {
                        double pointDistance = (x * x) + (y * y) + (z * z);

                        if (Math.abs(pointDistance - (radius * radius)) <= 5) {

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
            points2D = DisplayAlgorithms.getScaledReflectionStrengths(getPoints3D(), lightParams);
        }

        return points2D;
    }


}
