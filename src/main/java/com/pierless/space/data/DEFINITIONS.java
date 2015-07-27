package com.pierless.space.data;

import com.google.api.client.util.Key;

/**
 * Created by dschrimpsher on 7/26/15.
 */

public class DEFINITIONS
{
    @Key
    private COOSYS COOSYS;

    public COOSYS getCOOSYS ()
    {
        return COOSYS;
    }

    public void setCOOSYS (COOSYS COOSYS)
    {
        this.COOSYS = COOSYS;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [COOSYS = "+COOSYS+"]";
    }
}

