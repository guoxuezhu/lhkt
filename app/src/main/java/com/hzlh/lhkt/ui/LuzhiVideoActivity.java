package com.hzlh.lhkt.ui;

import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.hzlh.lhkt.R;
import com.hzlh.lhkt.utils.ELog;

import java.io.File;
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
    private MediaRecorder mediaRecorder;

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

    @OnClick(R.id.btn_luzhi)
    public void btn_luzhi() {
        mediaRecorder = new MediaRecorder();
        mediaRecorder.reset();
        if (camera != null) {
            mediaRecorder.setCamera(camera);
        }
//        mediaRecorder.setOnErrorListener(this);
        mediaRecorder.setPreviewDisplay(surfaceHolder.getSurface());
        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);//视频源
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);//音频源
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);//TODO 视频输出格式 也可设为3gp等其他格式
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);//音频格式
        mediaRecorder.setVideoSize(640, 480);//设置分辨率
//        mediaRecorder.setVideoFrameRate(25);//设置每秒帧数 这个设置有可能会出问题，有的手机不支持这种帧率就会录制失败，这里使用默认的帧率，当然视频的大小肯定会受影响
//        LogUtil.e(LOG_TAG,"手机支持的最大像素supportedPictureSizes===="+sizePicture);
//        if (sizePicture < 3000000) {//这里设置可以调整清晰度
//            mediaRecorder.setVideoEncodingBitRate(3000000);
//        } else if (sizePicture <= 5000000) {
//            mediaRecorder.setVideoEncodingBitRate(2 * 1024 * 512);
//        } else {
//            mediaRecorder.setVideoEncodingBitRate(1 * 1024 * 512);
//        }
        //这里设置可以调整清晰度
        mediaRecorder.setVideoEncodingBitRate(3000000);
        mediaRecorder.setOrientationHint(90);//输出旋转90度，保持竖屏录制

        mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);//视频录制格式
        //mediaRecorder.setMaxDuration(Constant.MAXVEDIOTIME * 1000);//设置记录会话的最大持续时间（毫秒）

        //设置视频存储路径
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES) + File.separator + "gxzvideo");
        if (!file.exists()) {
            //多级文件夹的创建
            file.mkdirs();
        }
        ELog.i("=======设置视频存储路径====" + file.getPath() + File.separator + "乐舞_" + System.currentTimeMillis() + ".mp4");
        mediaRecorder.setOutputFile(file.getPath() + File.separator + "乐舞_" + System.currentTimeMillis() + ".mp4");
//        mediaRecorder.setOutputFile(recordFile.getAbsolutePath());
        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaRecorder.start();

    }

    @OnClick(R.id.btn_stop)
    public void btn_stop() {
        stoplz();
    }


    /**
     * 停止录制
     */
    public void stoplz() {
        if (mediaRecorder != null) {
            mediaRecorder.stop();
            mediaRecorder.reset();
            mediaRecorder.release();
        }

        if (camera != null) {
            camera.lock();
        }
//        openCamera(Camera.CameraInfo.CAMERA_FACING_BACK,surface);//启动预览,可以判断之前是前置摄像头还是后置摄像头来继续启动预览
        ELog.i("============停止录制====");
    }

    private void releaseCamera() {
        if (camera != null) {
            camera.release();
            camera = null;
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stoplz();
        releaseCamera();
    }


}
