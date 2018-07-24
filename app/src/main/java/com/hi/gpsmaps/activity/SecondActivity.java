package com.hi.gpsmaps.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.hi.gpsmaps.interfacepackage.LinkRecyclertoFrameLayoutInterface;
import com.hi.gpsmaps.R;
import com.hi.gpsmaps.adapter.SecondScreenAdapter;
import com.hi.gpsmaps.fragment.aircraftfragmentpackage.AircraftFragment;
import com.hi.gpsmaps.fragment.AlaramFragment;
import com.hi.gpsmaps.fragment.CelestialFragment;
import com.hi.gpsmaps.fragment.DisplayFragment;
import com.hi.gpsmaps.fragment.EBFragment;
import com.hi.gpsmaps.fragment.FlightFragment;
import com.hi.gpsmaps.fragment.gpsfragmentpackage.GPSFragment;
import com.hi.gpsmaps.fragment.MessageFragment;
import com.hi.gpsmaps.fragment.pointfragmentpackage.PointsFragment;
import com.hi.gpsmaps.fragment.RouteFragment;
import com.hi.gpsmaps.fragment.SetupFragment;
import com.hi.gpsmaps.fragment.SoundFragment;
import com.hi.gpsmaps.fragment.trackfragmentpackage.TrackFragment;

public class SecondActivity extends AppCompatActivity implements LinkRecyclertoFrameLayoutInterface {
    int PositionDataOfRecylerview;
    private static final String BACK_STACK_ROOT_TAG = "root_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.sideRecylerview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        SecondScreenAdapter secondScreenAdapter = new SecondScreenAdapter(this, this);
        mRecyclerView.setAdapter(secondScreenAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, new LinkRecyclertoFrameLayoutInterface(){

                    @Override
                    public void DataPosition(View view,final int position) {
                        Toast.makeText(SecondActivity.this, "Got Position" +position, Toast.LENGTH_SHORT).show();
                        switch (position){
                            case 0:
                                replaceFragment(new GPSFragment());
                                break;
                            case 1:
                                replaceFragment(new FlightFragment());
                                break;
                            case 2:
                                replaceFragment(new RouteFragment());
                                break;
                            case 3:
                                replaceFragment(new PointsFragment());
                                break;
                            case 4:
                                replaceFragment(new TrackFragment());
                                break;
                            case 5:
                                replaceFragment(new AircraftFragment());
                                break;
                            case 6:
                                replaceFragment(new EBFragment());
                                break;
                            case 7:
                                replaceFragment(new AlaramFragment());
                                break;
                            case 8:
                                replaceFragment(new CelestialFragment());
                                break;
                            case 9:
                                replaceFragment(new MessageFragment());
                                break;
                            case 10:
                                replaceFragment(new DisplayFragment());
                                break;
                            case 11:
                                replaceFragment(new SoundFragment());
                                break;
                            case 12:
                                replaceFragment(new SetupFragment());
                                break;
                        }
                    }
                }
                        , mRecyclerView));
    }

    protected void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(BACK_STACK_ROOT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.addToBackStack(BACK_STACK_ROOT_TAG);
        transaction.replace(R.id.frameLayoutForSideItemClick,fragment);
        transaction.commit();

    }


    @Override
    public void DataPosition(View view, int position) {
         PositionDataOfRecylerview = position;
        Log.d("SecondActivity", "DataPosition: "+position);
    }

    private class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
        private LinkRecyclertoFrameLayoutInterface anInterface;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context mcontext, final LinkRecyclertoFrameLayoutInterface anInterface,
                                     final RecyclerView recyclerView) {
            this.anInterface = anInterface;
             gestureDetector = new GestureDetector(mcontext,new GestureDetector.SimpleOnGestureListener(){

                 @Override
                 public boolean onSingleTapUp(MotionEvent e) {
                     return true;
                 }

                 @Override
                 public void onLongPress(MotionEvent e) {
                    View view = recyclerView.findChildViewUnder(e.getX(),e.getY());
                     if(view != null && anInterface != null){
                         anInterface.DataPosition(view,recyclerView.getChildAdapterPosition(view));
                     }
                 }

             });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View childView =rv.findChildViewUnder(e.getX(),e.getY());
            if(childView !=null && anInterface !=null && gestureDetector.onTouchEvent(e)){
                anInterface.DataPosition(childView,rv.getChildAdapterPosition(childView));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }


}



