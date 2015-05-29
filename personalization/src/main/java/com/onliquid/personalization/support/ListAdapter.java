package com.onliquid.personalization.support;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.onliquid.personalization.LiquidDefaults;
import com.onliquid.personalization.R;

import io.lqd.sdk.Liquid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private Liquid lqd;
    private Context mContext;

    public ListAdapter(Context context, int i) {
        this(context, i, new ArrayList<Item>());
    }

    public ListAdapter(Context context, int i, List list) {
        super(context, i, list);
        mContext = context;
        lqd = Liquid.getInstance();
    }

    public View getView(int i, View view, final ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.itemlistrow, null);
        }
        if (view != null) {
            TextView textview = (TextView) view.findViewById(R.id.text_name);
            TextView textview1 = (TextView) view.findViewById(R.id.text_price);
            Button button = (Button) view.findViewById(R.id.btn_buy);
            ImageView imageview = (ImageView) view.findViewById(R.id.item_type);
            final Item p = ((Item) getItem(i));

            button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view1) {
                    HashMap<String, Object> attr = new HashMap<String, Object>();
                    attr.put("name", p.getName());
                    attr.put("type", p.getType());
                    attr.put("price", Double.valueOf(p.getPrice()));
                    attr.put("currency", p.getCurrency());
                    lqd.track("buy_product", attr);
                    Toast.makeText(mContext, p.getName() + " Bought!", Toast.LENGTH_SHORT).show();
                }

            });
            if (lqd.getBooleanVariable("price_btn_merge", LiquidDefaults.PRICE_BTN_MERGE)) {
                textview1.setVisibility(View.GONE);
                button.setText(p.getPriceCurrency() + " Buy!");
            }

            if (imageview != null) {
                if (p.getType().equals("clothing")) {
                    imageview.setImageResource(R.mipmap.clothing);
                } else if (p.getType().equals("electronics")) {
                    imageview.setImageResource(R.mipmap.electronics);
                } else {
                    imageview.setImageResource(R.mipmap.music);
                }
            }
            if (textview != null) {
                textview.setText(p.getName());
            }
            if (textview1 != null) {
                textview1.setText(p.getPriceCurrency());
            }
        }
        return view;
    }


}
