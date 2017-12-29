package com.yangjian.neworangemodule.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yangjian.neworangemodule.R;
import com.yangjian.neworangemodule.adapter.ShopCarAdapter;
import com.yangjian.neworangemodule.bean.Product;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShoppingCarActivity extends AppCompatActivity {

    @Bind(R.id.rlv_shopcart)
    RecyclerView rlvShopcart;
    @Bind(R.id.tv_shopcart_addselect)
    TextView tvShopcartAddselect;
    @Bind(R.id.tv_shopcart_totalprice)
    TextView tvShopcartTotalprice;
    @Bind(R.id.tv_shopcart_totalnum)
    TextView tvShopcartTotalnum;
    @Bind(R.id.tv_shopcart_submit)
    TextView tvShopcartSubmit;
    @Bind(R.id.ll_pay)
    LinearLayout llPay;
    @Bind(R.id.emtryview)
    View emtryview;
    @Bind(R.id.rl_shopcart)
    RelativeLayout rlShopcart;
    @Bind(R.id.activity_shopping_car)
    LinearLayout activityShoppingCar;

    private List<Product> data = new ArrayList<>();
    private List<Product> buys = new ArrayList<>();
    private ShopCarAdapter adapter;
    private boolean selected;
    private float mTotalPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_car);
        ButterKnife.bind(this);

        initData();

        rlvShopcart.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShopCarAdapter(this, data);
        rlvShopcart.setAdapter(adapter);

        initListener();

    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ShoppingCarActivity.class);
        context.startActivity(intent);
    }

    private void initData() {
        Product p1 = new Product(R.drawable.led, "LED模块", "100", 1, true);
        Product p2 = new Product(R.drawable.laser_pointer, "激光笔模块", "200", 1, true);
        Product p3 = new Product(R.drawable.laser_pointer, "激光笔模块", "200", 1, true);
        Product p4 = new Product(R.drawable.laser_pointer, "激光笔模块", "200", 1, true);
        Product p5 = new Product(R.drawable.laser_pointer, "激光笔模块", "200", 1, true);
        Product p6 = new Product(R.drawable.laser_pointer, "激光笔模块", "200", 1, true);
        data.add(p1);
        data.add(p2);
        data.add(p3);
        data.add(p4);
        data.add(p5);
        data.add(p6);
    }

    private void initListener() {
        adapter.setResfreshListener(new ShopCarAdapter.OnResfreshListener() {
            @Override
            public void onResfresh(boolean isSelect) {
                selected = isSelect;
                if (isSelect) {
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_selected);
                    tvShopcartAddselect.setCompoundDrawablesWithIntrinsicBounds(left,null,null,null);
                } else {
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_unselected);
                    tvShopcartAddselect.setCompoundDrawablesWithIntrinsicBounds(left,null,null,null);
                }
                float totalPrice = 0;
                int totalNum = 0;
                buys.clear();
                for (int i = 0; i < data.size() ; i++) {
                    if (data.get(i).isSelected()) {
                        totalPrice += Float.parseFloat(data.get(i).getPrice()) * data.get(i).getCount();
                        totalNum += data.get(i).getCount();
                        buys.add(data.get(i));
                    }
                }
                mTotalPrice = totalPrice;
                tvShopcartTotalprice.setText("总价：" + mTotalPrice);
                tvShopcartTotalnum.setText("共" + totalNum + "件商品");
            }
        });
        //全选点击
        tvShopcartAddselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = !selected;
                if (selected) {
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_selected);
                    tvShopcartAddselect.setCompoundDrawablesWithIntrinsicBounds(left,null,null,null);
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setSelected(true);
                    }
                } else {
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_unselected);
                    tvShopcartAddselect.setCompoundDrawablesWithIntrinsicBounds(left,null,null,null);
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setSelected(false);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}
