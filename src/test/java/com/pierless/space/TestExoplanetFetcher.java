package com.pierless.space;

import com.google.api.client.http.HttpResponseException;
import com.pierless.space.core.ExoplanetFetcher;
import com.pierless.space.core.Star;
import com.pierless.space.data.TABLEDATA;
import com.pierless.space.data.TR;
import com.pierless.space.display.XYChart;
import org.junit.Test;

/**
 * Created by dschrimpsher on 7/26/15.
 */
public class TestExoplanetFetcher {


    @Test
    public void testExoplanetGet() {
        try {
            try {
                XYChart xyChart = new XYChart();
                xyChart.setScaleX(10);
                xyChart.setScaleY(10);
                ExoplanetFetcher.run();

                //crate stars
                TABLEDATA tabledata = ExoplanetFetcher.votable.getRESOURCE().getTABLE().getDATA().getTABLEDATA();
                for (int i = 0; i < tabledata.getTR().length; i++) {
                    TR tr = tabledata.getTR(i);
                    Star star = new Star();
                    star.setRa(Double.parseDouble(tr.getTD(3)));
                    star.setDec(Double.parseDouble(tr.getTD(4)));
                    if (tr.getTD(2) == null) {
                        star.setDistance(1000.0);
                    }
                    else {
                        star.setDistance(Double.parseDouble(tr.getTD(2)));
                    }

                    if (tr.getTD(0) == null) {
                        if (tr.getTD(5) == null) {
                            if (tr.getTD(6) == null){
                                star.setDiameter(1000.0);
                            }
                            else
                                star.setDiameter(Double.parseDouble(tr.getTD(6)));
                        }
                        else {
                            star.setDiameter(Double.parseDouble(tr.getTD(5)));
                        }
                    }
                    else {
                        star.setDiameter(Double.parseDouble(tr.getTD(0)));
                    }
                    star.setName(tr.getTD(1));
                    star.compute();
                    System.out.println("Adding " + star.getName() + " to list");
                    xyChart.addThingsToGraph(star);

                }
                xyChart.BuildEllipse();
                try {
                    Thread.sleep(8000);
                }
                catch (InterruptedException e) {

                }


                return;
            } catch (HttpResponseException e) {
                System.err.println(e.getMessage());
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
