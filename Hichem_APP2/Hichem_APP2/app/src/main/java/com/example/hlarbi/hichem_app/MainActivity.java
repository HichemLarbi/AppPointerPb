package com.example.hlarbi.hichem_app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;



    int[] IMAGES = {R.drawable.steps_logo, R.drawable.calories_logo, R.drawable.distance, R.drawable.stairs_logo, R.drawable.heigt_logo, R.drawable.clock_icon};
    int[] BGS = {R.drawable.imagebg1, R.drawable.imagebg2, R.drawable.imagebg3, R.drawable.imagebg4, R.drawable.imagebg5, R.drawable.imagebg6};
    String[] NAMES = {"steps", "calories", "distance", "floors", "height", "duration"};
    String[] NUMBERS = {"10500", "1020", "7.15", "25", "360", "17"};
    String[] UNITIES = {"unity", "cal.", "km.", "unity", "meters", "min."};
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////ON CREAT METHOD//////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_second);

    //ListView
        SwipeMenuListView listView =(SwipeMenuListView)findViewById(R.id.list_view_data_resume);
        CustomAdapter customAdapter =new CustomAdapter();
        listView.setAdapter(customAdapter);

    //FlipperView
        getWindow().setBackgroundDrawableResource(R.drawable.ic_launcher_background);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        viewFlipper = findViewById(R.id.view_flipper);

//SwippeListView

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "graph" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(R.color.white1);
                // set item width
                openItem.setWidth(170);
                // set item title
                //openItem.setTitle("Open");
                openItem.setIcon(R.drawable.graph_icon_petit);
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                //openItem.setTitleColor(Color.TRANSPARENT);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(R.color.blue5);
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(R.drawable.happy);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        listView.setMenuCreator(creator);


        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:

                        break;
                    case 1:

                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
        }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////ON CREAT METHOD//////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    //Fragment changing method




    //FlipperView
    public void previousView(View v) {

        viewFlipper.setInAnimation(this, R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);
        viewFlipper.showPrevious();
    }
    public void nextView(View v) {

        viewFlipper.showNext();
    }

    //ListItem

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
            view = getLayoutInflater().inflate(R.layout.item_sample_hich, null);
            ImageView imageView_item =(ImageView)view.findViewById(R.id.imageView_item);
            View View_bg_ = (View)view.findViewById(R.id.view_item_background);
            TextView textView_name=(TextView)view.findViewById(R.id.textView_subject_item);
            TextView textView_number=(TextView)view.findViewById(R.id.textView_number_item);
            TextView textView_unity=(TextView)view.findViewById(R.id.textView_unity_item);

            imageView_item.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_number.setText(NUMBERS[i]);
            textView_unity.setText(UNITIES[i]);
            View_bg_.setBackgroundResource(BGS[i]);
            return view;
        }
    }

    }

