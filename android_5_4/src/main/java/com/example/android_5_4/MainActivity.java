package com.example.android_5_4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.android_5_4.adapter.LvClassInfoAdapter;
import com.example.android_5_4.entity.ClassInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView actv_name;
    private Spinner sp_class;
    private ListView lv_info;
    private GridView gv_seat_info;

    private ArrayAdapter<String>  nameAdapter;
    private ArrayAdapter<String>  classAdapter;
    private LvClassInfoAdapter infoAdapter;
    private SimpleAdapter seatInfoAdapter;

    private String names[];
    private String classes[];
    private List<Map<String,Object>> infoLists;
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
        lv_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //如何获取选中条目的值
                //所有的数所在Adapter中，就从这里面拿
                ClassInfo info= (ClassInfo) infoAdapter.getItem(position);
                Toast.makeText(MainActivity.this, info.getName()+":"+info.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });
        gv_seat_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> map= (Map<String, Object>) seatInfoAdapter.getItem(position);
                String name = (String) map.get("name");
                String phone = (String) map.get("phone");
                Toast.makeText(MainActivity.this, name+":"+phone, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initBinder() {
        actv_name.setAdapter(nameAdapter);
        sp_class.setAdapter(classAdapter);
        //lv_info.setAdapter(infoAdapter);
        infoAdapter=new LvClassInfoAdapter(getAllClassInfo(),MainActivity.this);
        lv_info.setAdapter(infoAdapter);
        gv_seat_info.setAdapter(seatInfoAdapter);
    }

    private void initAdapter() {
        nameAdapter = new ArrayAdapter<String>(this,R.layout.actv_name,R.id.tv_name,names);
        classAdapter = new ArrayAdapter<String>(this,R.layout.actv_name,R.id.tv_name,names);

        seatInfoAdapter = new SimpleAdapter(
                this,
                infoLists,
                R.layout.gv_seat_info_item,
                new String[]{"head","name"},
                new int[]{R.id.iv_gv_head,R.id.tv_gv_name}
        );
    }

    private void initData() {
        names = new String[]{"Java","Apple","Jack","any","appliction","cat"};
        classes = new String[]{"Java78","Java79","Java80",};
        getInfoData();

    }

    private void getInfoData() {
        int src[]={R.drawable.face1,R.drawable.face2,R.drawable.face3,R.drawable.face4,R.drawable.face5,R.drawable.face6,R.drawable.face7,R.drawable.face8};
        infoLists = new ArrayList<>();
        for (int i=0;i<src.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("head",src[i]);
            map.put("name","张三"+i);
            map.put("phone","1378701004"+i);
            infoLists.add(map);
        }
    }

    private void initView() {
        actv_name = (AutoCompleteTextView) findViewById(R.id.actv_name);
        sp_class = (Spinner) findViewById(R.id.sp_class);
        lv_info = (ListView) findViewById(R.id.lv_info);
        gv_seat_info = (GridView) findViewById(R.id.gv_seat_info);
    }

    private List<ClassInfo> getAllClassInfo(){
        int src[]={R.drawable.face1,R.drawable.face2,R.drawable.face3,R.drawable.face4,R.drawable.face5,R.drawable.face6,R.drawable.face7,R.drawable.face8};
        List<ClassInfo> lists = new ArrayList<>();
        for (int i = 0; i < src.length; i++) {
            ClassInfo info = new ClassInfo();
            info.setHead(src[i]);
            info.setName("张三"+i);
            info.setPhone("1300000000"+i);
            lists.add(info);
        }

        return lists;
    }

}
