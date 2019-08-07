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
import com.hzlh.lhkt.data.mode.ZhiYuan;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ZyAdapter extends RecyclerView.Adapter<ZyAdapter.ZyViewHolder> {

    private Context mContext;
    private List<ZhiYuan> datas;
    private CallBack mCallBack;

    public ZyAdapter(Context context, List<ZhiYuan> data, CallBack callBack) {
        this.datas = data;
        this.mContext = context;
        this.mCallBack = callBack;
    }

    @NonNull
    @Override
    public ZyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.zy_item, parent, false);
        return new ZyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZyViewHolder holder, int position) {
        ZhiYuan zhiYuan = datas.get(position);
        Glide.with(mContext).load(zhiYuan.imageurl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .dontAnimate()
                .into(holder.item_zy_img);

//        RequestOptions requestOptions = new RequestOptions()
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher)
//                .circleCrop()
//                .dontAnimate();
//        Glide.with(mContext).load(zhiYuan.imageurl)
//                .apply(requestOptions)
//                .into(holder.item_zy_img);

        holder.item_zy_name.setText(zhiYuan.name);
        holder.item_zy_time.setText(zhiYuan.time);
        holder.item_zy_content.setText(zhiYuan.content);

        holder.setItem(zhiYuan);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public void setData(List<ZhiYuan> zhiYuans) {
        datas = zhiYuans;
        notifyDataSetChanged();
    }

    public interface CallBack {
        void onClickItem(ZhiYuan item);
    }

    public class ZyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_zy_img)
        ImageView item_zy_img;
        @BindView(R.id.item_zy_name)
        TextView item_zy_name;
        @BindView(R.id.item_zy_time)
        TextView item_zy_time;
        @BindView(R.id.item_zy_content)
        TextView item_zy_content;


        private ZhiYuan item;


        public ZyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void setItem(ZhiYuan zhiYuan) {
            item = zhiYuan;
        }

        @OnClick(R.id.item_LL)
        public void item_LL() {
            mCallBack.onClickItem(item);
        }

    }
}
