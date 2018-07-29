package com.example.hlarbi.firebaseappbeta1.AccountActivity.ViewClasses;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hlarbi.firebaseappbeta1.AccountActivity.ViewClasses.linechart_animation_pollu.ChartView;
import com.example.hlarbi.firebaseappbeta1.AccountActivity.ViewClasses.linechart_animation_pollu.InputData;
import com.example.hlarbi.firebaseappbeta1.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.loopj.android.http.*;
import cz.msebera.android.httpclient.Header;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {
    private RecyclerView.LayoutManager mLayoutManager;

    static String TAG = "FragmentTwo";

    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        final View pollu_view = inflater.inflate(R.layout.activity_data_pollu, container, false);

        AsyncHttpClient client = new AsyncHttpClient();

        client.get("https://api.waqi.info/feed/geo:48.856614;2.3522219/?token=c7cb1dd08fbca3cd163693d2d79efd9660a8e9a0&lat&lng&optional", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here
                try {
                    Log.d(TAG,response.toString());

                    JSONObject data = response.getJSONObject("data");

                    TextView textView = (TextView) pollu_view.findViewById(R.id.textView2);
                    textView.setText(data.get("aqi").toString());


                    JSONObject iaqui = data.getJSONObject("iaqi");

                    Pollu_Recycle_Data.number_pollu = new String[]{
                            iaqui.getJSONObject("co").get("v").toString(),iaqui.getJSONObject("no2").get("v").toString(),iaqui.getJSONObject("o3").get("v").toString(),iaqui.getJSONObject("pm10").get("v").toString(),iaqui.getJSONObject("pm25").get("v").toString(),iaqui.getJSONObject("so2").get("v").toString()
                    };
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                RecyclerView pollu_recyclerView = (RecyclerView) pollu_view.findViewById(R.id.recycle_pollu);
                MyRecycleAdapter listAdapter = new MyRecycleAdapter() {
                };
                pollu_recyclerView.setAdapter(listAdapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                pollu_recyclerView.setLayoutManager(layoutManager);

                initViews(pollu_view);

                // Inflate the layout for this fragment


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        });

        return pollu_view;

    }
    private void initViews(View v) {
        ChartView chartView = v.findViewById(R.id.charView);
        List<InputData> dataList = createChartData();
        chartView.setData(dataList);
    }

    @NonNull
    private List<InputData> createChartData() {
        List<InputData> dataList = new ArrayList<>();
        dataList.add(new InputData(18));
        dataList.add(new InputData(18));
        dataList.add(new InputData(18));
        dataList.add(new InputData(18));
        dataList.add(new InputData(18));
        dataList.add(new InputData(18));
        dataList.add(new InputData(18));




//X axe => add date number
        long currMillis = System.currentTimeMillis();
        currMillis -= currMillis % TimeUnit.DAYS.toMillis(1);

        for (int i = 0; i < dataList.size(); i++) {
            long position = dataList.size() - 1 - i;
            long offsetMillis = TimeUnit.DAYS.toMillis(position);

            long millis = currMillis - offsetMillis;
            dataList.get(i).setMillis(millis);
        }

        return dataList;
    }

}
