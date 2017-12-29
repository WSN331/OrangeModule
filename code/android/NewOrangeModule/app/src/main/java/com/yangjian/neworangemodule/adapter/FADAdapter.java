package com.yangjian.neworangemodule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yangjian.neworangemodule.R;
import com.yangjian.neworangemodule.bean.FAD;
import com.yangjian.neworangemodule.bean.Product;

import java.util.List;

/**
 * Created by Yang on 2017/11/23.
 * Function：
 */

public class FADAdapter extends RecyclerView.Adapter {

    private static final int HEADER = 0;
    private static final int FOOTER = 1;

    private int currentType = 0;

    private Context context;
    private FAD fad;
    private List<Product> products;
    private LayoutInflater inflater;

    private ShopAdapter adapter;

    public FADAdapter(Context context, FAD fad, List<Product> products) {
        this.context = context;
        this.fad = fad;
        this.products = products;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER) {
            return new HeaderViewHolder(inflater.inflate(R.layout.fad_item_layout, parent, false));
        } else if (viewType == FOOTER) {
            return new FooterViewHolder(inflater.inflate(R.layout.recommend_layout, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == HEADER) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.iv.setImageResource(fad.getImage());
            headerViewHolder.tv.setText(fad.getTitle());
        } else if (getItemViewType(position) == FOOTER) {
            FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
            adapter = new ShopAdapter(products, context);
            footerViewHolder.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            footerViewHolder.recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case HEADER:
                currentType = HEADER;
                break;
            case FOOTER:
                currentType = FOOTER;
                break;
        }
        return currentType;
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;
        private TextView tv;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.fad_image);
            tv = (TextView) itemView.findViewById(R.id.fad_title);
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView recyclerView;

        public FooterViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }
    }
}
