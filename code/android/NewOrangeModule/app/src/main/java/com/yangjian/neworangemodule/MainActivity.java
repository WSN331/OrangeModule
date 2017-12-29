package com.yangjian.neworangemodule;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yangjian.neworangemodule.fragment.DeviceFragment;
import com.yangjian.neworangemodule.fragment.MineFragment;
import com.yangjian.neworangemodule.fragment.ShopFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;
    private RadioButton deviceBtn, shopBtn, mineBtn;
    private Fragment deviceFragment, shopFragment, mineFragment;
    private FragmentManager fragmentManager;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.main_content, deviceFragment).commit();
        fragment = deviceFragment;
    }

    //初始化
    private void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        deviceBtn = (RadioButton) findViewById(R.id.device_btn);
        shopBtn = (RadioButton) findViewById(R.id.shop_btn);
        mineBtn = (RadioButton) findViewById(R.id.mine_btn);
        radioGroup.setOnCheckedChangeListener(this);

        deviceFragment = DeviceFragment.newInstance();
    }

    //启动MainActivity
    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    //切换按钮的逻辑
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.device_btn:
                if (deviceFragment == null) {
                    deviceFragment = DeviceFragment.newInstance();
                }
                switchFragment(deviceFragment);
                break;
            case R.id.shop_btn:
                if (shopFragment == null) {
                    shopFragment = ShopFragment.newInstance();
                }
                switchFragment(shopFragment);
                break;
            case R.id.mine_btn:
                if (mineFragment == null) {
                    mineFragment = MineFragment.newInstance();
                }
                switchFragment(mineFragment);
                break;
            default:
                break;
        }
    }

    //判断fragment是否添加，避免重复添加
    private void switchFragment(Fragment fm) {
        if (fragment != fm) {
            if (!fm.isAdded()) {
                fragmentManager.beginTransaction().hide(fragment).add(R.id.main_content, fm).commit();
            } else {
                fragmentManager.beginTransaction().hide(fragment).show(fm).commit();
            }
            fragment = fm;
        }
    }
}
