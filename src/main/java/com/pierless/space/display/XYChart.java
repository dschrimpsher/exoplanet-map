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

    ArrayList<CelestialObject> thingsToGraph = new ArrayList<CelestialObject>();

    private int scaleX;
    private int scaleY;

    public int getScaleY() {
        return scaleY;
    }

    public void setScaleY(int scaleY) {
        this.scaleY = scaleY;
        System.out.println("ScaleY: " + this.scaleY);
    }

    public int getScaleX() {
        return scaleX;
    }

    public void setScaleX(int scaleX) {
        this.scaleX = scaleX;
        System.out.println("ScaleX: " + this.scaleX);

    }

    public ArrayList<CelestialObject> getThingsToGraph() {
        return thingsToGraph;
    }

    public void setThingsToGraph(ArrayList<CelestialObject> thingsToGraph) {
        this.thingsToGraph = thingsToGraph;
    }

    public void addThingsToGraph(CelestialObject thingToGraph) {
        this.thingsToGraph.add(thingToGraph);
    }

    static final Logger logger = Logger.getLogger(XYChart.class);

    @Override
    public void paint(Graphics g) {

        BasicConfigurator.configure();



        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.black);

        g2.clearRect(0, 0, 1000, 1000);
        g2.translate(midpoint, midpoint + 10.);

        AffineTransform center = g2.getTransform();


        //First draw the sun
        g2.setPaint(Color.yellow);
        g2.setStroke(new BasicStroke(5.0f));
        g2.draw(new Ellipse2D.Double(0.5, 0.5, 0.1, 0.1));
        g2.drawString("Sol", 0, 0);





        //500 pixels = 7500 parsecs
        //7500/500 = 15 parsecs / pixel
        //Draw the galatic center
        GalacticCoordinate3D galaticCenterCoordinates = new GalacticCoordinate3D();
        galaticCenterCoordinates.setLatitude(0.);
        galaticCenterCoordinates.setLongitude(0.);
        galaticCenterCoordinates.setDistance(8000.);
        

        g2.translate(0.0, -midpoint);
        g2.setPaint(Color.white);
        g2.setStroke(new BasicStroke(5.0f));
        g2.draw(new Ellipse2D.Double(2.0, 2.0, 0.1, 0.1));
        g2.drawString("Galatic Center", 0, 0);
        g2.setTransform(center);



        //17.5, -28.92 is toward the galatic center
        // So 180 + 17.5 or 197.5 is down
        // 90 + 17.5 is left 107.5
        // 270 + 17.5 is right = 287.5

        for (CelestialObject celestialObject : thingsToGraph) {


            logger.info("Plotting " + celestialObject.getName() + " " + celestialObject.getCoordinate3D().toString());
//            System.out.println("Plotting " + star.getName() + " " + star.getCoordinate3D().toString());
            double x = celestialObject.getCoordinate3D().getX();
            double y = celestialObject.getCoordinate3D().getY();
            g2.translate(x*scaleX , -y*scaleY );
            //First draw the sun
            if (celestialObject.getDiameter() > .8)
                g2.setPaint(Color.red);
            else if (celestialObject.getDiameter() > .2)
                g2.setPaint(Color.blue);
            else if (celestialObject.getDiameter() > 0.0)
                g2.setPaint(Color.green);
            else
                g2.setPaint(Color.cyan);
            g2.setStroke(new BasicStroke(5.0f));
            g2.draw(new Ellipse2D.Double(0.5, 0.5, 0.1, 0.1));
            g2.drawString(celestialObject.getName() + celestialObject.getEquatorialCoordinate().getRightAscension(), 0, 0);
            g2.setTransform(center);
        }


        g2.setTransform(center);


    }


    public int time = 0;

    public void updateTime() {
        time++;
        this.repaint();
    }


    public void BuildEllipse() {
        JFrame frame = new JFrame("Draw Ellipse Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        frame.getContentPane().add(this);
        frame.pack();
        frame.setSize(new Dimension(1000, 1000));
        frame.setVisible(true);


    }

}
