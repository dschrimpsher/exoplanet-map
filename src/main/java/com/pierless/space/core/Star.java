package com.pierless.space.core;

import javax.script.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by dschrimpsher on 7/26/15.
 */
public class Star {
    private String name;
    private double ra;
    private double dec;
    private double distance;
    private double diameter;

//    private double galLong;
//    private  double galLat;
//
    private GalacticCoordinate3D coordinate3D;

    public GalacticCoordinate3D getCoordinate3D() {
        return coordinate3D;
    }

    public void setCoordinate3D(GalacticCoordinate3D coordinate3D) {
        this.coordinate3D = coordinate3D;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void compute() {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
// read script file
            engine.eval(Files.newBufferedReader(Paths.get("./src/main/resources/convert.js"), StandardCharsets.UTF_8));

            Invocable inv = (Invocable) engine;
// call function from script file
            String temp = (String) inv.invokeFunction("CalcX", getRa(), getDec());

            temp = (String) inv.invokeFunction("CalcX", ra, dec);

            int index = temp.indexOf(",");

            double galLong = Double.parseDouble(temp.substring(0, index));
            double galLat = Double.parseDouble(temp.substring(index + 1));

            coordinate3D = new GalacticCoordinate3D();
            coordinate3D.setDistance(distance);
            coordinate3D.setLatitude(galLat);
            coordinate3D.setLongitude(galLong);

        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        catch (NoSuchMethodException e2) {
            System.err.println(e2.getMessage());
        }
        catch (ScriptException e2) {
            System.err.println(e2.getMessage());
        }

        //first convert angle to gal angle
//        double galAngle = ra - 265.5 + 90.0;
//
//
//
//        galLong = Math.cos(Math.toRadians(galAngle)) * distance;
//        galLat = Math.sin(Math.toRadians(galAngle)) * distance;






    }




    public double getRa() {
        return ra;
    }

    public void setRa(double ra) {
        this.ra = ra;
    }

    public double getDec() {
        return dec;
    }

    public void setDec(double dec) {
        this.dec = dec;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
}
