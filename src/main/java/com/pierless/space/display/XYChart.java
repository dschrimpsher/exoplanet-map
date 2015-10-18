package com.pierless.space.display;


import com.pierless.space.core.GalacticCoordinate3D;
import com.pierless.space.core.CelestialObject;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * Created by dan.schrimpsher on 1/27/2015.
 */
public class XYChart extends JApplet {


    private final double midpoint = 500;

    ArrayList<DisplayObject> thingsToGraph = new ArrayList<DisplayObject>();


    public ArrayList<DisplayObject> getThingsToGraph() {
        return thingsToGraph;
    }

    public void setThingsToGraph(ArrayList<DisplayObject> thingsToGraph) {
        this.thingsToGraph = thingsToGraph;
    }

    public void addThingsToGraph(DisplayObject thingToGraph) {
        this.thingsToGraph.add(thingToGraph);
    }

    static final Logger logger = Logger.getLogger(XYChart.class);

    private int width = 1100;
    private int height = 1100;

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {

        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.black);

        g2.clearRect(0, 0, width, height);
        g2.translate(midpoint, midpoint + 10.);

        AffineTransform center = g2.getTransform();

        for (DisplayObject celestialObject : thingsToGraph) {
            logger.info("Plotting " + celestialObject.getName() + " " + celestialObject.getX() + "," + celestialObject.getY());
            g2.translate(celestialObject.getX(), -1 * celestialObject.getY());
            g2.setPaint(celestialObject.getColor());
            g2.setStroke(new BasicStroke(5.0f));
            g2.draw(new Ellipse2D.Double(0.5, 0.5, 0.1, 0.1));
            g2.drawString(celestialObject.getName(), 0, 0);
            g2.setTransform(center);
        }
        g2.setTransform(center);
    }

    public void BuildEllipse() {
        JFrame frame = new JFrame("Draw Ellipse Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setSize(new Dimension(width, height));
        frame.setVisible(true);
    }

}
