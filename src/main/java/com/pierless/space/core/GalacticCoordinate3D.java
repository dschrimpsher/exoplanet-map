package com.pierless.space.core;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by dschrimpsher on 10/17/15.
 */
public class GalacticCoordinate3D {

    Double longitude;
    Double latitude;
    Double distance;


    @Override
    public String toString() {
        return "GalacticCoordinate3D{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", distance=" + distance +
                '}';
    }

    public Double getX() {
        return Math.cos(longitude) * distance;
    }

    public Double getY() {
        return Math.sin(longitude) * distance;
    }


    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void convertToGalatic(EquatorialCoordinate equatorialCoordinate, Double distance) {
        try {
            //Call java script functino to convert Equatorial to Galatic.
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            engine.eval(Files.newBufferedReader(Paths.get("./src/main/resources/convert.js"), StandardCharsets.UTF_8));
            Invocable inv = (Invocable) engine;
            String temp = (String) inv.invokeFunction("CalcX", equatorialCoordinate.getRightAscension(), equatorialCoordinate.getDeclination());

            //Get values out of the javascript return
            int index = temp.indexOf(",");
            this.longitude = Double.parseDouble(temp.substring(0, index));
            this.latitude = Double.parseDouble(temp.substring(index + 1));
            this.distance = distance;


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

    }
}
