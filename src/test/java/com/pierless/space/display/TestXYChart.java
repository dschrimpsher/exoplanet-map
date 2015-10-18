package com.pierless.space.display;

import com.pierless.space.core.CelestialObject;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by dschrimpsher on 7/26/15.
 */
public class TestXYChart {

    @Ignore
    @Test
    public void testChart() {
        XYChart xyChart = new XYChart();

        double ra = 100.0;
        double dec = 0.0;
        double expectedLong = 211.6272;
        double expectedLat = -2.5447;

        xyChart.setScaleY(1);
        xyChart.setScaleX(1);
        CelestialObject celestialObject = new CelestialObject();
        celestialObject.setName("Test 1");
        celestialObject.setDistance(50);
//        celestialObject.setRa(ra);
//        celestialObject.setDec(dec);
//        celestialObject.compute();

        Assert.assertEquals(celestialObject.getCoordinate3D().getLongitude(), expectedLong, 0.0001);
        Assert.assertEquals(celestialObject.getCoordinate3D().getLatitude(), expectedLat, 0.0001);





        xyChart.addThingsToGraph(celestialObject);

        CelestialObject celestialObject2 = new CelestialObject();
        celestialObject2.setName("Test 2");
        celestialObject2.setDistance(50);
//        celestialObject2.setRa(289.5);
//        celestialObject2.compute();

        xyChart.addThingsToGraph(celestialObject2);

        xyChart.BuildEllipse();
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {

        }
    }
}
