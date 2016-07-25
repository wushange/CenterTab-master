package com.wsg.sbdesgin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wushange on 2016/07/22.
 */
public class TestFragment3 extends Fragment {
    protected View mView = null;

    static TestFragment3 fragment;

    public static TestFragment3 newInstance() {
        if (fragment == null) {
            fragment = new TestFragment3();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.test3, null);
        return mView;
    }
}
