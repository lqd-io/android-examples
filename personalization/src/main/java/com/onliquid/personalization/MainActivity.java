package com.onliquid.personalization;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import io.lqd.sdk.Liquid;

import java.util.HashMap;

public class MainActivity extends Activity {

    private Liquid lqd;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        lqd = Liquid.getInstance();
    }

    public void enterSecondActivity(String username) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("user", username);
        startActivity(intent);
    }

    public void login(View view) {
        String username = "";
        HashMap attrs = new HashMap();

        switch (view.getId()) {
            case R.id.jack:
                attrs.put("age", 23);
                attrs.put("gender", "male");
                username = "Jack";
                break;
            case R.id.jill:
                attrs.put("age", 32);
                attrs.put("gender", "female");
                username = "Jill";
                break;
            case R.id.jonas:
                attrs.put("age", 35);
                attrs.put("gender", "male");
                username = "Jonas";
        }
        lqd.identifyUser(username, attrs);
        enterSecondActivity(username);
    }
}
