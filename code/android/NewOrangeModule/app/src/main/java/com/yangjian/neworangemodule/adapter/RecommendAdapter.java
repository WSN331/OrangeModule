package com.yangjian.neworangemodule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.yangjian.neworangemodule.R;
import com.yangjian.neworangemodule.bean.Banner;
import com.yangjian.neworangemodule.bean.Channel;
import com.yangjian.neworangemodule.bean.Product;

import java.util.List;

import ezy.ui.view.BannerView;

/**
 * Created by Yang on 2017/11/23.
 * Function：
 */

public class RecommendAdapter extends RecyclerView.Adapter {

    private static final int BANNER = 0;
    private static final int CHANNEL = 1;
    private static final int RECOMMEND = 2;

    private int currentType = BANNER;
    private List<Product> products;
    private List<Channel> channels;
    private List<Banner> banners;

    private Context context;
    private LayoutInflater inflater;

    private ChannelAdapter channelAdapter;
    private ShopAdapter shopAdapter;

    public RecommendAdapter(Context context, List<Product> products, List<Channel> channels, List<Banner> banners) {
        this.products = products;
        this.channels = channels;
        this.banners = banners;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            return new BannerViewHolder(inflater.inflate(R.layout.banner_layout, parent, false));
        } else if(viewType == CHANNEL) {
            return new ChannelViewHolder(inflater.inflate(R.layout.channel_layout, parent, false));
        } else if (viewType == RECOMMEND) {
            return new RecommendViewHolder(inflater.inflate(R.layout.recommend_layout, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BANNER) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.bannerView.setViewFactory(new BannerViewFactory());
            bannerViewHolder.bannerView.setDataList(banners);
            bannerViewHolder.bannerView.start();
        } else if (getItemViewType(position) == CHANNEL) {
            ChannelViewHolder channelViewHolder = (ChannelViewHolder) holder;
            channelAdapter = new ChannelAdapter(context, channels);
            ((ChannelViewHolder) holder).gridView.setAdapter(channelAdapter);
        } else if (getItemViewType(position) == RECOMMEND) {
            RecommendViewHolder recommendViewHolder = (RecommendViewHolder) holder;
            shopAdapter = new ShopAdapter(products, context);
            recommendViewHolder.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            recommendViewHolder.recyclerView.setAdapter(shopAdapter);
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case BANNER:
                currentType = BANNER;
                break;
            case CHANNEL:
                currentType = CHANNEL;
                break;
            case RECOMMEND:
                currentType = RECOMMEND;
                break;
        }
        return currentType;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class BannerViewHolder extends RecyclerView.ViewHolder {

        private BannerView bannerView;

        public BannerViewHolder(View itemView) {
            super(itemView);
            bannerView = (BannerView) itemView.findViewById(R.id.bannerView);
        }
    }

    public static class BannerViewFactory implements BannerView.ViewFactory<Banner> {

        @Override
        public View create(Banner banner, int position, ViewGroup container) {
            ImageView iv = new ImageView(container.getContext());
            iv.setImageResource(banner.getImage());
            return iv;
        }
    }

    public static class ChannelViewHolder extends RecyclerView.ViewHolder {

        private GridView gridView;

        public ChannelViewHolder(View itemView) {
            super(itemView);
            gridView = (GridView) itemView.findViewById(R.id.gridView);
        }
    }

    public static class RecommendViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView recyclerView;

        public RecommendViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }
    }
}
