package com.example.moby.myasynctaskrotate;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {
    public TextView TV;
    Button btn;
    MyAsyncTask mat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("myLogs", "Create activity, hashcode: " + this.hashCode());

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mat = new MyAsyncTask();
                mat.setActivity(MainActivity.this);
                Log.d("myLogs", "Create TASK, hashcode: " + mat.hashCode());
                mat.execute();
            }
        });

        mat = (MyAsyncTask) getLastCustomNonConfigurationInstance();
        if (mat != null) mat.setActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("myLogs", "ON DESTROY");
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return mat;
    }
}
