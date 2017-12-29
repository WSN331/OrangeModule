package com.yangjian.neworangemodule.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yangjian.neworangemodule.R;
import com.yangjian.neworangemodule.activity.AirActivity;
import com.yangjian.neworangemodule.activity.CascophenActivity;
import com.yangjian.neworangemodule.activity.FrameActivity;
import com.yangjian.neworangemodule.activity.UdiskActivity;
import com.yangjian.neworangemodule.activity.WaterActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeviceFragment extends Fragment {

    @Bind(R.id.tv_pm25)
    TextView tvPm25;
    @Bind(R.id.air_layout)
    LinearLayout airLayout;
    @Bind(R.id.tv_tds)
    TextView tvTds;
    @Bind(R.id.water_layout)
    LinearLayout waterLayout;
    @Bind(R.id.tv_cascophen)
    TextView tvCascophen;
    @Bind(R.id.cascophen_layout)
    LinearLayout cascophenLayout;
    @Bind(R.id.tv_udisk)
    TextView tvUdisk;
    @Bind(R.id.udisk_layout)
    LinearLayout udiskLayout;
    @Bind(R.id.tv_state)
    TextView tvState;
    @Bind(R.id.tv_electricity)
    TextView tvElectricity;
    @Bind(R.id.tv_voltage)
    TextView tvVoltage;
    @Bind(R.id.frame_layout)
    LinearLayout frameLayout;

    private View rootView;

    public DeviceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_device, container, false);
        ButterKnife.bind(this, rootView);
        initClickListener();
        return rootView;
    }

    private void initClickListener() {
        //空气模块点击事件，进入详情界面
        airLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AirActivity.startActivity(rootView.getContext());
            }
        });

        //水质模块点击事件，进入详情界面
        waterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WaterActivity.startActivity(rootView.getContext());
            }
        });

        //甲醛模块点击事件，进入详情界面
        cascophenLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CascophenActivity.startActivity(rootView.getContext());
            }
        });

        //U盘模块点击事件，进入详情界面
        udiskLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UdiskActivity.startActivity(rootView.getContext());
            }
        });

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameActivity.startActivity(rootView.getContext());
            }
        });

    }

    public static DeviceFragment newInstance() {

        Bundle args = new Bundle();

        DeviceFragment fragment = new DeviceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
