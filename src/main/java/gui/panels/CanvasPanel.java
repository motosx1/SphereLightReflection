package gui.panels;

import structures.ColorPoint2D;
import structures.Sphere;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class CanvasPanel extends JPanel {

    private final Sphere sphere;

    public CanvasPanel(Sphere spheres) {
        super();
        this.sphere = spheres;
        setBackground(Color.WHITE);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        setCanvasCenter(g2);

        drawSphere(g2, sphere);
    }

    private void drawSphere(Graphics2D g2, Sphere sphere) {
        for (ColorPoint2D point : sphere.getPoints2D()) {
            g2.setColor(point.getColor());
            g2.fillOval((int) point.getPoint2D().getX(), (int) point.getPoint2D().getY(), 2, 2);
        }

        int x = (int) -MainFrame.getCanvasPanelSize().getWidth() / 2 + 20;
        g2.drawString("id: "+sphere.getId(), x, -12);
        g2.drawString("n: "+sphere.getLightParams().getN(), x, 0);
        g2.drawString("kd: "+sphere.getLightParams().getKd(), x, 12);
        g2.drawString("ks: "+sphere.getLightParams().getKs(), x, 24);

    }

    private void setCanvasCenter(Graphics2D g2) {
        AffineTransform tx = new AffineTransform();
        tx.translate(MainFrame.getCanvasPanelSize().getWidth() / (double) 2, MainFrame.getCanvasPanelSize().getHeight() / (double) 3);
        g2.setTransform(tx);
    }

}
