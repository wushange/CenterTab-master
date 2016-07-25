package com.wsg.sbdesgin;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shinichi Nishimura on 2015/07/24.
 */
public class DemoImitationLoopPagerAdapter extends FragmentPagerAdapter {

    private static final int NUMBER_OF_LOOPS = 10000;
    private ArrayList<Integer> mIcons = new ArrayList<>();
    private List<String> mItems = new ArrayList<>();

    public DemoImitationLoopPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return getFragmentAt(position);
    }

    @Override
    public int getCount() {
        return mItems.size() * NUMBER_OF_LOOPS;
    }

    public void addAllTitle(List<String> items) {
        mItems = new ArrayList<>(items);
    }

    public void addAllIcon(List<Integer> items) {
        mIcons = new ArrayList<>(items);
    }

    public int getCenterPosition(int position) {
        return mItems.size() * NUMBER_OF_LOOPS / 2 + position;
    }

    public Integer getIconValueAt(int position) {
        if (mIcons.size() == 0) {
            return null;
        }
        return mIcons.get(position % mIcons.size());
    }

    public String getValueAt(int position) {
        if (mItems.size() == 0) {
            return null;
        }
        return mItems.get(position % mItems.size());
    }

    public Fragment getFragmentAt(int position) {
        Fragment fragment = null;
        switch (position % mItems.size()) {
            case 0:
                fragment = new TestFragment();
                break;
            case 1:
                fragment = new TestFragment1();
                break;
            case 2:
                fragment = new TestFragment2();
                break;
            case 3:
                fragment = new TestFragment3();
                break;
            case 4:
                fragment = new TestFragment4();
                break;
            default:
                return null;
        }
        return fragment;

    }
}
