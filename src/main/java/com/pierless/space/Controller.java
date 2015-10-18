package com.pierless.space;

import com.pierless.space.core.CelestialObject;
import com.pierless.space.core.EquatorialCoordinate;
import com.pierless.space.core.ExoplanetFetcher;
import com.pierless.space.data.TABLEDATA;
import com.pierless.space.data.TR;
import com.pierless.space.data.VOTABLE;
import com.pierless.space.display.DisplayObject;
import com.pierless.space.display.XYChart;
import org.apache.log4j.PropertyConfigurator;
import sun.org.mozilla.javascript.internal.ast.ScriptNode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dschrimpsher on 10/17/15.
 */
public class Controller {

    protected ArrayList<CelestialObject> buildCelestialObjects(VOTABLE votable) {
        ArrayList<CelestialObject> celestialObjects = new ArrayList<CelestialObject>();

        //crate stars
        TABLEDATA tabledata = votable.getRESOURCE().getTABLE().getDATA().getTABLEDATA();
        for (int i = 0; i < tabledata.getTR().length; i++) {
            TR tr = tabledata.getTR(i);
            CelestialObject star = new CelestialObject();
            EquatorialCoordinate equatorialCoordinate = new EquatorialCoordinate();
            equatorialCoordinate.setRightAscension(Double.parseDouble(tr.getTD(3)));
            equatorialCoordinate.setDeclination(Double.parseDouble(tr.getTD(4)));
            star.setEquatorialCoordinate(equatorialCoordinate);
            if (tr.getTD(2) == null) {
                star.setDistance(1000.0);
            } else {
                star.setDistance(Double.parseDouble(tr.getTD(2)));
            }

            if (tr.getTD(0) == null) {
                if (tr.getTD(5) == null) {
                    if (tr.getTD(6) == null) {
                        star.setDiameter(1000.0);
                    } else
                        star.setDiameter(Double.parseDouble(tr.getTD(6)));
                } else {
                    star.setDiameter(Double.parseDouble(tr.getTD(5)));
                }
            } else {
                star.setDiameter(Double.parseDouble(tr.getTD(0)));
            }
            star.setName(tr.getTD(1));
            star.covert();
            celestialObjects.add(star);
        }
        return celestialObjects;
    }


    public void init() {
        ExoplanetFetcher exoplanetFetcher = new ExoplanetFetcher();
        VOTABLE votable = exoplanetFetcher.execute();
        ArrayList<CelestialObject> celestialObjects = buildCelestialObjects(votable);

        XYChart xyChart = new XYChart();
        for (CelestialObject celestialObject : celestialObjects) {
            DisplayObject displayObject = new DisplayObject();
            displayObject.builder(celestialObject);
            xyChart.addThingsToGraph(displayObject);
        }

        xyChart.BuildEllipse();


    }


    public static void main (String args[]) {
        PropertyConfigurator.configure("log4j.properties");
        Controller controller = new Controller();
        controller.init();
    }

}
