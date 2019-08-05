package com.hzlh.lhkt.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.RadioButton;

import com.hzlh.lhkt.R;
import com.hzlh.lhkt.ui.fragment.HomeFragment;
import com.hzlh.lhkt.ui.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rbtn_sy)
    RadioButton rbtn_sy;

    private List<Fragment> fragments = new ArrayList<>();
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rbtn_sy.setChecked(true);
//        rbtn_fuwei.setChecked(true);

        fragments = getFragments(); //添加布局
        showFragment(0);

    }

    private List<Fragment> getFragments() {
        fragments.add(new HomeFragment());
        fragments.add(new MyFragment());
        return fragments;
    }


    @OnClick(R.id.rbtn_sy)
    public void rbtn_sy() {
        showFragment(0);
    }

    @OnClick(R.id.rbtn_my)
    public void rbtn_my() {
        showFragment(1);
    }


    private void showFragment(int i) {
        fragment = fragments.get(i);
        getFragmentManager().beginTransaction()
                .replace(R.id.mFragment, fragment).commit();
//        getFragmentManager().beginTransaction().show(fragment);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
