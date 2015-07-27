package com.pierless.space.data;

import com.google.api.client.util.Key;

/**
 * Created by dschrimpsher on 7/26/15.
 */

public class VOTABLE
{
    @Key
    private RESOURCE RESOURCE;

    @Key ("@xmlns")
    private String xmlns;

    @Key
    private DEFINITIONS DEFINITIONS;

    @Key ("@version")
    private String version;

    public RESOURCE getRESOURCE ()
    {
        return RESOURCE;
    }

    public void setRESOURCE (RESOURCE RESOURCE)
    {
        this.RESOURCE = RESOURCE;
    }

    public String getXmlns ()
    {
        return xmlns;
    }

    public void setXmlns (String xmlns)
    {
        this.xmlns = xmlns;
    }

    public DEFINITIONS getDEFINITIONS ()
    {
        return DEFINITIONS;
    }

    public void setDEFINITIONS (DEFINITIONS DEFINITIONS)
    {
        this.DEFINITIONS = DEFINITIONS;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [RESOURCE = "+RESOURCE+", xmlns = "+xmlns+", DEFINITIONS = "+DEFINITIONS+", version = "+version+"]";
    }
}