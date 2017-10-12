package com.example.wechat.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wechat.MainActivity;
import com.example.wechat.R;
import com.example.wechat.entity.ClassInfo;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by O on 2017-10-10.
 */

public class LvClassInfoAdapter extends BaseAdapter {
    //List集合Bean
    private List<ClassInfo> classInfoList = new ArrayList<>();

    //布局加载器
    LayoutInflater mLayoutInflater;

    public LvClassInfoAdapter(List<ClassInfo> classInfoList, Context context) {
        this.classInfoList = classInfoList;
        mLayoutInflater = LayoutInflater.from(context);

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
        View view = null;
        ViewHolder mHolder;
        if (convertView == null) {
            Log.i(TAG,"第一次加载666666");
            view = mLayoutInflater.inflate(R.layout.lv_info_item, null);
            mHolder = new ViewHolder();
            mHolder.iv_lv_head = (ImageView) view.findViewById(R.id.iv_head);
            mHolder.tv_lv_name = (TextView) view.findViewById(R.id.tv_lv_name);
            mHolder.tv_lv_phone = (TextView) view.findViewById(R.id.lv_phone);
            mHolder.tv_lv_time = (TextView) view.findViewById(R.id.lv_time);
            view.setTag(mHolder);

        } else {
            Log.i(TAG,"重复加载666666");
            view = convertView;
            mHolder = (ViewHolder) view.getTag();
        }

        //1.加载布局文件
        //2.从集合中取出数据
        ClassInfo classInfo = classInfoList.get(position);
        //3.绑定数据
        mHolder.iv_lv_head.setImageResource(classInfo.getHead());
        mHolder.tv_lv_name.setText(classInfo.getName());
        mHolder.tv_lv_phone.setText(classInfo.getPhone());
        mHolder.tv_lv_time.setText(classInfo.getTime());
        return view;
    }

    private static class ViewHolder {
        ImageView iv_lv_head;
        TextView tv_lv_name;
        TextView tv_lv_phone;
        TextView tv_lv_time;
    }
}
