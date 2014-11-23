package com.wildhacks.tim.nickcageapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by tim on 11/22/14.
 */
public class TabsAdapter extends FragmentPagerAdapter
{
    public TabsAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int index)
    {
        switch (index)
        {
            case 0:
                return new MainFragment();
            case 1:
                return new AudioFragment();
            case 2:
                return new VideoFragment();
            case 3:
                return new AboutUsFragment();
        }
        return null;
    }

    @Override
    public int getCount()
    {
        return 4;
    }
}
