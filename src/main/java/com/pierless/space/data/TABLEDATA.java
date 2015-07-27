package com.pierless.space.data;

import com.google.api.client.util.Key;

/**
 * Created by dschrimpsher on 7/26/15.
 */

public class TABLEDATA
{
    @Key
    private TR[] TR;

    public TR[] getTR ()
    {
        return TR;
    }

    public TR getTR(int i) {
        return TR[i];
    }

    public void setTR (TR[] TR)
    {
        this.TR = TR;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [TR = "+TR+"]";
    }
}
