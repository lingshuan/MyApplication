package com.example.android_5_8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.android_5_8.Adapter.LvClassInfoAdapter;
import com.example.android_5_8.entity.ClassInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv_info;
    private LvClassInfoAdapter infoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_info = (ListView) findViewById(R.id.lv_info);
        infoAdapter = new LvClassInfoAdapter(getAllClassInfo(),MainActivity.this);
        lv_info.setAdapter(infoAdapter);
        lv_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //如何获取选中条目的值
                //所有的数所在Adapter中，就从这里面拿
                ClassInfo info = (ClassInfo) infoAdapter.getItem(position);
                Toast.makeText(MainActivity.this, info.getName()+":"+info.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private List<ClassInfo> getAllClassInfo(){
        List<ClassInfo> lists = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            ClassInfo info = new ClassInfo();
            info.setHead(R.drawable.face1);
            info.setName("李四"+i);
            info.setPhone("130000000"+i);
            lists.add(info);
        }

        return lists;
    }
}
