package com.example.android_5_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ListView lv_record;
    private SimpleAdapter recordAdapter;
    private List<Map<String,Object>> recoredList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //准备控件
        initView();
        //准备数据
        initData();
        //准备适配器
        initAdapter();
        //绑定
        initBinder();
        //事件监听
        initListener();
    }

    private void initListener() {

    }

    private void initBinder() {
        lv_record.setAdapter(recordAdapter);
    }

    private void initAdapter() {
        recordAdapter=new SimpleAdapter(this,recoredList,R.layout.lv_recored_item,new String[]{"head","name"},new int[]{R.id.iv_pirctrue,R.id.tv_name});
    }

    private void initData() {
        getInfoData();
    }

    private void getInfoData() {
        recoredList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String,Object> map=new HashMap<>();
            map.put("head",R.mipmap.ic_launcher);
            map.put("name","麓谷小镇总群"+i);
            recoredList.add(map);
        }
    }

    private void initView() {
        lv_record= (ListView) findViewById(R.id.lv_record);
    }


}
