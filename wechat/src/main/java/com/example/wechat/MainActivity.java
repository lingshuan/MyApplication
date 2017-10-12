package com.example.wechat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


import com.example.wechat.adapter.LvClassInfoAdapter;
import com.example.wechat.entity.ClassInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

        //准备适配器
        initAdapter();

        initBinder();
    }

    private void initAdapter() {
    }

    private void initData() {
    }

    private void initBinder() {
        lv_info.setAdapter(new LvClassInfoAdapter(getAllClassInfo(),MainActivity.this) {
        });
    }

    private void initView() {
        lv_info = (ListView) findViewById(R.id.lv_info);
    }

    public List<ClassInfo>  getAllClassInfo(){
        List<ClassInfo> list = new ArrayList<>();
        int src[] ={R.mipmap.m0,R.mipmap.m1,R.mipmap.m2,R.mipmap.m3,R.mipmap.m4
                ,R.mipmap.m5,R.mipmap.m6,R.mipmap.m7,R.mipmap.m8,R.mipmap.m9,R.mipmap.m10
                ,R.mipmap.m11,R.mipmap.m12,R.mipmap.m13,R.mipmap.m14,R.mipmap.m15};
        for (int i = 0; i < 15; i++) {
            ClassInfo info = new ClassInfo();
            info.setHead(src[i]);
            info.setName("麓谷小镇总群"+i+1);
            info.setPhone("1154848484"+i);
            if (i>=10) {
            info.setTime("14:"+i);
            }else{
                info.setTime("14:0"+i);
            }
            list.add(info);
        }

        return list;
    }
}
