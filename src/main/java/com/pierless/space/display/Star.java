package com.pierless.space.display;

/**
 * Created by dschrimpsher on 7/26/15.
 */
public class Star {
    private String name;
    private double ra;
    private double dec;
    private double distance;
    private double diameter;

    private double galX;
    private  double galY;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void compute() {
        //first convert angle to gal angle
        double galAngle = ra - 265.5 + 90.0;



        galX = Math.cos(Math.toRadians(galAngle)) * distance;
        galY = Math.sin(Math.toRadians(galAngle)) * distance;





    }


    public double getGalX() {
        return galX;
    }

    public void setGalX(double galX) {
        this.galX = galX;
    }

    public double getGalY() {
        return galY;
    }

    public void setGalY(double galY) {
        this.galY = galY;
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
