package com.pierless.space.core;

import javax.script.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by dschrimpsher on 7/26/15.
 * <p/>
 * Celesital Object contains information about the position and name of
 * any object in space.  Examples may be Stars, Black Holes, planets, etc...
 */
public class CelestialObject {
    private String name;
    private double distance;
    private double diameter;
    private GalacticCoordinate3D coordinate3D;
    private EquatorialCoordinate equatorialCoordinate;


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

    public void covert() {
        coordinate3D = new GalacticCoordinate3D();
        coordinate3D.convertToGalatic(equatorialCoordinate, distance);
    }

    public EquatorialCoordinate getEquatorialCoordinate() {
        return equatorialCoordinate;
    }

    public void setEquatorialCoordinate(EquatorialCoordinate equatorialCoordinate) {
        this.equatorialCoordinate = equatorialCoordinate;
    }
}
