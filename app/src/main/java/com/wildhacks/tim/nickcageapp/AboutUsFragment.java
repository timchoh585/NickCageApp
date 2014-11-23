package com.wildhacks.tim.nickcageapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tim on 11/22/14.
 */

public class AboutUsFragment extends Fragment
{
    public View onCreateView(LayoutInflater inflater, ViewGroup view,
                             Bundle savedInstanceState)
    {
        TextView text = (TextView) getView().findViewById(R.id.nickBio);
        text.setText("I are Nick Cage.\nI good actor.");

        View rootView = inflater.inflate(R.layout.about_frag, view, false);

        return rootView;
    }
}