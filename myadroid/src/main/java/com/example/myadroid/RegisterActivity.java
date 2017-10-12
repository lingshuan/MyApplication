package com.example.myadroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/9/30.
 */

public class RegisterActivity extends Activity{
    private EditText et_username;
    private EditText et_password1;
    private EditText et_password2;
    private EditText et_email;
    private EditText et_phone;
    private EditText et_firstname;
    private EditText et_lastname;
    private RadioGroup rg_group;
    private RadioButton rb_boy;
    private RadioButton rb_girl;
    private Spinner sp_spinner;
    private EditText et_province;
    private EditText et_city;
    private CheckBox cb_sport;
    private CheckBox cb_music;
    private CheckBox cb_read;
    private EditText et_yanzheng;
    private Button bt_huoqu;
    private CheckBox cb_deal;
    private Button bt_register;
    private List<CheckBox> checkBoxList = new ArrayList<CheckBox>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        initView();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countrt,R.layout.support_simple_spinner_dropdown_item);
        sp_spinner.setAdapter(adapter);
        listener();
    }

    private void listener() {
        bt_huoqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                StringBuffer sb=new StringBuffer();
                for (int i=0;i<4;i++){
                    int l = random.nextInt(10);
                    sb.append(l);
                }
                et_yanzheng.setText(sb);
            }
        });
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable username=(Editable) et_username.getText();
                if(TextUtils.isEmpty(username)){
                    Toast.makeText(getApplicationContext(), "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Editable password=(Editable) et_password1.getText();
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Editable repassword=(Editable) et_password2.getText();
                if(!repassword.toString().equals(password.toString())){
                    Toast.makeText(getApplicationContext(), "两次密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }
                Editable email=(Editable) et_email.getText();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "邮箱不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!isEmail(email.toString())){
                    Toast.makeText(getApplicationContext(), "邮箱格式错误", Toast.LENGTH_SHORT).show();
                    return;
                }
                Editable phone = et_phone.getText();
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(getApplicationContext(), "手机不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!(phone.toString().length()==11)){
                    Toast.makeText(getApplicationContext(), "手机号码为11位", Toast.LENGTH_SHORT).show();
                    return;
                }
                Editable firstname = et_firstname.getText();
                Editable lastname = et_lastname.getText();
                if(TextUtils.isEmpty(firstname)||TextUtils.isEmpty(lastname)){
                    Toast.makeText(getApplicationContext(), "姓名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Editable yanzheng = et_yanzheng.getText();
                if(TextUtils.isEmpty(yanzheng)){
                    Toast.makeText(getApplicationContext(), "验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String sex=null;
                int id=rg_group.getCheckedRadioButtonId();
                RadioButton rb=(RadioButton) findViewById(id);
                sex=(String)rb.getText();
                StringBuffer sb = new StringBuffer();
                for (CheckBox checkbox : checkBoxList) {
                    if (checkbox.isChecked()){
                        sb.append(checkbox.getText()+ " ");
                    }
                }
                if (sb!=null && "".equals(sb.toString())){
                    Toast.makeText(getApplicationContext(), "请至少选择一个兴趣", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();}
            }
        });
        cb_deal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Toast.makeText(Register1.this,isChecked+"",To)
                bt_register.setEnabled(isChecked);
            }
        });
    }
    public boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }


    private void initView() {
        et_username= (EditText) findViewById(R.id.et_username);
        et_password1= (EditText) findViewById(R.id.et_password1);
        et_password2= (EditText) findViewById(R.id.et_password2);
        et_email= (EditText) findViewById(R.id.et_email);
        et_phone= (EditText) findViewById(R.id.et_phone);
        et_firstname= (EditText) findViewById(R.id.et_firstname);
        et_lastname= (EditText) findViewById(R.id.et_lastname);
        rg_group= (RadioGroup) findViewById(R.id.rg_group);
        rb_boy= (RadioButton) findViewById(R.id.rb_boy);
        rb_girl= (RadioButton) findViewById(R.id.rb_girl);
        sp_spinner= (Spinner) findViewById(R.id.sp_spinner);
        et_province= (EditText) findViewById(R.id.et_province);
        et_city= (EditText) findViewById(R.id.et_city);
        cb_sport= (CheckBox) findViewById(R.id.cb_sport);
        cb_music= (CheckBox) findViewById(R.id.cb_music);
        cb_read= (CheckBox) findViewById(R.id.cb_read);
        et_yanzheng= (EditText) findViewById(R.id.et_yanzheng);
        bt_huoqu= (Button) findViewById(R.id.bt_huoqu);
        cb_deal= (CheckBox) findViewById(R.id.cb_deal);
        bt_register= (Button) findViewById(R.id.bt_register);
        checkBoxList.add(cb_music);
        checkBoxList.add(cb_sport);
        checkBoxList.add(cb_read);
    }



}
