package com.hzlh.lhkt.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.hzlh.lhkt.R;
import com.hzlh.lhkt.ui.VideoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyFragment extends Fragment {

    @BindView(R.id.user_img)
    CircleImageView user_img;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;

    }

    private void init() {
        Glide.with(MyFragment.this)
                .load("http://img5.duitang.com/uploads/item/201410/11/20141011040700_3iXsj.thumb.700_0.jpeg")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(user_img);

    }



    @OnClick(R.id.video_my)
    public void video_my() {
        startActivity(new Intent(getActivity(), VideoActivity.class));
//        getActivity().finish();
    }



}
