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
        builder(celestialObject, 1);
    }

    public void builder(CelestialObject celestialObject, int scale) {
        setX(celestialObject.getCoordinate3D().getX().intValue() * scale);
        setY(celestialObject.getCoordinate3D().getY().intValue()*scale);
        setName(celestialObject.getName());
        if (celestialObject.getDiameter() < 0.0 ) {
            setColor(Color.PINK);
        }
        else if (celestialObject.getDiameter() < .2) {
            setColor(Color.red);
        }
        else  if (celestialObject.getDiameter() < .5) {
            setColor(Color.ORANGE);
        }
        else if (celestialObject.getDiameter() < 12.0){
            setColor(Color.BLUE);
        }
        else {
            setColor(Color.WHITE);
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
