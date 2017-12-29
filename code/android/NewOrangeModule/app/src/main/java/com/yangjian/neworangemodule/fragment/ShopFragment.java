package com.yangjian.neworangemodule.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yangjian.neworangemodule.R;
import com.yangjian.neworangemodule.adapter.TabAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment {

    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private View rootView;
    public static final String[] titles = {"推荐", "框架", "USB模块", "蓝牙模块"};
    private Fragment recommendFragment, frameFragment, usbFragment, bluetoothFragment;
    private List<Fragment> fragments = new ArrayList<>();
    private TabAdapter adapter;

    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    //初始化界面
    private void initView() {
        switchFragment();
        adapter = new TabAdapter(getFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void switchFragment() {
        if (recommendFragment == null) {
            recommendFragment = RecommendFragment.newInstance();
            fragments.add(recommendFragment);
        }
        if (frameFragment == null) {
            frameFragment = FrameAndDeviceFragment.newInstance();
            fragments.add(frameFragment);
        }
        if (usbFragment == null) {
            usbFragment = USBFragment.newInstance();
            fragments.add(usbFragment);
        }
        if (bluetoothFragment == null) {
            bluetoothFragment = BluetoothFragment.newInstance();
            fragments.add(bluetoothFragment);
        }
    }


    public static ShopFragment newInstance() {

        Bundle args = new Bundle();

        ShopFragment fragment = new ShopFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
