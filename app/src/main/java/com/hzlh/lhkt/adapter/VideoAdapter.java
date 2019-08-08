package com.hzlh.lhkt.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hzlh.lhkt.R;
import com.hzlh.lhkt.data.mode.VideoData;
import com.hzlh.lhkt.data.mode.ZhiYuan;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private Context mContext;
    private List<VideoData> datas;
    private CallBack mCallBack;

    public VideoAdapter(Context context, List<VideoData> data, CallBack callBack) {
        this.datas = data;
        this.mContext = context;
        this.mCallBack = callBack;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        VideoData videoData = datas.get(position);
        Glide.with(mContext).load(videoData.videoImgurl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .dontAnimate()
                .into(holder.item_video_img);

        Glide.with(mContext).load(videoData.userImgurl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .dontAnimate()
                .into(holder.item_user_img);


        holder.item_video_user_name.setText(videoData.username);
        holder.item_video_num.setText(videoData.looknum+"");

        holder.setItem(videoData);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public void setData(List<VideoData> videoDatas) {
        datas = videoDatas;
        notifyDataSetChanged();
    }

    public interface CallBack {
        void onClickItem(VideoData item);
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_video_img)
        ImageView item_video_img;
        @BindView(R.id.item_user_img)
        CircleImageView item_user_img;
        @BindView(R.id.item_video_user_name)
        TextView item_video_user_name;
        @BindView(R.id.item_video_num)
        TextView item_video_num;


        private VideoData item;


        public VideoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void setItem(VideoData videoData) {
            item = videoData;
        }

        @OnClick(R.id.item_video_img)
        public void item_video_img() {
            mCallBack.onClickItem(item);
        }

    }
}
