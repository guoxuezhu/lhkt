package com.hzlh.lhkt.ui;


import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.hzlh.lhkt.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoActivity extends BaseActivity {


    @BindView(R.id.vidoview_dsp)
    VideoView vidoview_dsp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        String videoUrl = getIntent().getStringExtra("videoUrl");

        vidoview_dsp.setMediaController(new MediaController(this));
        vidoview_dsp.setVideoURI(Uri.parse(videoUrl));
        vidoview_dsp.start();
        vidoview_dsp.requestFocus();
    }




    @OnClick(R.id.btn_back_video)
    public void btn_back_video() {
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
