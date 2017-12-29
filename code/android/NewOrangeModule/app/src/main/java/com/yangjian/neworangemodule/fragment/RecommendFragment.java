package com.yangjian.neworangemodule.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yangjian.neworangemodule.R;
import com.yangjian.neworangemodule.adapter.RecommendAdapter;
import com.yangjian.neworangemodule.bean.Banner;
import com.yangjian.neworangemodule.bean.Channel;
import com.yangjian.neworangemodule.bean.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private static final int[] images = {R.drawable.paq1, R.drawable.paq2, R.drawable.paq4, R.drawable.paq5, R.drawable.paq7};
    private static final int[] icons = {R.drawable.snew, R.drawable.recommend, R.drawable.timeshop, R.drawable.zhongc, R.drawable.more};
    private static final String[] titles = {"上新", "推荐", "抢购", "众筹", "更多"};

    public static final int[] module_images = {R.drawable.backup_memory, R.drawable.speaker, R.drawable.laser_pointer,
                                                R.drawable.temp_hum_mod, R.drawable.led, R.drawable.usb, R.drawable.dummy, R.drawable.hotkey};
    public static final String[] module_names = {"存储管理", "扬声器", "激光笔", "温湿度传感器", "闪光灯", "USB扩展", "扩展槽", "热键"};
    public static final String[] module_prices = {"¥200", "¥150", "¥80", "¥100", "¥200", "¥200", "¥25", "¥80"};

    private View rootView;
    private List<Product> products = new ArrayList<>();
    private List<Channel> channels = new ArrayList<>();
    private List<Banner> banners = new ArrayList<>();

    public RecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, rootView);

        initData();
        initView();
        return rootView;
    }

    private void initData() {
        for (int i = 0; i < images.length; i++) {
            Banner banner = new Banner(images[i]);
            banners.add(banner);

            Channel channel = new Channel(titles[i], icons[i]);
            channels.add(channel);
        }

        for (int i = 0; i < module_images.length; i++) {
            Product product = new Product(module_images[i], module_names[i], module_prices[i]);
            products.add(product);
        }
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(new RecommendAdapter(rootView.getContext(), products, channels, banners));
    }

    public static RecommendFragment newInstance() {

        Bundle args = new Bundle();

        RecommendFragment fragment = new RecommendFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
