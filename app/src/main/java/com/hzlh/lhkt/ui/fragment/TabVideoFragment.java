package com.hzlh.lhkt.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hzlh.lhkt.R;
import com.hzlh.lhkt.adapter.VideoAdapter;
import com.hzlh.lhkt.adapter.ZyAdapter;
import com.hzlh.lhkt.data.mode.VideoData;
import com.hzlh.lhkt.data.mode.ZhiYuan;
import com.hzlh.lhkt.ui.VideoActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabVideoFragment extends Fragment implements VideoAdapter.CallBack {

    @BindView(R.id.video_recycler_view)
    RecyclerView video_recycler_view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_video_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        init();
    }


    private void init() {
        List<VideoData> videoDatas = new ArrayList<>();

        videoDatas.add(new VideoData(1, "big_buck_bunny",
                "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565254405315&di=9a38173d7d573e390fda4604adfb02c8&imgtype=0&src=http%3A%2F%2Fimg.25pp.com%2Fuploadfile%2Fapp%2Ficon%2F20160709%2F1468019158493007.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244347&di=dc1b28fa76a9a4c209226694c5568d9f&src=http://s4.sinaimg.cn/mw690/003NWKKyzy75jXetImnf3&690",
                "小明", 11,
                "2019-02-12 00:10:00"));


        videoDatas.add(new VideoData(2, "big_buck_bunny",
                "https://flv2.bn.netease.com/videolib1/1811/26/OqJAZ893T/HD/OqJAZ893T-mobile.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244347&di=a2669f7d700986fda070d0e2c3142b2e&src=http://s16.sinaimg.cn/mw690/003Ue8Z9gy6EUSnRtj91f&690",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244591&di=99acce045c549977dba5b475e0921a8d&src=http://i0.article.fd.zol-img.com.cn/t_s640x2000/g5/M00/0C/06/ChMkJ1nEdKKIHFUEAAn7hFqwGREAAgsmAIkW9IACfuc626.jpg",
                "小礼",
                121,
                "2019-02-12 10:10:00"));

        videoDatas.add(new VideoData(3, "big_buck_bunny",
                "https://www.runoob.com/try/demo_source/movie.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565849391&di=e6e1a29b077de02adcfd2400580eb39a&imgtype=jpg&er=1&src=http%3A%2F%2Fs3.sinaimg.cn%2Fmw690%2F002Qzo9Igy6FXGyY6gq52%26amp%3B690",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244643&di=5f4c511b62a8c653ba0d39e6a53267d8&src=http://img2.zol.com.cn/product/135_940x705/202/ceOOPaZIS9PXs.jpg",
                "小李",
                311,
                "2019-02-12 20:10:00"));

        videoDatas.add(new VideoData(4, "big_buck_bunny",
                "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565254405315&di=9a38173d7d573e390fda4604adfb02c8&imgtype=0&src=http%3A%2F%2Fimg.25pp.com%2Fuploadfile%2Fapp%2Ficon%2F20160709%2F1468019158493007.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244347&di=dc1b28fa76a9a4c209226694c5568d9f&src=http://s4.sinaimg.cn/mw690/003NWKKyzy75jXetImnf3&690",
                "小明", 11,
                "2019-02-12 00:10:00"));

        videoDatas.add(new VideoData(5, "big_buck_bunny",
                "https://flv2.bn.netease.com/videolib1/1811/26/OqJAZ893T/HD/OqJAZ893T-mobile.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244347&di=a2669f7d700986fda070d0e2c3142b2e&src=http://s16.sinaimg.cn/mw690/003Ue8Z9gy6EUSnRtj91f&690",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244591&di=99acce045c549977dba5b475e0921a8d&src=http://i0.article.fd.zol-img.com.cn/t_s640x2000/g5/M00/0C/06/ChMkJ1nEdKKIHFUEAAn7hFqwGREAAgsmAIkW9IACfuc626.jpg",
                "小礼",
                121,
                "2019-02-12 10:10:00"));

        videoDatas.add(new VideoData(6, "big_buck_bunny",
                "https://www.runoob.com/try/demo_source/movie.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565849391&di=e6e1a29b077de02adcfd2400580eb39a&imgtype=jpg&er=1&src=http%3A%2F%2Fs3.sinaimg.cn%2Fmw690%2F002Qzo9Igy6FXGyY6gq52%26amp%3B690",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244643&di=5f4c511b62a8c653ba0d39e6a53267d8&src=http://img2.zol.com.cn/product/135_940x705/202/ceOOPaZIS9PXs.jpg",
                "小李",
                311,
                "2019-02-12 20:10:00"));

        videoDatas.add(new VideoData(4, "big_buck_bunny",
                "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565254405315&di=9a38173d7d573e390fda4604adfb02c8&imgtype=0&src=http%3A%2F%2Fimg.25pp.com%2Fuploadfile%2Fapp%2Ficon%2F20160709%2F1468019158493007.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244347&di=dc1b28fa76a9a4c209226694c5568d9f&src=http://s4.sinaimg.cn/mw690/003NWKKyzy75jXetImnf3&690",
                "小明", 11,
                "2019-02-12 00:10:00"));

        videoDatas.add(new VideoData(5, "big_buck_bunny",
                "https://flv2.bn.netease.com/videolib1/1811/26/OqJAZ893T/HD/OqJAZ893T-mobile.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244347&di=a2669f7d700986fda070d0e2c3142b2e&src=http://s16.sinaimg.cn/mw690/003Ue8Z9gy6EUSnRtj91f&690",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244591&di=99acce045c549977dba5b475e0921a8d&src=http://i0.article.fd.zol-img.com.cn/t_s640x2000/g5/M00/0C/06/ChMkJ1nEdKKIHFUEAAn7hFqwGREAAgsmAIkW9IACfuc626.jpg",
                "小礼",
                121,
                "2019-02-12 10:10:00"));

        videoDatas.add(new VideoData(6, "big_buck_bunny",
                "https://www.runoob.com/try/demo_source/movie.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565849391&di=e6e1a29b077de02adcfd2400580eb39a&imgtype=jpg&er=1&src=http%3A%2F%2Fs3.sinaimg.cn%2Fmw690%2F002Qzo9Igy6FXGyY6gq52%26amp%3B690",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244643&di=5f4c511b62a8c653ba0d39e6a53267d8&src=http://img2.zol.com.cn/product/135_940x705/202/ceOOPaZIS9PXs.jpg",
                "小李",
                311,
                "2019-02-12 20:10:00"));

        videoDatas.add(new VideoData(4, "big_buck_bunny",
                "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565254405315&di=9a38173d7d573e390fda4604adfb02c8&imgtype=0&src=http%3A%2F%2Fimg.25pp.com%2Fuploadfile%2Fapp%2Ficon%2F20160709%2F1468019158493007.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244347&di=dc1b28fa76a9a4c209226694c5568d9f&src=http://s4.sinaimg.cn/mw690/003NWKKyzy75jXetImnf3&690",
                "小明", 11,
                "2019-02-12 00:10:00"));

        videoDatas.add(new VideoData(5, "big_buck_bunny",
                "https://flv2.bn.netease.com/videolib1/1811/26/OqJAZ893T/HD/OqJAZ893T-mobile.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244347&di=a2669f7d700986fda070d0e2c3142b2e&src=http://s16.sinaimg.cn/mw690/003Ue8Z9gy6EUSnRtj91f&690",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244591&di=99acce045c549977dba5b475e0921a8d&src=http://i0.article.fd.zol-img.com.cn/t_s640x2000/g5/M00/0C/06/ChMkJ1nEdKKIHFUEAAn7hFqwGREAAgsmAIkW9IACfuc626.jpg",
                "小礼",
                121,
                "2019-02-12 10:10:00"));

        videoDatas.add(new VideoData(6, "big_buck_bunny",
                "https://www.runoob.com/try/demo_source/movie.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565849391&di=e6e1a29b077de02adcfd2400580eb39a&imgtype=jpg&er=1&src=http%3A%2F%2Fs3.sinaimg.cn%2Fmw690%2F002Qzo9Igy6FXGyY6gq52%26amp%3B690",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244643&di=5f4c511b62a8c653ba0d39e6a53267d8&src=http://img2.zol.com.cn/product/135_940x705/202/ceOOPaZIS9PXs.jpg",
                "小李",
                311,
                "2019-02-12 20:10:00"));
        videoDatas.add(new VideoData(4, "big_buck_bunny",
                "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565254405315&di=9a38173d7d573e390fda4604adfb02c8&imgtype=0&src=http%3A%2F%2Fimg.25pp.com%2Fuploadfile%2Fapp%2Ficon%2F20160709%2F1468019158493007.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244347&di=dc1b28fa76a9a4c209226694c5568d9f&src=http://s4.sinaimg.cn/mw690/003NWKKyzy75jXetImnf3&690",
                "小明", 11,
                "2019-02-12 00:10:00"));

        videoDatas.add(new VideoData(5, "big_buck_bunny",
                "https://flv2.bn.netease.com/videolib1/1811/26/OqJAZ893T/HD/OqJAZ893T-mobile.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244347&di=a2669f7d700986fda070d0e2c3142b2e&src=http://s16.sinaimg.cn/mw690/003Ue8Z9gy6EUSnRtj91f&690",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244591&di=99acce045c549977dba5b475e0921a8d&src=http://i0.article.fd.zol-img.com.cn/t_s640x2000/g5/M00/0C/06/ChMkJ1nEdKKIHFUEAAn7hFqwGREAAgsmAIkW9IACfuc626.jpg",
                "小礼",
                121,
                "2019-02-12 10:10:00"));

        videoDatas.add(new VideoData(6, "big_buck_bunny",
                "https://www.runoob.com/try/demo_source/movie.mp4",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565849391&di=e6e1a29b077de02adcfd2400580eb39a&imgtype=jpg&er=1&src=http%3A%2F%2Fs3.sinaimg.cn%2Fmw690%2F002Qzo9Igy6FXGyY6gq52%26amp%3B690",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1565244643&di=5f4c511b62a8c653ba0d39e6a53267d8&src=http://img2.zol.com.cn/product/135_940x705/202/ceOOPaZIS9PXs.jpg",
                "小李",
                311,
                "2019-02-12 20:10:00"));

        VideoAdapter videoAdapter = new VideoAdapter(getView().getContext(), videoDatas, this);

        GridLayoutManager mLayoutManager = new GridLayoutManager(getView().getContext(), 2, OrientationHelper.VERTICAL, false);
        video_recycler_view.setLayoutManager(mLayoutManager);
        video_recycler_view.setAdapter(videoAdapter);
    }


    @Override
    public void onClickItem(VideoData item) {
//        Toast.makeText(getView().getContext(), item.username, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), VideoActivity.class);
        intent.putExtra("videoUrl", item.videourl);
        startActivity(intent);
    }
}
