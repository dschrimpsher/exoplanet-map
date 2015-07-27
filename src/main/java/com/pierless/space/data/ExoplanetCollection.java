package com.pierless.space.data;

import com.google.api.client.util.Key;

/**
 * Created by dschrimpsher on 7/26/15.
 */
public class ExoplanetCollection
{
    @Key
    private VOTABLE VOTABLE;

    public VOTABLE getVOTABLE ()
    {
        return VOTABLE;
    }

    public void setVOTABLE (VOTABLE VOTABLE)
    {
        this.VOTABLE = VOTABLE;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [VOTABLE = "+VOTABLE+"]";
    }
}
