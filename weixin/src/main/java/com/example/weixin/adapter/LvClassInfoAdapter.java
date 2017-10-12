package com.example.weixin.adapter;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weixin.R;
import com.example.weixin.entity.ClassInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emily on 17/10/9.
 */

public class LvClassInfoAdapter extends BaseAdapter{
    //1.List集合Bean
    private List<ClassInfo> classInfoList = new ArrayList<>();
    //2.布局加载器
    LayoutInflater mLayoutInflater;
    Context context;//为67行使用
    public LvClassInfoAdapter(List<ClassInfo> classInfoList, Context context){
        this.classInfoList = classInfoList;//待处理的数
        mLayoutInflater = LayoutInflater.from(context);//加载布局文件用的
        this.context = context;
    }
    //集合的大小
    @Override
    public int getCount() {
        return classInfoList.size();
    }
    //集合每一行数据
    @Override
    public Object getItem(int position) {
        return classInfoList.get(position);
    }
    //集合下标
    @Override
    public long getItemId(int position) {
        return position;
    }

    //重点！！！
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1.加载布局文件以便找到控件
        View view = mLayoutInflater.inflate(R.layout.lv_info_item,null);
        ImageView iv_lv_head= (ImageView) view.findViewById(R.id.iv_lv_head);
        TextView tv_lv_name = (TextView) view.findViewById(R.id.tv_lv_name);
        TextView tv_lv_phone = (TextView) view.findViewById(R.id.tv_lv_phone);

        //2.从集合中取出数据
        ClassInfo classInfo = classInfoList.get(position);
        //3.绑定数据
        iv_lv_head.setImageResource(classInfo.getHead());
        tv_lv_name.setText(classInfo.getName());
        tv_lv_phone.setText(classInfo.getPhone());
        //特色，隔行换色
        if(position%2==0){

            view.setBackgroundColor(context.getResources().getColor(android.R.color.holo_green_light));
        }else{
            view.setBackgroundColor(Color.WHITE);
        }
        //4.切记
        return view;
    }
}
