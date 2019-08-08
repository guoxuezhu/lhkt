package com.hzlh.lhkt.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.hzlh.lhkt.R;

import org.videolan.vlc.VlcVideoView;
import org.videolan.vlc.listener.MediaListenerEvent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VlcVideoActivity extends BaseActivity implements MediaListenerEvent {


    @BindView(R.id.rtsp_video)
    VlcVideoView videoView;


    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlc_video);
        ButterKnife.bind(this);


        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        videoView.setMediaListenerEvent(this);
        videoView.setPath("rtsp://192.168.1.1/c=0&s=0");
        videoView.startPlay();
    }


    @Override
    public void eventPlayInit(boolean openClose) {
        Log.i("lh", "=======eventPlayInit============" + openClose);
        if (openClose) {
            showDialog();
        }
    }

    @Override
    public void eventBuffing(int event, float buffing) {
        Log.i("lh", "=======eventBuffing============" + event + "=====buffing====" + buffing);
        if (buffing == 100.0) {
            stopDialog();
        }
    }

    @Override
    public void eventPlay(boolean isPlaying) {
        Log.i("lh", "=======eventPlay============" + isPlaying);
        if (!isPlaying) {
            stopDialog();
        }
    }

    @Override
    public void eventStop(boolean isPlayError) {
        Log.i("lh", "=======eventStop============" + isPlayError);
        stopDialog();
    }

    @Override
    public void eventError(int event, boolean show) {
        Log.i("lh", "=======eventError============" + event + "=====show=====" + show);
        stopDialog();
    }


    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.startPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("lh", "=======onStop============");
        videoView.onStop();
        stopDialog();
    }

    @OnClick(R.id.btn_back_vlcvideo)
    public void btn_back_vlcvideo() {
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        videoView.onDestory();
    }

    private void stopDialog() {
        if (progressDialog != null) {
            progressDialog.hide();
        }
    }

    private void showDialog() {
        if (progressDialog != null) {
            progressDialog.show();
            progressDialog.setMessage("视频正在解码中");
            progressDialog.setCanceledOnTouchOutside(false);
        }
    }
}
