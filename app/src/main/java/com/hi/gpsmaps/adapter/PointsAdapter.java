package com.hi.gpsmaps.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hi.gpsmaps.fragment.pointfragmentpackage.DynamicPointsFragment;
import com.hi.gpsmaps.fragment.pointfragmentpackage.DynamicPointsFragmentSecond;

import java.util.ArrayList;

/**
 * Created by hi on 13-07-2018.
 */

public class PointsAdapter extends FragmentPagerAdapter {
    ArrayList<String> mStringArrayList;

    public PointsAdapter(FragmentManager fm, ArrayList<String> mArrayList) {
        super(fm);
        this.mStringArrayList = mArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
            return DynamicPointsFragment.newInstancePoints(position, mStringArrayList.get(position));
            case 1:
                return DynamicPointsFragmentSecond.newInstancePointSecond(position,mStringArrayList.get(position));
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return mStringArrayList.size();
    }
    public void setData(ArrayList<String> data){
        this.mStringArrayList = data;
        notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        mStringArrayList.size();
        return mStringArrayList.get(position);
    }
}
