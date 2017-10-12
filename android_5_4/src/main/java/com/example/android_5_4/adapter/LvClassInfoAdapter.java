package com.example.android_5_4.adapter;
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


import com.example.android_5_4.R;
import com.example.android_5_4.entity.ClassInfo;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

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
        final VileHolder mHolder;
        View view=null;
        if(convertView==null){
            Log.i(TAG,"第一次");
            view=mLayoutInflater.inflate(R.layout.lv_info_item,null);
            mHolder=new VileHolder();
            mHolder.iv_lv_head=(ImageView) view.findViewById(R.id.iv_lv_head);
            mHolder.tv_lv_name=(TextView) view.findViewById(R.id.tv_lv_name);
            mHolder.tv_lv_phone=(TextView) view.findViewById(R.id.tv_lv_phone);
            mHolder.cb_choose= (CheckBox) view.findViewById(R.id.cb_choose);
            view.setTag(mHolder);
        }else{
            Log.i(TAG,"重用");
            view=convertView;
            mHolder= (VileHolder) view.getTag();
        }

        //2.从集合中取出数据
        final ClassInfo classInfo = classInfoList.get(position);
        //3.绑定数据
        mHolder.iv_lv_head.setImageResource(classInfo.getHead());
        mHolder.tv_lv_name.setText(classInfo.getName());
        mHolder.tv_lv_phone.setText(classInfo.getPhone());
//        mHolder.cb_choose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(mHolder.cb_choose.isChecked()){
//                  //  mHolder.cb_choose.setChecked(true);
//                    classInfo.setHasChecked(true);
//                }else{
//                   // mHolder.cb_choose.setChecked(false);
//                    classInfo.setHasChecked(false);
//                }
//            }
//        });
        mHolder.cb_choose.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                classInfo.setHasChecked(isChecked);
            }
        });
        mHolder.cb_choose.setChecked(classInfo.isHasChecked());
        //特色，隔行换色
        if(position%2==0){

            view.setBackgroundColor(context.getResources().getColor(android.R.color.holo_green_light));
        }else{
            view.setBackgroundColor(Color.WHITE);
        }
        //4.切记
        return view;
    }
    private static class VileHolder{
        ImageView iv_lv_head;
        TextView tv_lv_name;
        TextView tv_lv_phone;
        CheckBox cb_choose;
    }
}
