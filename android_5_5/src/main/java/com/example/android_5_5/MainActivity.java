package com.example.android_5_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.android_5_5.Adapter.pictrueAdapter;
import com.example.android_5_5.entity.ClassInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView lv_pictrue;
    private SimpleAdapter pictrueAdapter;
    private List<Map<String,Object>> pirctrueList;
    private pictrueAdapter infoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_pictrue= (ListView) findViewById(R.id.lv_pictrue);
        infoAdapter = new pictrueAdapter(getAllClassInfo(),MainActivity.this);
        lv_pictrue.setAdapter(infoAdapter);

    }

    private List<ClassInfo> getAllClassInfo(){
        List<ClassInfo> lists = new ArrayList<>();
        int src[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
                R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,
                R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.v,R.drawable.w,
                R.drawable.x,R.drawable.y};
        for (int i = 0; i < src.length; i++) {
            ClassInfo info = new ClassInfo();
            info.setPictrue(src[i]);
            info.setName("图片"+i);
            lists.add(info);
        }

        return lists;
    }
}
