package com.example.myadroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/30.
 */

public class LoginActivity extends Activity implements View.OnClickListener{
    private EditText et_username;
    private EditText et_password;
    private Button bt_login;
    private Button bt_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        //2.找到控件
        initView();
        //3.注册监听
        listener();
    }
    public void initView(){
        et_username=(EditText)findViewById(R.id.et_username);
        et_password=(EditText)findViewById(R.id.et_password);
        bt_login=(Button)findViewById(R.id.bt_login);
        bt_register=(Button)findViewById(R.id.bt_register);
    }
    public void listener(){
        bt_login.setOnClickListener(this);
        bt_register.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id ){
            case R.id.bt_login:
                Editable username=et_username.getText();
                Editable password=et_password.getText();
                if(TextUtils.isEmpty(username)){
                    Toast.makeText(this, "用户名不能为空〜", Toast.LENGTH_SHORT).show();
                    return;}
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(this, "密码不能为空〜", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("root".equals(username.toString())&&"52java".equals(password.toString())){
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this,SuccessActivity.class);
                    startActivity(intent);

                } else{
                    Toast.makeText(this, "账号密码错误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_register:
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
