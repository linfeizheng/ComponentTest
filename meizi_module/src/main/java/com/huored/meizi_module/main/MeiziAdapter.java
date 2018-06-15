package com.huored.meizi_module.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.huored.meizi_module.R;

/**
 * Created by danao on 2018/6/14.
 */
public class MeiziAdapter extends RecyclerView.Adapter<MeiziAdapter.ViewHolder> {

    private String[] images;

    private LayoutInflater mInflater;

    public MeiziAdapter(Context mContext) {
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.listitem_meizi, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImageView.setImageURI(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public void setData(String[] images) {
        this.images = images;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }
}
