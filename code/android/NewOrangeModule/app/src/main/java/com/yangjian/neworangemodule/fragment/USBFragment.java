package com.yangjian.neworangemodule.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yangjian.neworangemodule.R;
import com.yangjian.neworangemodule.adapter.FADAdapter;
import com.yangjian.neworangemodule.bean.FAD;
import com.yangjian.neworangemodule.bean.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class USBFragment extends Fragment {


    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private View rootView;

    private List<Product> products = new ArrayList<>();

    private FADAdapter adapter;

    public USBFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_usb, container, false);
        ButterKnife.bind(this, rootView);
        initData();
        initView();
        return rootView;
    }

    private void initData() {
        for (int i = 0; i < RecommendFragment.module_images.length; i++) {
            Product product = new Product(RecommendFragment.module_images[i], RecommendFragment.module_names[i], RecommendFragment.module_prices[i]);
            products.add(product);
        }
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapter = new FADAdapter(rootView.getContext(), new FAD(FrameAndDeviceFragment.images[1], FrameAndDeviceFragment.titles[1]), products);
        recyclerView.setAdapter(adapter);
    }

    public static USBFragment newInstance() {

        Bundle args = new Bundle();

        USBFragment fragment = new USBFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
