package com.example.choujiang1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Administrator on 2017/9/28.
 */

public class MyActivity extends Activity implements View.OnClickListener{
    private TextView tv_tishi;
    private ImageView tv_tupian;
    private Button bt_choujian;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        initView();
        bt_choujian.setOnClickListener(this);
    }

    private void initView() {
        tv_tishi= (TextView) findViewById(R.id.tv_tishi);
        tv_tupian= (ImageView) findViewById(R.id.tv_tupian);
        bt_choujian= (Button) findViewById(R.id.bt_choujian);
    }

    @Override
    public void onClick(View v) {
        Random rand = new Random();
        int i = rand.nextInt(10);
        switch (i){
            case 0:
                tv_tupian.setImageResource(R.drawable.b);
                break;
            case 1:
                tv_tupian.setImageResource(R.drawable.c);
                break;
            case 2:
                tv_tupian.setImageResource(R.drawable.d);
                break;
            case 3:
                tv_tupian.setImageResource(R.drawable.e);
                break;
            case 4:
                tv_tupian.setImageResource(R.drawable.f);
                break;
            case 5:
                tv_tupian.setImageResource(R.drawable.g);
                break;
            case 6:
                tv_tupian.setImageResource(R.drawable.h);
                tv_tishi.setText("6666666");
                break;
            case 7:
                tv_tupian.setImageResource(R.drawable.i);
                break;
            case 8:
                tv_tupian.setImageResource(R.drawable.j);
                break;
            case 9:
                tv_tupian.setImageResource(R.drawable.k);
                break;
        }
    }
}
