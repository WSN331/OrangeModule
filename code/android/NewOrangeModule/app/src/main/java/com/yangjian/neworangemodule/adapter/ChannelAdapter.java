package com.yangjian.neworangemodule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yangjian.neworangemodule.R;
import com.yangjian.neworangemodule.bean.Channel;

import java.util.List;

/**
 * Created by Yang on 2017/11/23.
 * Function：
 */

public class ChannelAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Channel> data;

    public ChannelAdapter(Context context, List<Channel> data) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.channel_item_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.iv = (ImageView) convertView.findViewById(R.id.channel_icon);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.channel_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Channel channel = data.get(position);
        viewHolder.iv.setImageResource(channel.getIcon());
        viewHolder.tv.setText(channel.getName());

        return convertView;
    }

    public static class ViewHolder {
        private ImageView iv;
        private TextView tv;
    }
}
