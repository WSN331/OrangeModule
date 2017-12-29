package com.yangjian.neworangemodule.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yangjian.neworangemodule.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GoodsActivity extends AppCompatActivity {

    @Bind(R.id.device_btn)
    RadioButton deviceBtn;
    @Bind(R.id.shop_btn)
    RadioButton shopBtn;
    @Bind(R.id.mine_btn)
    RadioButton mineBtn;
    @Bind(R.id.mine_btn2)
    RadioButton mineBtn2;
    @Bind(R.id.radioGroup)
    RadioGroup radioGroup;
    @Bind(R.id.activity_goods)
    LinearLayout activityGoods;
    @Bind(R.id.iv_module_image)
    ImageView ivModuleImage;
    @Bind(R.id.tv_module_title)
    TextView tvModuleTitle;
    @Bind(R.id.tv_module_price)
    TextView tvModulePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        ButterKnife.bind(this);

        initData();
        initListener();
    }

    private void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String price = intent.getStringExtra("price");
        int image = intent.getIntExtra("image", R.drawable.paq5);
        tvModuleTitle.setText(title);
        tvModulePrice.setText(price);
        ivModuleImage.setImageResource(image);
    }

    private void initListener() {
        shopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoppingCarActivity.startActivity(GoodsActivity.this);
            }
        });
    }

}
