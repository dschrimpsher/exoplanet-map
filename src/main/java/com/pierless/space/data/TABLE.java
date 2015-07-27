package com.pierless.space.data;

import com.google.api.client.util.Key;

/**
 * Created by dschrimpsher on 7/26/15.
 */

public class TABLE
{

    @Key
    private FIELD[] FIELD;

    @Key
    private DATA DATA;

    public FIELD[] getFIELD ()
    {
        return FIELD;
    }

    public void setFIELD (FIELD[] FIELD)
    {
        this.FIELD = FIELD;
    }

    public DATA getDATA ()
    {
        return DATA;
    }

    public void setDATA (DATA DATA)
    {
        this.DATA = DATA;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [FIELD = "+FIELD+", DATA = "+DATA+"]";
    }
}
