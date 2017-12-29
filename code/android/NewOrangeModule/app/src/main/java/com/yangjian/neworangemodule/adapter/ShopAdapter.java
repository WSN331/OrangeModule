package com.yangjian.neworangemodule.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yangjian.neworangemodule.R;
import com.yangjian.neworangemodule.activity.GoodsActivity;
import com.yangjian.neworangemodule.bean.Product;

import java.security.acl.LastOwnerException;
import java.util.List;

/**
 * Created by Yang on 2017/10/31.
 * Function：商品适配器
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private Context context;
    private List<Product> products;

    public ShopAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Product product = products.get(position);
        if (product != null) {
            holder.image.setImageResource(product.getImage());
            holder.title.setText(product.getTitle());
            holder.price.setText(product.getPrice());

            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, GoodsActivity.class);
                    intent.putExtra("title", product.getTitle());
                    intent.putExtra("price", product.getPrice());
                    intent.putExtra("image", product.getImage());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title, price;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.product_image);
            title = (TextView) itemView.findViewById(R.id.product_title);
            price = (TextView) itemView.findViewById(R.id.product_price);
        }
    }
}
