package com.example.moby.myasynctaskrotate;

import android.app.Activity;
import android.content.Intent;
import android.icu.util.TimeUnit;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
    MainActivity activity;
    TextView tv;

    public void setActivity(MainActivity activity) {
        this.activity = activity;
        tv = (TextView) activity.findViewById(R.id.TV);
    }


    @Override
    protected Void doInBackground(Void... params) {
        try {
            for (int i = 1; i <= 15; i++) {
                java.util.concurrent.TimeUnit.SECONDS.sleep(1);
                publishProgress(i);
                Log.d("myLogs", "i= " + i + ", MyTask: " + this.hashCode() + ", MainActivity: " + activity.hashCode());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(activity, "DONE", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        tv.setText("i= " + values[0]);
    }

}

