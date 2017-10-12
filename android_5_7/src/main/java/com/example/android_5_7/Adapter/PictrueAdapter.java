package com.example.android_5_7.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.android_5_7.entity.ClassInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */

public class PictrueAdapter extends BaseAdapter{
    private List<ClassInfo> classInfoList=new ArrayList<>();
    LayoutInflater mLayoutInflater;
    public PictrueAdapter(List<ClassInfo> classInfoList, Context context){
        this.classInfoList=classInfoList;
        mLayoutInflater=LayoutInflater.from(context);
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

        View view=mLayoutInflater.inflate(android.R.layout.)
        return null;
    }
}
