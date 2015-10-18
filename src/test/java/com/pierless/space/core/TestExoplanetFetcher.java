package com.pierless.space.core;

import com.google.api.client.http.HttpResponseException;
import com.pierless.space.core.ExoplanetFetcher;
import com.pierless.space.core.Star;
import com.pierless.space.data.PARAM;
import com.pierless.space.data.TABLEDATA;
import com.pierless.space.data.TR;
import com.pierless.space.data.VOTABLE;
import com.pierless.space.display.XYChart;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by dschrimpsher on 7/26/15.
 */
public class TestExoplanetFetcher {

    static final Logger logger = Logger.getLogger(ExoplanetFetcher.class);

    public static final String xml =
            "<VOTABLE xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.ivoa.net/xml/VOTable/v1.3\" xmlns:stc=\"http://www.ivoa.net/xml/STC/v1.30\" version=\"1.3\">\n" +
                    "<DEFINITIONS>\n" +
                    "<COOSYS ID=\"J2000\" equinox=\"J2000.\" epoch=\"J2000.\" system=\"eq_FK5\" />\n" +
                    "</DEFINITIONS>\n" +
                    "<RESOURCE>\n" +
                    "<PARAM name=\"fixlen\" datatype=\"char\" arraysize=\"*\" value=\"T\" />\n" +
                    "<PARAM name=\"RowsRetrieved\" datatype=\"char\" arraysize=\"*\" value=\"1\" />\n" +
                    "<PARAM name=\"For detailed descriptions of the columns, go to http://exoplanetarchive.ipac.caltech.edu/docs/documentation.html and choose the appropriate table guide.\" datatype=\"char\" arraysize=\"*\" value=\"\" />\n" +
                    "<TABLE>\n" +
                    "<FIELD name=\"pl_radj\" datatype=\"double\" unit=\"Rjup\" />\n" +
                    "<FIELD name=\"pl_name\" datatype=\"char\" arraysize=\"*\" />\n" +
                    "<FIELD name=\"st_dist\" datatype=\"double\" unit=\"pc\" />\n" +
                    "<FIELD name=\"ra\" ucd=\"POS_EQ_RA_MAIN\" ref=\"J2000\" datatype=\"double\" unit=\"deg\" precision=\"F3\" width=\"7\" />\n" +
                    "<FIELD name=\"dec\" ucd=\"POS_EQ_DEC_MAIN\" ref=\"J2000\" datatype=\"double\" unit=\"deg\" precision=\"F3\" width=\"7\" />\n" +
                    "<FIELD name=\"pl_massj\" datatype=\"double\" unit=\"Mjup\" />\n" +
                    "<FIELD name=\"pl_msinij\" datatype=\"double\" unit=\"Mjup\" />\n" +
                    "<FIELD name=\"id\" ucd=\"ID_MAIN\" datatype=\"char\" arraysize=\"*\" />\n" +
                    "<DATA>\n" +
                    "<TABLEDATA>\n" +
                    "<TR>\n" +
                    "<TD />\n" +
                    "<TD>alf Cen B b</TD>\n" +
                    "<TD>1.35</TD>\n" +
                    "<TD>219.896164</TD>\n" +
                    "<TD>-60.837154</TD>\n" +
                    "<TD />\n" +
                    "<TD>0.00360</TD>\n" +
                    "<TD>0</TD>\n" +
                    "</TR>\n" +
                    "</TABLEDATA>\n" +
                    "</DATA>\n" +
                    "</TABLE>\n" +
                    "</RESOURCE>\n" +
                    "</VOTABLE>\n";


    @Before
    public void setup() {
        PropertyConfigurator.configure("log4j.properties");

    }

    @Test
    public void testConstructor() {
        ExoplanetFetcher exoplanetFetcher = new ExoplanetFetcher();
        Assert.assertNotNull("HttpTransport is null", exoplanetFetcher.getHttpTransport());
        Assert.assertNull("VOTABLE is not null", exoplanetFetcher.getVotable());

    }

    @Test
    public void testParse() throws IOException, XmlPullParserException {

        ExoplanetFetcher exoplanetFetcher = new ExoplanetFetcher();
        VOTABLE votable = exoplanetFetcher.parseResponse(xml);
        Assert.assertNotNull("VOTABLE is null", votable);
        TR[] trs = votable.getRESOURCE().getTABLE().getDATA().getTABLEDATA().getTR();
        Assert.assertTrue("Number of planets != 1", trs.length == 1);
        String[] data = trs[0].getTD();
        for (String d : data) {
            logger.info("Data: " + d);
        }
        Assert.assertTrue("Planet name is not alf Cen B b " + data[1], data[1].equals("alf Cen B b") );
        Assert.assertTrue("Planet Distance is wrong " + data[2], data[2].equals("1.35"));
        Assert.assertTrue("Planet RA wrong " + data[3], data[3].equals("219.896164") );
        Assert.assertTrue("Planet DEC wrong " + data[4], data[4].equals("-60.837154") );
        Assert.assertTrue("Planet Jupiter Masses is wrong " + data[6], data[6].equals("0.00360"));
        Assert.assertTrue("Planet array index is wrong " + data[7], data[7].equals("0"));

    }


    @Test
    public void testExecute() {
        ExoplanetFetcher exoplanetFetcher = new ExoplanetFetcher();
        VOTABLE votable = exoplanetFetcher.execute();
        Assert.assertNotNull(votable);
        Assert.assertTrue(votable.getRESOURCE().getTABLE().getDATA().getTABLEDATA().getTR().length > 1);





    }
//    @Test
//    @Ignore
//    public void testExoplanetGet() {
//        XYChart xyChart = new XYChart();
//        xyChart.setScaleX(10);
//        xyChart.setScaleY(10);
//        ExoplanetFetcher exoplanetFetcher = new ExoplanetFetcher();
//        VOTABLE votable = exoplanetFetcher.execute();
//
//        //crate stars
//        TABLEDATA tabledata = votable.getRESOURCE().getTABLE().getDATA().getTABLEDATA();
//        for (int i = 0; i < tabledata.getTR().length; i++) {
//            TR tr = tabledata.getTR(i);
//            Star star = new Star();
//            star.setRa(Double.parseDouble(tr.getTD(3)));
//            star.setDec(Double.parseDouble(tr.getTD(4)));
//            if (tr.getTD(2) == null) {
//                star.setDistance(1000.0);
//            } else {
//                star.setDistance(Double.parseDouble(tr.getTD(2)));
//            }
//
//            if (tr.getTD(0) == null) {
//                if (tr.getTD(5) == null) {
//                    if (tr.getTD(6) == null) {
//                        star.setDiameter(1000.0);
//                    } else
//                        star.setDiameter(Double.parseDouble(tr.getTD(6)));
//                } else {
//                    star.setDiameter(Double.parseDouble(tr.getTD(5)));
//                }
//            } else {
//                star.setDiameter(Double.parseDouble(tr.getTD(0)));
//            }
//            star.setName(tr.getTD(1));
//            star.compute();
//            System.out.println("Adding " + star.getName() + " to list");
//            xyChart.addThingsToGraph(star);
//
//        }
//        xyChart.BuildEllipse();
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//
//        }
//
//    }
}


