package com.pierless.space.core;

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
}
