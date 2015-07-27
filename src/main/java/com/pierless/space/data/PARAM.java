package com.pierless.space.data;

import com.google.api.client.util.Key;

/**
 * Created by dschrimpsher on 7/26/15.
 */

public class PARAM
{

    @Key
    private String name;

    @Key
    private String arraysize;

    @Key
    private String value;

    @Key
    private String datatype;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getArraysize ()
    {
        return arraysize;
    }

    public void setArraysize (String arraysize)
    {
        this.arraysize = arraysize;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
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
        return "ClassPojo [name = "+name+", arraysize = "+arraysize+", value = "+value+", datatype = "+datatype+"]";
    }
}
