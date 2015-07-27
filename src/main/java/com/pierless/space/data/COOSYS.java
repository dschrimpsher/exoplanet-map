package com.pierless.space.data;

import com.google.api.client.util.Key;

/**
 * Created by dschrimpsher on 7/26/15.
 */

public class COOSYS
{
    @Key
    private String system;

    @Key
    private String epoch;

    @Key
    private String ID;

    @Key
    private String equinox;

    public String getSystem ()
    {
        return system;
    }

    public void setSystem (String system)
    {
        this.system = system;
    }

    public String getEpoch ()
    {
        return epoch;
    }

    public void setEpoch (String epoch)
    {
        this.epoch = epoch;
    }

    public String getID ()
    {
        return ID;
    }

    public void setID (String ID)
    {
        this.ID = ID;
    }

    public String getEquinox ()
    {
        return equinox;
    }

    public void setEquinox (String equinox)
    {
        this.equinox = equinox;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [system = "+system+", epoch = "+epoch+", ID = "+ID+", equinox = "+equinox+"]";
    }
}
