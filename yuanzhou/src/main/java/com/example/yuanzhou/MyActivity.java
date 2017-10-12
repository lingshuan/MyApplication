package com.example.yuanzhou;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity implements View.OnClickListener{
    private EditText et_banjing;
    private Button bt_jisuan;
    private TextView et_zhouchang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        initView();
        bt_jisuan.setOnClickListener(this);
    }

    private void initView() {
        et_banjing= (EditText) findViewById(R.id.et_banjing);
        bt_jisuan= (Button) findViewById(R.id.bt_jisuan);
        et_zhouchang= (TextView) findViewById(R.id.et_zhouchang);
    }

    @Override
    public void onClick(View v) {
        String banjing = et_banjing.getText().toString();
        double zhouchang = Double.parseDouble(banjing) * 3.14;
        et_zhouchang.setText(zhouchang+"");
    }
}
