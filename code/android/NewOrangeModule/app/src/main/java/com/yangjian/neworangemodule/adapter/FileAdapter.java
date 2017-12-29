package com.yangjian.neworangemodule.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yangjian.neworangemodule.R;
import com.yangjian.neworangemodule.bean.UFile;

import java.util.List;

/**
 * Created by Yang on 2017/11/22.
 * Function：
 */

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {

    private List<UFile> data;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener = null;
    private OnRecyclerViewItemLongClickListener onRecyclerViewItemLongClickListener = null;

    public FileAdapter(List<UFile> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.file_item_layout, parent, false);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UFile file = data.get(position);
        if (file != null) {
            holder.file_name.setText(file.getFileName());
            holder.file_icon.setImageResource(file.getFileIcon());
        }
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public void onClick(View v) {
        if (onRecyclerViewItemClickListener != null) {
            onRecyclerViewItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (onRecyclerViewItemLongClickListener != null) {
            onRecyclerViewItemLongClickListener.onItemLongClick(v, (int) v.getTag());
            return true;
        } else {
            return false;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView file_icon;
        private TextView file_name;

        public ViewHolder(View itemView) {
            super(itemView);
            file_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            file_name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnRecyclerViewItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    public void setOnRecyclerViewItemLongClickListener(OnRecyclerViewItemLongClickListener onRecyclerViewItemLongClickListener) {
        this.onRecyclerViewItemLongClickListener = onRecyclerViewItemLongClickListener;
    }
}
