package com.wildhacks.tim.nickcageapp;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener
{
    private ViewPager viewPager;
    private TabsAdapter adapter;
    private ActionBar actionBar;

    //my tabs that will be viewed
    private String[] tabs = {"Main", "Video", "Audio", "About Me"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        adapter = new TabsAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //add tabs
        for (String tab_name : tabs)
        {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }

        //swiping tab view
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            //actionbar resets to the view that it is on and scrolls over to the side
            //if need be
            @Override
            public void onPageSelected(int position)
            {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }

            //when page is scrolled... i do nothing
            //but made to do whatever the master is doing
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2)
            {
            }

            //moves over on page scrolled state
            @Override
            public void onPageScrollStateChanged(int arg0)
            {
            }
        });
    }

    //does what reselected tab does
    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft)
    {
    }

    //does what selected tab does
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft)
    {
        // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }

    //switches over views to the selected tab
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft)
    {
    }
}
