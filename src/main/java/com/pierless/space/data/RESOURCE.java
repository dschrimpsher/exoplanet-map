package com.pierless.space.data;

import com.google.api.client.util.Key;

/**
 * Created by dschrimpsher on 7/26/15.
 */

public class RESOURCE
{
    @Key
    private TABLE TABLE;

    @Key
    private PARAM[] PARAM;

    public TABLE getTABLE ()
    {
        return TABLE;
    }

    public void setTABLE (TABLE TABLE)
    {
        this.TABLE = TABLE;
    }

    public PARAM[] getPARAM ()
    {
        return PARAM;
    }

    public void setPARAM (PARAM[] PARAM)
    {
        this.PARAM = PARAM;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [TABLE = "+TABLE+", PARAM = "+PARAM+"]";
    }
}
