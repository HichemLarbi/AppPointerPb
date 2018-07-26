package com.example.hlarbi.app3;


import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.hlarbi.app3.API.GetResquest;
import com.example.hlarbi.app3.API.ServiceGenerator;
import com.example.hlarbi.app3.API.objects.FitBitApi.Activities;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment implements View.OnClickListener{
    MainActivity m = new MainActivity();
    private ViewFlipper viewFlipper;
    private Button mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    public TextView chosenDate;
    public String dateFirst = "today";
    Activities activities = new Activities();
    CustomAdapter customAdapter;


   // final   String[] NAMES = {"steps", "colories", "distance", "floors", "height", "duration"};




  final   String[] NUMBERS = {"10500", "1020", "7.15", "25", "360", "17"};



    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return NUMBERS.length;
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
            view = getLayoutInflater().inflate(R.layout.item_sample_gridview_run, null);

            TextView g_subject  = (TextView)view.findViewById(R.id.textView_subject_item_grid);

            g_subject.setText(NUMBERS[i]);
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





        View v = inflater.inflate(R.layout.activity_data_resume, container, false);
        GridView ls = (GridView) v.findViewById(R.id.grid_view_data_resume);


        //date picker

        String tokenFull = getArguments().getString("KEY");
        String[] tokenH1 = tokenFull.split("²");
        final String headertoken = tokenH1[0];
        final String token = tokenH1[1];

        Toast.makeText(getContext(),token,Toast.LENGTH_SHORT).show();
        Toast.makeText(getContext(),headertoken,Toast.LENGTH_SHORT).show();





        //date picker

        //FlipperView
        Button bL = (Button) v.findViewById(R.id.bvflipperL);
        Button bR = (Button) v.findViewById(R.id.bvflipperR);
        bL.setOnClickListener(this);
        bR.setOnClickListener(this);
        //FlipperView

        customAdapter = new CustomAdapter();
        ls.setAdapter(customAdapter);
        // Inflate the layout for this fragment

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













































/*       //Calendar

        mDisplayDate = (Button) v.findViewById(R.id.buttondate);


        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        getActivity(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1;


                String date = year + "-" + month + "-" + day;

                final GetResquest clientg = ServiceGenerator.createService(GetResquest.class);

                final Map<String, String> map = new HashMap<>();

                map.put("Authorization", headertoken);
                final Call<Activities> calld = clientg.getActivitiesData(map,token,String.valueOf(date));
                calld.enqueue(new Callback<Activities>() {
                    @Override
                    public void onResponse(Call<Activities> call, Response<Activities> response) {
                        Activities activities1 =response.body();


                    }

                    @Override
                    public void onFailure(Call<Activities> call, Throwable t) {

                    }
                });

            }

        };*/