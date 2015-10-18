package com.pierless.space.display;

import com.pierless.space.core.CelestialObject;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dschrimpsher on 7/26/15.
 */
public class TestXYChart {

    ArrayList<DisplayObject> displayObjectArrayList;

    @Before
    public void setup() {
        PropertyConfigurator.configure("log4j.properties");
        displayObjectArrayList = new ArrayList<DisplayObject>();

        DisplayObject displayObject = new DisplayObject();
        displayObject.setName("Test Center");
        displayObject.setColor(Color.ORANGE);
        displayObject.setX(0);
        displayObject.setY(0);
        displayObjectArrayList.add(displayObject);

        displayObject = new DisplayObject();
        displayObject.setName("Test Right");
        displayObject.setColor(Color.RED);
        displayObject.setX(500);
        displayObject.setY(0);
        displayObjectArrayList.add(displayObject);

        displayObject = new DisplayObject();
        displayObject.setName("Test Left");
        displayObject.setColor(Color.GREEN);
        displayObject.setX(-500);
        displayObject.setY(0);
        displayObjectArrayList.add(displayObject);

        displayObject = new DisplayObject();
        displayObject.setName("Test Top");
        displayObject.setColor(Color.BLUE);
        displayObject.setX(0);
        displayObject.setY(500);
        displayObjectArrayList.add(displayObject);

        displayObject = new DisplayObject();
        displayObject.setName("Test Bottom");
        displayObject.setColor(Color.MAGENTA);
        displayObject.setX(0);
        displayObject.setY(-500);
        displayObjectArrayList.add(displayObject);


        displayObject = new DisplayObject();
        displayObject.setName("Test Bottom/Right");
        displayObject.setColor(Color.MAGENTA);
        displayObject.setX(500);
        displayObject.setY(-500);
        displayObjectArrayList.add(displayObject);

        displayObject = new DisplayObject();
        displayObject.setName("Test Bottom/Left");
        displayObject.setColor(Color.MAGENTA);
        displayObject.setX(-500);
        displayObject.setY(-500);
        displayObjectArrayList.add(displayObject);

        displayObject = new DisplayObject();
        displayObject.setName("Test Top/Right");
        displayObject.setColor(Color.MAGENTA);
        displayObject.setX(500);
        displayObject.setY(500);
        displayObjectArrayList.add(displayObject);

        displayObject = new DisplayObject();
        displayObject.setName("Test Top/Left");
        displayObject.setColor(Color.MAGENTA);
        displayObject.setX(-500);
        displayObject.setY(500);
        displayObjectArrayList.add(displayObject);
    }

    @Test
    public void testChart() {
        XYChart xyChart = new XYChart();
        for (DisplayObject displayObject : displayObjectArrayList) {
            xyChart.addThingsToGraph(displayObject);
        }
        xyChart.BuildEllipse();



        try {
            Thread.sleep(20000);
        }
        catch (InterruptedException e) {

        }
    }
}
