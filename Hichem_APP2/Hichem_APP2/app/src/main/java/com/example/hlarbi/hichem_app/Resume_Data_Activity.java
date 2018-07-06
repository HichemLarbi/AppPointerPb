package com.example.hlarbi.hichem_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Resume_Data_Activity extends AppCompatActivity {
    int[] IMAGES = {R.drawable.steps_logo,R.drawable.calories_logo, R.drawable.distance,R.drawable.stairs_logo,R.drawable.heigt_logo,R.drawable.clock_icon};
    String[] NAMES = {"steps","colories","distance","floors","heigt","duration"};
    String[] NUMBERS = {"10500","1020","7.15","25","360","17"};
    String[] UNITIES = {"unity","cal.","km.","unity","meters","min."};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_data_resume);

    }


}
