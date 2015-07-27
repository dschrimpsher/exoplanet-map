package com.pierless.space.data;

import com.google.api.client.util.Key;

/**
 * Created by dschrimpsher on 7/26/15.
 */

public class DATA
{
    @Key
    private TABLEDATA TABLEDATA;

    public TABLEDATA getTABLEDATA ()
    {
        return TABLEDATA;
    }

    public void setTABLEDATA (TABLEDATA TABLEDATA)
    {
        this.TABLEDATA = TABLEDATA;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [TABLEDATA = "+TABLEDATA+"]";
    }
}
