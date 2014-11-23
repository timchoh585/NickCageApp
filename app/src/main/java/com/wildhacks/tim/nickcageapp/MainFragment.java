package com.wildhacks.tim.nickcageapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tim on 11/22/14.
 */

public class MainFragment extends Fragment
{
    Bitmap bit;

    public View onCreateView(LayoutInflater inflater, ViewGroup view,
                             Bundle savedInstanceState)
    {
        try {
            URL url = new URL("http://weknowmemes.com/wp-content/uploads/2012/10/despite-all-my-rage-i-am-still-just-nicolas-cage.jpg");
            new DownloadFileFromURL().execute(url);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }


        View rootView = inflater.inflate(R.layout.main_frag, view, false);

        return rootView;
    }

    private class DownloadFileFromURL extends AsyncTask<URL, Integer, Bitmap>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            //MainFragment.this.setProgressBarIndeterminateVisibility(true);
        }

        protected Bitmap doInBackground(URL... url)
        {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            Bitmap mIcon_val = null;
            URL req = null;
            try
            {
                req = new URL(url[0].toString());
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            try
            {
                mIcon_val = BitmapFactory.decodeStream(req.openConnection()
                        .getInputStream());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return mIcon_val;
        }

        @Override
        protected void onPostExecute(Bitmap result)
        {
            bit = result;
            ImageView image = (ImageView) getView().findViewById(R.id.nickImage);
            image.setImageBitmap(result);
        }
    }
}