package com.pierless.space.data;

import com.google.api.client.util.Key;

/**
 * Created by dschrimpsher on 7/26/15.
 */

public class FIELD
{
    @Key
    private String unit;

    @Key
    private String name;

    @Key
    private String datatype;

    public String getUnit ()
    {
        return unit;
    }

    public void setUnit (String unit)
    {
        this.unit = unit;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDatatype ()
    {
        return datatype;
    }

    public void setDatatype (String datatype)
    {
        this.datatype = datatype;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [unit = "+unit+", name = "+name+", datatype = "+datatype+"]";
    }
}
