package algorithms;


import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import structures.*;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.apache.commons.math3.geometry.euclidean.threed.Vector3D.crossProduct;
import static org.apache.commons.math3.geometry.euclidean.threed.Vector3D.dotProduct;

public class DisplayAlgorithms {
    private DisplayAlgorithms() {
    }

    public static Point2D transformPointTo2D(Point3D point, double viewerDistance) {
        Double newX = (point.getX() * viewerDistance) / point.getZ();
        Double newY = (point.getY() * viewerDistance) / point.getZ();

        return new Point2D(newX, newY);
    }


    public static Map<Integer, Point3D> translation(Map<Integer, Point3D> points, double[][] v) {
        Map<Integer, Point3D> newPoints = new HashMap<Integer, Point3D>();

        for (Map.Entry<Integer, Point3D> point : points.entrySet()) {
            Point3D transformedPoint = translatePoint(point.getValue(), v);
            newPoints.put(point.getKey(), transformedPoint);
        }

        return newPoints;
    }

    private static Point3D translatePoint(Point3D point, double[][] v) {
        RealMatrix translationMatrix = MatrixUtils.createRealMatrix(v);
        RealMatrix oldPointMatrix = convertToMatrix(point);

        RealMatrix resultPointMatrix = translationMatrix.multiply(oldPointMatrix);

        return convertToPoint3D(resultPointMatrix);
    }

    private static Point3D convertToPoint3D(RealMatrix resultPointMatrix) {
        double[][] data = resultPointMatrix.getData();
        return new Point3D(data[0][0], data[1][0], data[2][0]);

    }

    private static RealMatrix convertToMatrix(Point3D point) {
        double[][] matrixData = new double[4][1];

        matrixData[0][0] = point.getX();
        matrixData[1][0] = point.getY();
        matrixData[2][0] = point.getZ();
        matrixData[3][0] = 1;

        return MatrixUtils.createRealMatrix(matrixData);
    }


    public static List<ColorPoint2D> getScaledReflectionStrengths(List<Point3D> spherePixels, LightParams lightParams) {
        java.util.List<ReflectionPoint3D> reflectionStrengths = new ArrayList<>();
        java.util.List<ColorPoint2D> colorPoints2D = new ArrayList<>();

        for (Point3D spherePixel : spherePixels) {

            Vector3D nVec = new Vector3D(spherePixel.getX(), spherePixel.getY(), spherePixel.getZ());
            Point3D lightPosition = lightParams.getLightPosition();
            Vector3D lVec = new Vector3D(lightPosition.getX() - spherePixel.getX(), lightPosition.getY() - spherePixel.getY(), lightPosition.getZ() - spherePixel.getZ());

            double angle = Math.acos(dotProduct(nVec.normalize(), lVec.normalize()));
            Vector3D cross = crossProduct(nVec, lVec);
            if (dotProduct(lVec, cross) < 0) { // Or > 0
                angle = -angle;
            }

            double lightStrength = (0.0001 * 1 * dotProduct(lVec, nVec) + 10 * Math.pow(Math.cos(angle),10));
            reflectionStrengths.add(new ReflectionPoint3D(spherePixel, lightStrength));
        }

        ReflectionPoint3D reflectionMax = Collections.max(reflectionStrengths, (p1, p2) -> (int) (p1.getReflectionStrength() - p2.getReflectionStrength()));
        ReflectionPoint3D reflectionMin = Collections.min(reflectionStrengths, (p1, p2) -> (int) (p1.getReflectionStrength() - p2.getReflectionStrength()));

//        System.out.println("reflectionMax: " + reflectionMax);

        double translationToZero = -reflectionMin.getReflectionStrength();
//        double range = 16 - reflectionMin.getReflectionStrength();
        double range = reflectionMax.getReflectionStrength() - reflectionMin.getReflectionStrength();

        for (ReflectionPoint3D reflectionStrength : reflectionStrengths) {
            int c = (int)((reflectionStrength.getReflectionStrength() + translationToZero) / (range / 255));

            if( c < 0 ){
                c = 0;
            }
            if( c > 255 ){
                c = 255;
            }
            colorPoints2D.add(new ColorPoint2D(transformPointTo2D(reflectionStrength.getPoint3D(), 600), new Color(c,c,c)));
        }

        return colorPoints2D;
    }

}
