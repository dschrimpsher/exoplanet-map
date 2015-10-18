package com.pierless.space;

import com.pierless.space.core.CelestialObject;
import com.pierless.space.core.EquatorialCoordinate;
import com.pierless.space.core.ExoplanetFetcher;
import com.pierless.space.core.GalacticCoordinate3D;
import com.pierless.space.data.TABLEDATA;
import com.pierless.space.data.TR;
import com.pierless.space.data.VOTABLE;
import com.pierless.space.display.DisplayObject;
import com.pierless.space.display.XYChart;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;

/**
 * Created by dschrimpsher on 10/17/15.
 */
public class Controller {

    /**
     * 17h 45m 40.0s   -28° 43' 0"   //   +266.4168°  /  -28° 43.00'  -28.7167°
     * Defintino of GC is GCS(0, 0)
     * @return
     */
    protected CelestialObject createGalacticCenter() {
        CelestialObject center = new CelestialObject();
        center.setDistance(8000);
        center.setDiameter(1000.);
        center.setName("Galactic Center");
        GalacticCoordinate3D galacticCoordinate3D = new GalacticCoordinate3D();
        galacticCoordinate3D.setLatitude(0.0);
        galacticCoordinate3D.setLongitude(0.0);
        galacticCoordinate3D.setDistance(center.getDistance());
        center.setCoordinate3D(galacticCoordinate3D);
        return center;

    }

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
            star.convert();
            if (star.getName().equals("51 Peg b"))
                celestialObjects.add(star);
        }
        celestialObjects.add(createGalacticCenter());

        return celestialObjects;
    }


    public void init() {
        ExoplanetFetcher exoplanetFetcher = new ExoplanetFetcher();
        VOTABLE votable = exoplanetFetcher.execute();
        ArrayList<CelestialObject> celestialObjects = buildCelestialObjects(votable);

        XYChart xyChart = new XYChart();
        for (CelestialObject celestialObject : celestialObjects) {
            DisplayObject displayObject = new DisplayObject();
            displayObject.builder(celestialObject, 10);
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
