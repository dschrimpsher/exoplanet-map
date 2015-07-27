package com.pierless.space.display;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dschrimpsher on 7/26/15.
 */
public class TestXYChart {

    @Test
    public void testChart() {
        XYChart xyChart = new XYChart();

        Star star = new Star();
        star.setName("Test 1");
        star.setDistance(50);
        star.setRa(265.5);
        star.compute();

        Assert.assertTrue("X = " + star.getGalX(), star.getGalX() < 0.00001 && star.getGalX() > -0.00001);
        Assert.assertTrue("Y = " + star.getGalY(), star.getGalY() > 0.0);

        xyChart.addThingsToGraph(star);

        Star star2 = new Star();
        star2.setName("Test 2");
        star2.setDistance(50);
        star2.setRa(289.5);
        star2.compute();

        xyChart.addThingsToGraph(star2);

        xyChart.BuildEllipse();
        try {
            Thread.sleep(4000);
        }
        catch (InterruptedException e) {

        }
    }
}
