package com.pierless.space.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dschrimpsher on 10/17/15.
 */
public class TestCelestialObject {

    private static final double EPSILON = 0.0001;
    public   EquatorialCoordinate[] equatorialCoordinates;
    public GalacticCoordinate3D[] galacticCoordinate3Ds;
    public Double[] distances;


    @Before
    public void setup() {

        equatorialCoordinates = new EquatorialCoordinate[3];
        galacticCoordinate3Ds = new GalacticCoordinate3D[3];
        distances = new Double[3];

        //Vega
        equatorialCoordinates[0] = new EquatorialCoordinate();
        equatorialCoordinates[0].setRightAscension(279.2347);
        equatorialCoordinates[0].setDeclination(38.7837);

        galacticCoordinate3Ds[0] = new GalacticCoordinate3D();
        galacticCoordinate3Ds[0].setLongitude(67.4482);
        galacticCoordinate3Ds[0].setLatitude(19.2372);

        distances[0] = 7.68; //parsecs

        //Barnard's's Star
        equatorialCoordinates[1] = new EquatorialCoordinate();
        equatorialCoordinates[1].setRightAscension(269.4521);
        equatorialCoordinates[1].setDeclination(4.6934);

        galacticCoordinate3Ds[1] = new GalacticCoordinate3D();
        galacticCoordinate3Ds[1].setLongitude(31.0087);
        galacticCoordinate3Ds[1].setLatitude(14.0626);

        distances[1] = 1.8328; //parsecs

        //Betelgeuse's's Star
        equatorialCoordinates[2] = new EquatorialCoordinate();
        equatorialCoordinates[2].setRightAscension(88.7929);
        equatorialCoordinates[2].setDeclination(7.4071);

        galacticCoordinate3Ds[2] = new GalacticCoordinate3D();
        galacticCoordinate3Ds[2].setLongitude(199.7873);
        galacticCoordinate3Ds[2].setLatitude(-8.9586);

        distances[2] = 197.; //parsecs
    }

    @Test
    public void testConvert() {
        CelestialObject celestialObject = new CelestialObject();
        celestialObject.setName("Vega");
        celestialObject.setDiameter(1.0);
        celestialObject.setDistance(distances[0]);
        celestialObject.setEquatorialCoordinate(equatorialCoordinates[0]);
        celestialObject.covert();
        Assert.assertTrue("Long is wrong " + celestialObject.getCoordinate3D().getLongitude(), celestialObject.getCoordinate3D().getLongitude() - galacticCoordinate3Ds[0].getLongitude() < EPSILON);
        Assert.assertTrue("Lat is wrong " + celestialObject.getCoordinate3D().getLatitude(), celestialObject.getCoordinate3D().getLatitude()  - galacticCoordinate3Ds[0].getLatitude() < EPSILON);
        Assert.assertTrue("Dist is wrong "+ celestialObject.getCoordinate3D().getDistance(), celestialObject.getCoordinate3D().getDistance() -  distances[0] < EPSILON);

    }
}
