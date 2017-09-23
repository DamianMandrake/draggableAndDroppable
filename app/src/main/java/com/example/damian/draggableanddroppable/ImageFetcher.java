package com.example.damian.draggableanddroppable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by damian on 8/9/17.
 */

public class ImageFetcher extends AsyncTask<Void,Void,Bitmap> {

    private ImageView imageView;
    private URL url;
    public ImageFetcher(ImageView imageView,String u)throws MalformedURLException{
        this.imageView=imageView;
        this.url=new URL(u);
    }

    @Override
    protected void onPreExecute(){

    }
    @Override
    protected Bitmap doInBackground(Void... params){
        try{
            HttpURLConnection httpURLConnection=(HttpURLConnection)this.url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
            return bitmap;
        }catch (IOException ioe){
            Log.i("ImageFetcher","issue with streams prolly");
        }
        return null;
    }
    @Override
    protected void onPostExecute(Bitmap result){
        super.onPostExecute(result);
        if(result!=null)
            this.imageView.setImageBitmap(result);
        else
            this.imageView.setImageResource(R.mipmap.ic_launcher_round);
    }

}
