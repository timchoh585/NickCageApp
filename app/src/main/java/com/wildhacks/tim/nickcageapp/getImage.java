package com.wildhacks.tim.nickcageapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tim on 11/23/14.
 */
public class getImage extends AsyncTask<URL, Integer, Bitmap>
{
    protected Bitmap doInBackground(URL... urls)
    {
        Bitmap mIcon_val = null;
        URL req = null;
        try
        {
            req = new URL(urls[0].toString());
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

    protected void onProgressUpdate(Integer... progress)
    {
        //setProgressPercent(progress[0]);
    }

    protected void onPostExecute(Bitmap result)
    {
        //return result;
    }
}
