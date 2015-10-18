package com.pierless.space.display;

import com.pierless.space.core.CelestialObject;

import java.awt.*;

/**
 * Created by dschrimpsher on 10/17/15.
 */
public class DisplayObject {

    private String name;
    private int x;
    private int y;
    private Color color;


    public void builder(CelestialObject celestialObject) {
        setX(celestialObject.getCoordinate3D().getX().intValue());
        setY(celestialObject.getCoordinate3D().getY().intValue());
        setName(celestialObject.getName());
        if (celestialObject.getDiameter() < .2) {
            setColor(Color.red);
        }
        else  if (celestialObject.getDiameter() > .5) {
            setColor(Color.ORANGE);
        }
        else {
            setColor(Color.BLUE);
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {

        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
