package com.jg.myproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.jg.myproject.widget.banner.BannerLayout;
import com.zcr.myproject.R;

/**
 * Created by test on 2017/11/22.
 */


public class BannerAdapter2 extends RecyclerView.Adapter<BannerAdapter2.MzViewHolder> {

    private Context context;
    private BannerLayout.OnBannerItemClickListener onBannerItemClickListener;

    public BannerAdapter2(Context context) {
        this.context = context;
    }

    //可优化使用url添加图片
    private int[] imgs = {
            R.drawable.dimage1,
            R.drawable.dimage2,
    };

    public void setOnBannerItemClickListener(BannerLayout.OnBannerItemClickListener onBannerItemClickListener) {
        this.onBannerItemClickListener = onBannerItemClickListener;
    }

    @Override
    public BannerAdapter2.MzViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MzViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(BannerAdapter2.MzViewHolder holder, final int position) {
        if (imgs == null || imgs.length == 0)
            return;
        ImageView img = (ImageView) holder.imageView;
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH);
        Glide.with(context).load(imgs[position]).apply(options).into(img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onBannerItemClickListener != null) {
                    onBannerItemClickListener.onItemClick(position);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return imgs != null ? imgs.length : 0;
    }


    class MzViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        MzViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }

}
