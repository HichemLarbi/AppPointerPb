package com.example.hlarbi.firebaseappbeta1.AccountActivity.ViewClasses;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.hlarbi.firebaseappbeta1.AccountActivity.Register_Activities.LoginActivity;

import com.example.hlarbi.firebaseappbeta1.AccountActivity.MainClasses.MainActivity;
import com.example.hlarbi.firebaseappbeta1.AccountActivity.Register_Activities.LoginActivity;
import com.example.hlarbi.firebaseappbeta1.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment implements View.OnClickListener{

    private ViewFlipper viewFlipper;

    private static final String TAG = "FragmentOne";

    private int STEPS_GOAL = 10000;
    private int DISTANCE_GOAL = 8;
    private int CALORIES_GOAL = 1000;
    private int FLOORS_GOAL = 10;

    int[] IMAGES = {R.drawable.icon_steps, R.drawable.icon_calo, R.drawable.icon_distance, R.drawable.icon_floors, R.drawable.icon_height, R.drawable.icon_duration};
    int[] BGS = {R.drawable.line_rightitem,R.drawable.line_downitem, R.drawable.line_rightitem, R.drawable.line_downitem,R.drawable.line_rightitem, R.drawable.line_downitem};
    String[] NAMES = {"steps", "colories", "distance", "floors", "heigt", "duration"};
    private String today_steps = String.valueOf(LoginActivity.activities.getSummary().getSteps());
    private String today_calo = String.valueOf(LoginActivity.activities.getSummary().getCaloriesOut());
    private String today_distance = String.valueOf(LoginActivity.activities.getSummary().getDistances().get(1).getDistance());
    private String today_floors = String.valueOf(LoginActivity.activities.getSummary().getFloors());
    private String today_duration = String.valueOf(LoginActivity.activities.getSummary().getFairlyActiveMinutes());


    String[] NUMBERS = {today_steps, today_calo, today_distance, today_floors, "360", today_duration};
    //String[] UNITIES = {"unity", "cal.", "km.", "unity", "meters", "min."};



    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.item_sample_gridview, null);
            ImageView g_icon = (ImageView)view.findViewById(R.id.imageView_item_grid);
           // RelativeLayout g_bgs = (RelativeLayout)view.findViewById(R.id.item_main_rela_lay) ;
            TextView g_subject  = (TextView)view.findViewById(R.id.textView_subject_item_grid);
            TextView g_num = (TextView)view.findViewById(R.id.textView_number_item);
            TextView g_uni = (TextView)view.findViewById(R.id.textView_unity_item);

            g_icon.setImageResource(IMAGES[i]);
            g_subject.setText(NAMES[i]);
            g_num.setText(NUMBERS[i]);
            //g_uni.setText(UNITIES[i]);
         //   g_bgs.setBackgroundResource(BGS[i]);

            return view;
        }
    }





    public GridView getGrid(GridView ls) {
        ls = getActivity().findViewById(R.id.grid_view_data_resume);

        return ls;
    }

    public ViewFlipper getViewFlipper(ViewFlipper vf) {
        vf = getActivity().findViewById(R.id.view_flipper);

        return vf;
    }



    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //FlipperView
        View v = inflater.inflate(R.layout.activity_data_resume, container, false);
        GridView ls = (GridView) v.findViewById(R.id.grid_view_data_resume);


        Button bL = (Button) v.findViewById(R.id.bvflipperL);
        Button bR = (Button) v.findViewById(R.id.bvflipperR);
        bL.setOnClickListener(this);
        bR.setOnClickListener(this);
        //FlipperView
        ls = ls;
        CustomAdapter customAdapter = new CustomAdapter();
        ls.setAdapter(customAdapter);
        // Inflate the layout for this fragment

        // Show today date on the activity Flipper

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");

        String currentDateTimeString = mdformat.format(calendar.getTime());

        TextView textView = (TextView) v.findViewById(R.id.buttondate);
        textView.setText(currentDateTimeString);

        // Calculate and show steps percentage on the steps goal flipper

        textView = v.findViewById(R.id.steps_goal_text_id);

        int steps_percent = (Integer.parseInt(today_steps) * 100) / STEPS_GOAL;
        textView.setText(String.valueOf(steps_percent));


        textView = v.findViewById(R.id.distance_goal_text_id);

        int distance_percent = (int)((Double.parseDouble(today_distance) * 100) / DISTANCE_GOAL);
        textView.setText(String.valueOf(distance_percent));


        textView = v.findViewById(R.id.calo_goal_text_id);

        int calo_percent = (int)((Double.parseDouble(today_calo) * 100) / CALORIES_GOAL);
        textView.setText(String.valueOf(calo_percent));


        textView = v.findViewById(R.id.floors_goal_text_id);

        int floor_percent = (Integer.parseInt(today_floors) * 100) / FLOORS_GOAL;
        textView.setText(String.valueOf(floor_percent));



        return v;
    }


   public void previousView(View v) {
       getViewFlipper(viewFlipper).setInAnimation(getContext(), R.anim.slide_in_right);

       getViewFlipper(viewFlipper).showPrevious();
    }
    public void nextView(View v) {
        getViewFlipper(viewFlipper).setInAnimation(getContext(), R.anim.slide_out_right);

        getViewFlipper(viewFlipper).setOutAnimation(getContext(), R.anim.slide_in_left);

        getViewFlipper(viewFlipper).showNext();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bvflipperL:
                previousView(v);
                break;
            case R.id.bvflipperR:
                nextView(v);
                break;



        }

            }


}
