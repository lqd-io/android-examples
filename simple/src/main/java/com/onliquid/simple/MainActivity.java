package com.onliquid.simple;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

import io.lqd.sdk.Liquid;

public class MainActivity extends Activity {

    private Liquid lqd;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        lqd = Liquid.getInstance();
    }

    public void enterSecondActivity(String name) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("user", name);
        startActivity(intent);
    }

    public void login(View view) {
        String name = "";
        HashMap attrs = new HashMap();

        switch (view.getId()) {
            case R.id.jack:
                attrs.put("age", 23);
                attrs.put("gender", "male");
                name = "Jack";
                break;
            case R.id.jill:
                attrs.put("age", 32);
                attrs.put("gender", "female");
                name = "Jill";
                break;
            case R.id.jonas:
                attrs.put("age", 35);
                attrs.put("gender", "male");
                name = "Jonas";
        }
        lqd.identifyUser(name, attrs);
        enterSecondActivity(name);
    }
}
