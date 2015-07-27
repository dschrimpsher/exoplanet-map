package com.pierless.space.data;

import com.google.api.client.util.Key;

/**
 * Created by dschrimpsher on 7/26/15.
 */

public class TR
{
    @Key
    private String[] TD;

    public String[] getTD ()
    {
        return TD;
    }

    public String getTD(int i) { return TD[i];}

    public void setTD (String[] TD)
    {
        this.TD = TD;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [TD = "+TD+"]";
    }
}
