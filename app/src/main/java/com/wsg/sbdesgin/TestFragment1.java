package com.wsg.sbdesgin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wushange on 2016/07/22.
 */
public class TestFragment1 extends Fragment {
    protected View mView = null;
    static TestFragment1 fragment;

    public static TestFragment1 newInstance() {
        if (fragment == null) {
            fragment = new TestFragment1();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.test1, null);
        return mView;
    }
}
