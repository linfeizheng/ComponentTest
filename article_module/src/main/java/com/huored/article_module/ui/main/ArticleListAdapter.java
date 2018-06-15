package com.huored.article_module.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.huored.article_module.R;
import com.huored.article_module.bean.GankIoResponse;
import com.huored.common_module.utils.AnimationUtil;
import com.huored.common_module.utils.OnItemClickListener;

import java.util.List;

/**
 * @author linfeizheng
 * @date 2017/3/11 13:45
 */

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ViewHolder> {

    private List<GankIoResponse> mData;

    private LayoutInflater mInflater;
    private OnItemClickListener onItemClickListener;

    public ArticleListAdapter(Context mContext) {
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.listitem_article, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final GankIoResponse response = mData.get(position);
        holder.mTvTitle.setText(response.getDesc() != null ? response.getDesc() : "");
        String publishedAt = response.getCreatedAt();
        if (!TextUtils.isEmpty(publishedAt)) {
            int index = publishedAt.indexOf(".");
            publishedAt = publishedAt.substring(0, index).replace("T", "\t");
            holder.mTvDate.setText(publishedAt);
        }
        holder.mTvWho.setText(response.getWho() != null ? response.getWho() : "");
        if (response.getImages() != null && response.getImages().length > 0) {
            holder.mIvAvatar.setVisibility(View.VISIBLE);
            holder.mIvAvatar.setImageURI(response.getImages()[0]);
        } else {
            holder.mIvAvatar.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null)
                    onItemClickListener.onClick(holder.itemView, position);
            }
        });
        AnimationUtil.scaleAnim(holder.itemView, 0.8f);
    }

    @Override
    public int getItemCount() {
        if (null == mData)
            return 0;
        return mData.size();
    }

    public GankIoResponse getItem(int position) {
        return mData.get(position);
    }

    public void setData(List<GankIoResponse> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView mIvAvatar;
        TextView mTvTitle;
        TextView mTvWho;
        TextView mTvDate;

        public ViewHolder(View itemView) {
            super(itemView);
            mIvAvatar = itemView.findViewById(R.id.iv_home_avatar);
            mTvTitle = itemView.findViewById(R.id.tv_home_title);
            mTvWho = itemView.findViewById(R.id.tv_home_who);
            mTvDate = itemView.findViewById(R.id.tv_home_date);
        }
    }
}
