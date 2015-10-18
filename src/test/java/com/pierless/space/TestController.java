package com.pierless.space;

import com.pierless.space.core.CelestialObject;
import com.pierless.space.core.ExoplanetFetcher;
import com.pierless.space.display.DisplayObject;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dschrimpsher on 10/18/15.
 */
public class TestController {

    static final Logger logger = Logger.getLogger(TestController.class);


    @Before
    public void setup() {
        PropertyConfigurator.configure("log4j.properties");
    }
    @Test
    public void testGalacticCenter() {
        Controller controller = new Controller();
        CelestialObject center = controller.createGalacticCenter();
        logger.info(center.getCoordinate3D().getLongitude() + ", " + center.getCoordinate3D().getLatitude());
        Assert.assertTrue(Math.round(center.getCoordinate3D().getLongitude()) == 0);
        Assert.assertTrue(Math.round(center.getCoordinate3D().getLatitude()) == 0);

        DisplayObject displayObject = new DisplayObject();
        displayObject.builder(center);

        logger.info(displayObject.getX() + ", " + displayObject.getY());
        Assert.assertTrue(displayObject.getX() == 0);


    }
}
