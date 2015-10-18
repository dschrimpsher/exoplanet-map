package com.pierless.space.core;

import com.pierless.space.display.DisplayObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dschrimpsher on 10/17/15.
 */
public class TestGalacticCoordinate3D {


    private static final double EPSILON = 0.0001;
    public EquatorialCoordinate[] equatorialCoordinates;
    public GalacticCoordinate3D[] galacticCoordinate3Ds;
    public Double[] distances;


    @Before
    public void setup() {

        equatorialCoordinates = new EquatorialCoordinate[5];
        galacticCoordinate3Ds = new GalacticCoordinate3D[5];
        distances = new Double[5];

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

        distances[2] = 1.97; //parsecs

        //Galactic Center's


        galacticCoordinate3Ds[3] = new GalacticCoordinate3D();
        galacticCoordinate3Ds[3].setLongitude(0.);
        galacticCoordinate3Ds[3].setLatitude(0.);

        distances[3] = 8000.; //parsecs

//        <TR><TD></TD><TD>51 Peg b</TD><TD>15.36</TD><TD>344.366577</TD><TD>20.768833</TD><TD></TD><TD>0.47200</TD><TD>54</TD></TR>
        //51 Peg b
        equatorialCoordinates[4] = new EquatorialCoordinate();
        equatorialCoordinates[4].setRightAscension(344.366577);
        equatorialCoordinates[4].setDeclination(20.768833);

        galacticCoordinate3Ds[4] = new GalacticCoordinate3D();
        galacticCoordinate3Ds[4].setLongitude(90.0627);
        galacticCoordinate3Ds[4].setLatitude(-34.7273);

        distances[4] = 15.36; //parsecs
    }

    @Test
    public void testConvert() {

        GalacticCoordinate3D test = new GalacticCoordinate3D();
        test.convertToGalatic(equatorialCoordinates[0], distances[0]);
        Assert.assertTrue("Long is wrong " + test.getLongitude(), test.getLongitude() - galacticCoordinate3Ds[0].getLongitude() < EPSILON);
        Assert.assertTrue("Lat is wrong " + test.getLatitude(), test.getLatitude() - galacticCoordinate3Ds[0].getLatitude() < EPSILON);
        Assert.assertTrue("Dist is wrong " + test.getDistance(), test.getDistance() - distances[0] < EPSILON);

        Assert.assertTrue("X is wrong" + test.getX(), test.getX() + 7.023452031 < EPSILON);
        Assert.assertTrue("Y is wrong" + test.getY(), test.getY() - 2.9812785104 < EPSILON);


        test.convertToGalatic(equatorialCoordinates[1], distances[1]);
        Assert.assertTrue("Long is wrong " + test.getLongitude(), test.getLongitude() - galacticCoordinate3Ds[1].getLongitude() < EPSILON);
        Assert.assertTrue("Lat is wrong " + test.getLatitude(), test.getLatitude() - galacticCoordinate3Ds[1].getLatitude() < EPSILON);
        Assert.assertTrue("Dist is wrong " + test.getDistance(), test.getDistance() - distances[1] < EPSILON);

        test.convertToGalatic(equatorialCoordinates[2], distances[2]);
        Assert.assertTrue("Long is wrong " + test.getLongitude(), test.getLongitude() - galacticCoordinate3Ds[2].getLongitude() < EPSILON);
        Assert.assertTrue("Lat is wrong " + test.getLatitude(), test.getLatitude() - galacticCoordinate3Ds[2].getLatitude() < EPSILON);
        Assert.assertTrue("Dist is wrong " + test.getDistance(), test.getDistance() - distances[2] < EPSILON);


        test = new GalacticCoordinate3D();
        test.convertToGalatic(equatorialCoordinates[4], distances[4]);
        Assert.assertTrue("51 Peg b Long is wrong " + test.getLongitude(), Math.abs(test.getLongitude() - galacticCoordinate3Ds[4].getLongitude()) < EPSILON);
        Assert.assertTrue("51 Peg b Lat is wrong " + test.getLatitude(), Math.abs(test.getLatitude() - galacticCoordinate3Ds[4].getLatitude()) < EPSILON);
        Assert.assertTrue("51 Peg b Dist is wrong " + test.getDistance(), Math.abs(test.getDistance() - distances[4]) < EPSILON);

        Assert.assertTrue("51 Peg b X is wrong" + test.getX(), Math.abs(test.getX() + 15.3599908) < EPSILON);
        Assert.assertTrue("51 Peg b Y is wrong" + test.getY(), Math.abs(test.getY() + 0.016808774) < EPSILON);


    }

    @Test
    public void testGalaticCenter() {
        GalacticCoordinate3D test = new GalacticCoordinate3D();
        test.setDistance(distances[3]);
        test.setLongitude(galacticCoordinate3Ds[3].getLongitude());
        test.setLatitude(galacticCoordinate3Ds[3].getLatitude());
        Assert.assertTrue("Long is wrong " + test.getLongitude(), test.getLongitude() - galacticCoordinate3Ds[3].getLongitude() < EPSILON);
        Assert.assertTrue("Lat is wrong " + test.getLatitude(), test.getLatitude() - galacticCoordinate3Ds[3].getLatitude() < EPSILON);
        Assert.assertTrue("Dist is wrong " + test.getDistance(), test.getDistance() - distances[3] < EPSILON);
        Assert.assertTrue("X is wrong" + test.getX(), test.getX() < EPSILON);
        Assert.assertTrue("Y is wrong" + test.getY(), test.getY() - 8000 < EPSILON);


    }

}
