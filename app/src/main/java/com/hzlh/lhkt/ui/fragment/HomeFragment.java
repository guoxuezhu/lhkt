package com.hzlh.lhkt.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;


import com.hzlh.lhkt.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment {

    @BindView(R.id.rbtn_tab_zy)
    RadioButton rbtn_tab_zy;
    @BindView(R.id.rbtn_tab_zhibo)
    RadioButton rbtn_tab_zhibo;
    @BindView(R.id.rbtn_tab_dati)
    RadioButton rbtn_tab_dati;
    @BindView(R.id.rbtn_tab_video)
    RadioButton rbtn_tab_video;

    private List<Fragment> hfragments = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this, view);

        hfragments = getFragments(); //添加布局
//        if (rbtn_tab_zy.isChecked()) {
//            showFragment(0);
//        } else if (rbtn_tab_zhibo.isChecked()) {
//            showFragment(1);
//        } else if (rbtn_tab_dati.isChecked()) {
//            showFragment(2);
//        } else if (rbtn_tab_video.isChecked()) {
//            showFragment(3);
//        }
        showFragment(0);
        rbtn_tab_zy.setChecked(true);
        Log.i("==Fragment==", "=========HomeFragment======" + hfragments.size());
        return view;

    }


    private List<Fragment> getFragments() {
        hfragments.clear();
        hfragments.add(new TabZiyuanFragment());
        hfragments.add(new TabZhiboFragment());
        hfragments.add(new TabDatiFragment());
        hfragments.add(new TabVideoFragment());

        return hfragments;
    }


    @OnClick(R.id.rbtn_tab_zy)
    public void rbtn_tab_zy() {
        showFragment(0);
    }

    @OnClick(R.id.rbtn_tab_zhibo)
    public void rbtn_tab_zhibo() {
        showFragment(1);
    }

    @OnClick(R.id.rbtn_tab_dati)
    public void rbtn_tab_dati() {
        showFragment(2);
    }

    @OnClick(R.id.rbtn_tab_video)
    public void rbtn_tab_video() {
        showFragment(3);
    }


    private void showFragment(int i) {
        getFragmentManager().beginTransaction()
                .replace(R.id.home_fragment_layout, hfragments.get(i)).commit();
//        getFragmentManager().beginTransaction().show(fragment);
    }


}
