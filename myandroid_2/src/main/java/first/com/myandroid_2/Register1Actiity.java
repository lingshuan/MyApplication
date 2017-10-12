package first.com.myandroid_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lingwang on 2017/9/29.
 */

public class Register1Actiity extends AppCompatActivity {
    private CheckBox cb_agree;
    private Button bt_register;
    private EditText et_username;
    private EditText et_password;
    private EditText et_repassword;
    private EditText et_email;
    private RadioGroup rg_sex;
    private CheckBox checkbox1,checkbox2,checkbox3,checkbox4;
    private List<CheckBox> checkBoxList = new ArrayList<CheckBox>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        initView();
        listener();
    }
    public void initView(){
        cb_agree=(CheckBox) findViewById(R.id.cb_agree);
        bt_register=(Button) findViewById(R.id.bt_register);
        et_username=(EditText) findViewById(R.id.et_username);
        et_password=(EditText) findViewById(R.id.et_password);
        et_repassword=(EditText) findViewById(R.id.et_repassword);
        bt_register.setEnabled(false);
        et_email=(EditText) findViewById(R.id.et_email);
        rg_sex=(RadioGroup) findViewById(R.id.rg_sex);
        checkbox1=(CheckBox)findViewById(R.id.checkbox1);
        checkbox2=(CheckBox)findViewById(R.id.checkbox2);
        checkbox3=(CheckBox)findViewById(R.id.checkbox3);
        checkbox4=(CheckBox)findViewById(R.id.checkbox4);
        checkBoxList.add(checkbox1);
        checkBoxList.add(checkbox2);
        checkBoxList.add(checkbox3);
        checkBoxList.add(checkbox4);
    }
    public void listener(){
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Editable username=(Editable) et_username.getText();
                if(TextUtils.isEmpty(username)){
                    Toast.makeText(getApplicationContext(), "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Editable password=(Editable) et_password.getText();
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Editable repassword=(Editable) et_repassword.getText();
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
                String sex=null;
                int id=rg_sex.getCheckedRadioButtonId();
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
        cb_agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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

}
