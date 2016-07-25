package com.wsg.sbdesgin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.nshmura.recyclertablayout.RecyclerTabLayout;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private DemoImitationLoopPagerAdapter mAdapter;
    private ViewPager mViewPager;
    private ArrayList<String> mItems;
    private ArrayList<Integer> mIcons;

    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.init("TAB").logLevel(LogLevel.FULL);
        ButterKnife.bind(this);
        mItems = new ArrayList<>();
        mIcons = new ArrayList<>();
        mItems.add("服饰");
        mItems.add("珠宝");
        mItems.add("彩妆");
        mItems.add("探班");
        mItems.add("收藏");
        mIcons.add(R.drawable.tab1);
        mIcons.add(R.drawable.tab2);
        mIcons.add(R.drawable.tab3);
        mIcons.add(R.drawable.tab4);
        mIcons.add(R.drawable.tab5);

        fragmentList.add(new TestFragment());
        fragmentList.add(new TestFragment1());
        fragmentList.add(new TestFragment2());
        fragmentList.add(new TestFragment3());
        fragmentList.add(new TestFragment4());

        mAdapter = new DemoImitationLoopPagerAdapter();
        mAdapter.addAll(mItems);
        mAdapter.addAllIcon(mIcons);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(mAdapter.getCenterPosition(0));
        mViewPager.addOnPageChangeListener(this);

        RecyclerTabLayout recyclerTabLayout = (RecyclerTabLayout)
                findViewById(R.id.recycler_tab_layout);
        recyclerTabLayout.setUpWithAdapter(new DemoCustomView01Adapter(this, mViewPager));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //got to center
        boolean nearLeftEdge = (position <= mItems.size());
        boolean nearRightEdge = (position >= mAdapter.getCount() - mItems.size());
        if (nearLeftEdge || nearRightEdge) {
            mViewPager.setCurrentItem(mAdapter.getCenterPosition(0), false);
        }
        Logger.e("滑动到" + position % mItems.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
