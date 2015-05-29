package com.onliquid.personalization;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.onliquid.personalization.support.Item;
import com.onliquid.personalization.support.ListAdapter;
import com.onliquid.personalization.support.TypeComparator;

import io.lqd.sdk.Liquid;

import java.util.ArrayList;

public class SecondActivity extends Activity {

    private ListAdapter customAdapter;
    private Liquid lqd;
    private ListView mProducts;
    private TextView mTextLogin;


    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.second_activity);
        lqd = Liquid.getInstance();
        lqd.loadValues();
        getActionBar().setDisplayShowHomeEnabled(true);

        mTextLogin = (TextView) findViewById(R.id.text_login);
        mProducts = (ListView) findViewById(R.id.listView);
        String user = getIntent().getExtras().getString("user", "no email?");
        mTextLogin.setText("Hello " + user + " !");
        setupList();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem) {
        if (menuitem.getItemId() == R.id.action_logout) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void finish() {
        lqd.track("logout");
        lqd.resetUser();
        super.finish();
    }

    public void setupList() {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Item("Shoes", "clothing", 69.99));
        list.add(new Item("Smartphone", "electronics", 349.99));
        list.add(new Item("T-shirt", "clothing", 9.99));
        list.add(new Item("Keyboard", "electronics", 14.99));
        list.add(new Item("CD", "music", 6.99));
        list.add(new Item("Vinyl", "music", 15.99));
        list.add(new Item("Mouse", "electronics", 12.99));
        list.add(new Item("Sweatshirt", "clothing", 29.99));
        list.add(new Item("Guitar", "music", 349.99));
        list.add(new Item("PC sleeve", "electronics", 10.99));
        list.add(new Item("Shades", "clothing", 149.990));
        customAdapter = new ListAdapter(this, R.layout.itemlistrow, list);
        mProducts.setAdapter(customAdapter);
        String order = lqd.getStringVariable("sort_order", LiquidDefaults.SORT_ORDER);
        customAdapter.sort(new TypeComparator(order));
    }
}
