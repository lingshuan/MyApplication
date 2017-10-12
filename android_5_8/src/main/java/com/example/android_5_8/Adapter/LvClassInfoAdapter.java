package com.example.android_5_8.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.android_5_8.R;
import com.example.android_5_8.entity.ClassInfo;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Emily on 17/10/10.
 */

public class LvClassInfoAdapter extends BaseAdapter {

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
        View view = null;
        final ViewHolder mHolder;
        //第一次加载
        if(convertView ==null){
            Log.i(TAG,"第一次");
            view = mLayoutInflater.inflate(R.layout.lv_info_item,null);
            mHolder = new ViewHolder();
            mHolder.iv_lv_head =(ImageView) view.findViewById(R.id.iv_lv_head);
            mHolder.tv_lv_name = (TextView) view.findViewById(R.id.tv_lv_name);
            mHolder.tv_lv_phone =  (TextView) view.findViewById(R.id.tv_lv_phone);
            mHolder.cb_select = (CheckBox) view.findViewById(R.id.cb_select);
            //建立view和mHolder的关联
            view.setTag(mHolder);
        }else{
            Log.i(TAG,"重用");
            view = convertView;
            mHolder = (ViewHolder) view.getTag();
        }



        //2.从集合中取出数据
        final ClassInfo classInfo = classInfoList.get(position);
        //3.绑定数据
        mHolder.iv_lv_head.setImageResource(classInfo.getHead());
        mHolder.tv_lv_name.setText(classInfo.getName());
        mHolder.tv_lv_phone.setText(classInfo.getPhone());
        //添加事件监听
//        mHolder.cb_select.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(mHolder.cb_select.isChecked()){
//                    //如果是被选中的话
//                    //mHolder.cb_select.setChecked(true);
//                    //存起来
//                    classInfo.setHasChecked(true);
//                }else{
//                    //mHolder.cb_select.setChecked(false);
//                    classInfo.setHasChecked(false);
//                }
//            }
//        });
        mHolder.cb_select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                classInfo.setHasChecked(isChecked);
            }
        });
        //真正处理
        mHolder.cb_select.setChecked(classInfo.isHasChecked());



        //特色，隔行换色
        if(position%2==0){

            view.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
        }else{
            view.setBackgroundColor(Color.WHITE);
        }
        //4.切记
        return view;
    }
    private static class ViewHolder{
        CheckBox cb_select;
        ImageView iv_lv_head;
        TextView tv_lv_name;
        TextView tv_lv_phone;


    }
}
