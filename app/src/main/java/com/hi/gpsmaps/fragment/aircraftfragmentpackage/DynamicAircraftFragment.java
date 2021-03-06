package com.hi.gpsmaps.fragment.aircraftfragmentpackage;

import android.content.Intent;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hi.gpsmaps.R;
import com.hi.gpsmaps.activity.SecondActivity;

/**
 * Created by hi on 18-06-2018.
 */

public class DynamicAircraftFragment extends Fragment {

    int mIntPage;
    String mStringTitle;
    Button mButton;

       public static DynamicAircraftFragment newInstanceAircraft(int page, String title){
        DynamicAircraftFragment fragment = new DynamicAircraftFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("int",page);
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIntPage = getArguments().getInt("int",0);
        mStringTitle = getArguments().getString("title");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dynamicaircraftitemfragment,container,false);

        return view;
    }
}
