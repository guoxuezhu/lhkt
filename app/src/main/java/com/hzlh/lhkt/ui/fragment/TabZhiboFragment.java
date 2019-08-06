package com.hzlh.lhkt.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hzlh.lhkt.R;

import butterknife.ButterKnife;

public class TabZhiboFragment extends Fragment {




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_zb_fragment, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;

    }

    private void init() {

    }



}
