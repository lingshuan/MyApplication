package com.example.android_5_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private GridView gv_constellation;
    private SimpleAdapter constellationAdapter;
    private List<Map<String,Object>> constellationList;
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
        gv_constellation.setAdapter(constellationAdapter);
    }

    private void initAdapter() {
        constellationAdapter=new SimpleAdapter(this,constellationList,R.layout.gv_constellation,new String[]{"pictrue","name","time"},new int[]{R.id.iv_xingzuo,R.id.tv_name,R.id.tv_time});
    }

    private void initData() {
        constellationList=new ArrayList<>();
        int i[]={R.drawable.aries,R.drawable.taurus,R.drawable.gemini,R.drawable.cancer,R.drawable.leo,R.drawable.virgo,R.drawable.libra,R.drawable.scorpio,R.drawable.sagittarius,R.drawable.capricorn,R.drawable.aquarius,R.drawable.pisces};
        String name[]={"白羊座","金牛座","双子座","巨蟹座","狮子座","处女座","天秤座","天蝎座","射手座","摩羯座","水瓶座","双鱼座"};
        String time[]={"03/21-04/20","04/21-05/20","05/21-06/20","06/21-07/20","07/21-08/20","08/21-09/20","09/21-10/20","10/21-11/20","11/21-12/20","12/21-01/20","01/21-02/20","02/21-03/20"};
        for (int j = 0; j < i.length; j++) {
            Map<String,Object> map=new HashMap<>();
            map.put("pictrue",i[j]);
            map.put("name",name[j]);
            map.put("time",time[j]);
            constellationList.add(map);
        }
    }

    private void initView() {
        gv_constellation= (GridView) findViewById(R.id.gv_constellation);
    }
}
