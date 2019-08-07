package com.hzlh.lhkt.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hzlh.lhkt.R;
import com.hzlh.lhkt.adapter.ZyAdapter;
import com.hzlh.lhkt.data.mode.ZhiYuan;
import com.hzlh.lhkt.ui.VideoActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class TabZiyuanFragment extends Fragment implements ZyAdapter.CallBack {

    @BindView(R.id.zy_recycler_view)
    RecyclerView zy_recycler_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_zy_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        init();
    }

    private void init() {
        List<ZhiYuan> zhiYuans = new ArrayList<>();

        zhiYuans.add(new ZhiYuan("历史文案一",
                "http://img4.duitang.com/uploads/item/201306/26/20130626090600_AE4Pn.thumb.700_0.jpeg",
                "尽管及时取消不必要的加载是很好的实践，但这并不是必须的操作。实际上，当 Glide.with() 中传入的 Activity 或 Fragment 实例销毁时，Glide 会自动取消加载并回收资源。尽管及时取消不必要的加载是很好的实践，但这并不是必须的操作。实际上，当 Glide.with() 中传入的 Activity 或 Fragment 实例销毁时，Glide 会自动取消加载并回收资源。尽管及时取消不必要的加载是很好的实践，但这并不是必须的操作。实际上，当 Glide.with() 中传入的 Activity 或 Fragment 实例销毁时，Glide 会自动取消加载并回收资源。尽管及时取消不必要的加载是很好的实践，但这并不是必须的操作。实际上，当 Glide.with() 中传入的 Activity 或 Fragment 实例销毁时，Glide 会自动取消加载并回收资源。尽管及时取消不必要的加载是很好的实践，但这并不是必须的操作。实际上，当 Glide.with() 中传入的 Activity 或 Fragment 实例销毁时，Glide 会自动取消加载并回收资源。尽管及时取消不必要的加载是很好的实践，但这并不是必须的操作。实际上，当 Glide.with() 中传入的 Activity 或 Fragment 实例销毁时，Glide 会自动取消加载并回收资源。",
                "2019-12-12 00:00:00"));

        zhiYuans.add(new ZhiYuan("语文文案一",
                "http://img4.duitang.com/uploads/item/201310/28/20131028090316_ucN8c.thumb.700_0.jpeg",
                "Glide 提供了许多可应用于单一请求的选项，包括变换、过渡、缓存选项等。Glide 提供了许多可应用于单一请求的选项，包括变换、过渡、缓存选项等。Glide 提供了许多可应用于单一请求的选项，包括变换、过渡、缓存选项等。Glide 提供了许多可应用于单一请求的选项，包括变换、过渡、缓存选项等。",
                "2019-12-12 00:02:00"));

        zhiYuans.add(new ZhiYuan("语文文案2",
                "http://img4.duitang.com/uploads/item/201302/24/20130224140042_x8dmi.thumb.700_0.jpeg",
                "对于更高级的使用场景，通过使用 Glide 的 generated API，Glide 的 API 还可以被更深度地定制以包含自定义的选项。对于更高级的使用场景，通过使用 Glide 的 generated API，Glide 的 API 还可以被更深度地定制以包含自定义的选项。对于更高级的使用场景，通过使用 Glide 的 generated API，Glide 的 API 还可以被更深度地定制以包含自定义的选项。对于更高级的使用场景，通过使用 Glide 的 generated API，Glide 的 API 还可以被更深度地定制以包含自定义的选项。对于更高级的使用场景，通过使用 Glide 的 generated API，Glide 的 API 还可以被更深度地定制以包含自定义的选项。对于更高级的使用场景，通过使用 Glide 的 generated API，Glide 的 API 还可以被更深度地定制以包含自定义的选项。",
                "2019-12-12 00:04:00"));

        zhiYuans.add(new ZhiYuan("语文文案3",
                "http://cdn.duitang.com/uploads/item/201410/06/20141006213125_PtNn8.thumb.700_0.jpeg",
                "在 ListView 或 RecyclerView 中加载图片的代码和在单独的 View 中加载完全一样。Glide 已经自动处理了 View 的复用和请求的取消：在 ListView 或 RecyclerView 中加载图片的代码和在单独的 View 中加载完全一样。Glide 已经自动处理了 View 的复用和请求的取消：在 ListView 或 RecyclerView 中加载图片的代码和在单独的 View 中加载完全一样。Glide 已经自动处理了 View 的复用和请求的取消：在 ListView 或 RecyclerView 中加载图片的代码和在单独的 View 中加载完全一样。Glide 已经自动处理了 View 的复用和请求的取消：在 ListView 或 RecyclerView 中加载图片的代码和在单独的 View 中加载完全一样。Glide 已经自动处理了 View 的复用和请求的取消：在 ListView 或 RecyclerView 中加载图片的代码和在单独的 View 中加载完全一样。Glide 已经自动处理了 View 的复用和请求的取消：",
                "2019-12-12 05:00:00"));

        zhiYuans.add(new ZhiYuan("语文文案5",
                "http://m.360buyimg.com/pop/jfs/t23434/230/1763906670/10667/55866a07/5b697898N78cd1466.jpg",
                "而又没有开启新的加载操作，那么就会出现这种情况，你已经为一个 view 设置好了一个 Drawable，但该 view 在之前的位置上使用 Glide 进行而又没有开启新的加载操作，那么就会出现这种情况，你已经为一个 view 设置好了一个 Drawable，但该 view 在之前的位置上使用 Glide 进行而又没有开启新的加载操作，那么就会出现这种情况，你已经为一个 view 设置好了一个 Drawable，但该 view 在之前的位置上使用 Glide 进行而又没有开启新的加载操作，那么就会出现这种情况，你已经为一个 view 设置好了一个 Drawable，但该 view 在之前的位置上使用 Glide 进行而又没有开启新的加载操作，那么就会出现这种情况，你已经为一个 view 设置好了一个 Drawable，但该 view 在之前的位置上使用 Glide 进行",
                "2019-12-12 06:00:00"));

        zhiYuans.add(new ZhiYuan("语文文案7",
                "http://img5.duitang.com/uploads/item/201410/11/20141011040700_3iXsj.thumb.700_0.jpeg",
                "使用自定义 Target 有一些陷阱，所以请务必阅读 目标文档页 的详细内容。使用自定义 Target 有一些陷阱，所以请务必阅读 目标文档页 的详细内容。使用自定义 Target 有一些陷阱，所以请务必阅读 目标文档页 的详细内容。使用自定义 Target 有一些陷阱，所以请务必阅读 目标文档页 的详细内容。使用自定义 Target 有一些陷阱，所以请务必阅读 目标文档页 的详细内容。使用自定义 Target 有一些陷阱，所以请务必阅读 目标文档页 的详细内容。使用自定义 Target 有一些陷阱，所以请务必阅读 目标文档页 的详细内容。",
                "2019-12-12 00:00:08"));

        zhiYuans.add(new ZhiYuan("语文文案444",
                "http://img4.duitang.com/uploads/item/201112/19/20111219183951_HHRLG.thumb.700_0.jpg",
                "如果你不想让 Bitmap 和 Drawable 自身在后台线程中，你也可以使用和前台线程一样的方式来开始异步加载：如果你不想让 Bitmap 和 Drawable 自身在后台线程中，你也可以使用和前台线程一样的方式来开始异步加载：如果你不想让 Bitmap 和 Drawable 自身在后台线程中，你也可以使用和前台线程一样的方式来开始异步加载：如果你不想让 Bitmap 和 Drawable 自身在后台线程中，你也可以使用和前台线程一样的方式来开始异步加载：如果你不想让 Bitmap 和 Drawable 自身在后台线程中，你也可以使用和前台线程一样的方式来开始异步加载：如果你不想让 Bitmap 和 Drawable 自身在后台线程中，你也可以使用和前台线程一样的方式来开始异步加载：如果你不想让 Bitmap 和 Drawable 自身在后台线程中，你也可以使用和前台线程一样的方式来开始异步加载：如果你不想让 Bitmap 和 Drawable 自身在后台线程中，你也可以使用和前台线程一样的方式来开始异步加载：",
                "2019-12-12 05:03:01"));

        ZyAdapter zyAdapter = new ZyAdapter(getView().getContext(), zhiYuans, this);

        LinearLayoutManager manager = new LinearLayoutManager(getView().getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        zy_recycler_view.setLayoutManager(manager);
        zy_recycler_view.setAdapter(zyAdapter);
    }


    @Override
    public void onClickItem(ZhiYuan item) {
        Toast.makeText(getView().getContext(), item.name, Toast.LENGTH_SHORT).show();
    }
}
