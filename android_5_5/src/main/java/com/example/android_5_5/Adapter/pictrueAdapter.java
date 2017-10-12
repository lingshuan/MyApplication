package com.example.android_5_5.Adapter;

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

import com.example.android_5_5.R;
import com.example.android_5_5.entity.ClassInfo;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2017/10/10.
 */

public class pictrueAdapter extends BaseAdapter{
    //1.List集合Bean
    private List<ClassInfo> classInfoList = new ArrayList<>();
    //2.布局加载器
    LayoutInflater mLayoutInflater;
    Context context;//为67行使用
    public pictrueAdapter(List<ClassInfo> classInfoList, Context context){
        this.classInfoList = classInfoList;//待处理的数
        mLayoutInflater = LayoutInflater.from(context);//加载布局文件用的
        this.context = context;
    }
    @Override
    public int getCount() {
        return classInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return classInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final VileHolder mHolder;
        View view=null;
        if(convertView==null){
            Log.i(TAG,"第一次");
            view=mLayoutInflater.inflate(R.layout.lv_pictrue,null);
            mHolder=new VileHolder();
            mHolder.iv_pictrue=(ImageView) view.findViewById(R.id.iv_pictrue);
            mHolder.tv_name=(TextView) view.findViewById(R.id.tv_name);
            mHolder.cb_select= (CheckBox) view.findViewById(R.id.cb_select);
            view.setTag(mHolder);
        }else{
            Log.i(TAG,"重用");
            view=convertView;
            mHolder= (VileHolder) view.getTag();
        }

        //2.从集合中取出数据
        final ClassInfo classInfo = classInfoList.get(position);
        //3.绑定数据
        mHolder.iv_pictrue.setImageResource(classInfo.getPictrue());
        mHolder.tv_name.setText(classInfo.getName());
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
        mHolder.cb_select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                classInfo.setHasChecked(isChecked);
            }
        });
        mHolder.cb_select.setChecked(classInfo.isHasChecked());
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
        ImageView iv_pictrue;
        TextView tv_name;
        CheckBox cb_select;
    }
}
