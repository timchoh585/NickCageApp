package com.wildhacks.tim.nickcageapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tim on 11/22/14.
 */

public class MainFragment extends Fragment
{
    public View onCreateView(LayoutInflater inflater, ViewGroup view,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.main_frag, view, false);

        return rootView;
    }
}