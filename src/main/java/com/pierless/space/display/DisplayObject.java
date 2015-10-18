package com.pierless.space.display;

import java.awt.*;

/**
 * Created by dschrimpsher on 10/17/15.
 */
public class DisplayObject {

    private String name;
    private int x;
    private int y;
    private Color color;

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
