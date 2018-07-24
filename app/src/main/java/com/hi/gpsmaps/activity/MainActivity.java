/*
package com.hi.gpsmaps.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hi.gpsmaps.adapter.FirstScreeenAdapter;
import com.hi.gpsmaps.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String[] mStringData;

    ViewPager mViewPager;
    TabLayout mTabLayout;
    FirstScreeenAdapter mAdapter;
     String msg = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.Viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mStringData = (getResources().getStringArray(R.array.items));
        ArrayList<String> mStringList =  new ArrayList<String>(Arrays.asList(mStringData));

      if(mAdapter == null){
          mAdapter =  new FirstScreeenAdapter(getSupportFragmentManager(),mStringList);
          mViewPager.setAdapter(mAdapter);
      }
      else {
          mAdapter.setData(mStringList);
      }
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mAdapter.notifyDataSetChanged();

    }
}
*/
