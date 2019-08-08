package com.hzlh.lhkt.ui;

import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.hzlh.lhkt.R;
import com.hzlh.lhkt.utils.ELog;

import java.io.IOException;
import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LuzhiVideoActivity extends BaseActivity {

    @BindView(R.id.video_surfaceView)
    SurfaceView video_surfaceView;

    private SurfaceHolder surfaceHolder;
    private Camera camera;
    private Camera.Parameters parameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luzhi_video);
        ButterKnife.bind(this);

        surfaceHolder = video_surfaceView.getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceHolder.setKeepScreenOn(true);
        video_surfaceView.setFocusable(true);
        video_surfaceView.setBackgroundColor(TRIM_MEMORY_BACKGROUND);


        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                // TODO Auto-generated method stub
                camera.stopPreview();
                camera.release();
                camera = null;

            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                // TODO Auto-generated method stub
                if (null == camera) {
                    camera = Camera.open();
                    try {
                        camera.setPreviewDisplay(surfaceHolder);
                        initCamera();
                        camera.startPreview();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                ELog.i("--------------实现自动对焦-----------------------");
                //实现自动对焦
                camera.autoFocus(new Camera.AutoFocusCallback() {
                    @Override
                    public void onAutoFocus(boolean success, Camera camera) {
                        ELog.i("===========================" + success);
                        if (success) {
                            initCamera();//实现相机的参数初始化
                            camera.cancelAutoFocus();//只有加上了这一句，才会自动对焦。
                        }
                    }

                });
            }

        });
    }

    //相机参数的初始化设置
    private void initCamera() {
        parameters = camera.getParameters();
        parameters.setPictureFormat(PixelFormat.JPEG);
        //parameters.setPictureSize(surfaceView.getWidth(), surfaceView.getHeight());  // 部分定制手机，无法正常识别该方法。
        //parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);//1连续对焦
        setDispaly(parameters, camera);
        camera.setParameters(parameters);
        camera.startPreview();
        camera.cancelAutoFocus();// 2如果要实现连续的自动对焦，这一句必须加上

    }

    //控制图像的正确显示方向
    private void setDispaly(Camera.Parameters parameters, Camera camera) {
        if (Integer.parseInt(Build.VERSION.SDK) >= 8) {
            setDisplayOrientation(camera, 90);
        } else {
            parameters.setRotation(90);
        }

    }

    //实现的图像的正确显示
    private void setDisplayOrientation(Camera camera, int i) {
        Method downPolymorphic;
        try {
            downPolymorphic = camera.getClass().getMethod("setDisplayOrientation", new Class[]{int.class});
            if (downPolymorphic != null) {
                downPolymorphic.invoke(camera, new Object[]{i});
            }
        } catch (Exception e) {
            ELog.e("================Camera 图像出错");
        }
    }

    @OnClick(R.id.btn_back_luzhi)
    public void btn_back_luzhi() {
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
