package com.example.android_6;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity {
    Calendar calendar=Calendar.getInstance();
    String likes="";
    private ListView lv_dialog;
    private ArrayAdapter adapter;
    String name[]={
            "1.普通对话框",
            "2. 列表对话框",
            " 3. 单选对话框",
            " 4. 多选对话框",
             " 5. 时间对话框",
            "6. 日期对话框",
            "7. 进度条对话框",
            " 8. 自定义对话框"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_dialog= (ListView) findViewById(R.id.lv_dialog);
        adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,name);
        lv_dialog.setAdapter(adapter);
        lv_dialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("提示");
                        builder.setMessage("确定要下载吗");
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "下载中。。。", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();
                        break;
                    case 1:
                        final String s[]={"java",".net","android","php"};
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("请选择语言")
                                .setItems(s, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(MainActivity.this, s[which], Toast.LENGTH_SHORT).show();
                                    }
                                }).show();
                        break;

                    case 2:
                        final String like[]={"骑行","看书","音乐"};
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("你的爱好")
                                .setSingleChoiceItems(like, 0, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        likes=like[which];
                                    }
                                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, likes, Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                        break;
                    case 3:
                        final String activity[]={"骑行","看书","音乐"};
                        final boolean item[]={false,false,false};
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("兴趣爱好")
                                .setMultiChoiceItems(activity, item, new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        item[which]=isChecked;
                                    }
                                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StringBuffer sb=new StringBuffer();
                                for (int i = 0; i <activity.length ; i++) {
                                    if(item[i]){
                                        sb.append(activity[i]).append(",");
                                    }
                                }
                                sb.deleteCharAt(sb.length()-1);
                                Toast.makeText(MainActivity.this, sb, Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                        break;
                    case 4:
                        int h = calendar.get(Calendar.HOUR_OF_DAY);
                        int m = calendar.get(Calendar.MINUTE);
                        new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Toast.makeText(MainActivity.this, hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();
                            }
                        },h,m,false).show();
                        break;
                    case 5:
                        int y=calendar.get(Calendar.YEAR);
                        int M=calendar.get(Calendar.MONTH);
                        int D=calendar.get(Calendar.DAY_OF_MONTH);
                        new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            }
                        },y,M,D).show();
                        break;
                    case 6:
                        ProgressDialog download =new ProgressDialog(MainActivity.this);
                        download.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        download.setMax(100);
                        download.show();
                        download.setProgress(11);
                        break;
                    case 7:
                        final View mview = View.inflate(MainActivity.this,R.layout.define_layout,null);
                        final AlertDialog.Builder defineDialog=new AlertDialog.Builder(MainActivity.this);
                        defineDialog.setTitle("登录");
                        defineDialog.setView(mview);
                        defineDialog.setPositiveButton("登录", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String name=((EditText)mview.findViewById(R.id.et_name)).getText()+"";
                                String password=((EditText)mview.findViewById(R.id.et_password)).getText()+"";
                                Toast.makeText(MainActivity.this, name+","+password, Toast.LENGTH_SHORT).show();
                            }
                        });
                        defineDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        defineDialog.show();
                        break;
                }
            }
        });
    }
}
