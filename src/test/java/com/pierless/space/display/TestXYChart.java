package com.pierless.space.display;

import com.pierless.space.core.Star;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dschrimpsher on 7/26/15.
 */
public class TestXYChart {

    @Test
    public void testChart() {
        XYChart xyChart = new XYChart();

        double ra = 100.0;
        double dec = 0.0;
        double expectedLong = 211.6272;
        double expectedLat = -2.5447;

        xyChart.setScaleY(1);
        xyChart.setScaleX(1);
        Star star = new Star();
        star.setName("Test 1");
        star.setDistance(50);
        star.setRa(ra);
        star.setDec(dec);
        star.compute();

        Assert.assertEquals(star.getCoordinate3D().getLongitude(), expectedLong, 0.0001);
        Assert.assertEquals(star.getCoordinate3D().getLatitude(), expectedLat, 0.0001);





        xyChart.addThingsToGraph(star);

        Star star2 = new Star();
        star2.setName("Test 2");
        star2.setDistance(50);
        star2.setRa(289.5);
        star2.compute();

        xyChart.addThingsToGraph(star2);

        xyChart.BuildEllipse();
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {

        }
    }
}
