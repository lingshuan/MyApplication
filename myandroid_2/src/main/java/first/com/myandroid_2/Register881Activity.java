package first.com.myandroid_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lingwang on 2017/9/29.
 */

public class Register881Activity extends Activity {
    private Spinner spinner;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;
    private EditText et_province;
    private EditText et_city;
    private EditText et_firstname;
    private EditText et_lastname;
    private EditText et_email;
    private EditText et_remail;
    private EditText et_phone;
    private EditText et_password;
    private EditText et_repassword;
    private CheckBox cb_agree;
private Button bt_register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register881);
        country();
        initView();
        listener();



    }
public void initView(){
et_province=(EditText) findViewById(R.id.et_province);
et_city=(EditText) findViewById(R.id.et_city);
et_firstname=(EditText) findViewById(R.id.et_firstname);
et_lastname=(EditText) findViewById(R.id.et_lastname);
et_email=(EditText) findViewById(R.id.et_email);
et_remail=(EditText) findViewById(R.id.et_remail);
et_phone=(EditText) findViewById(R.id.et_phone);
et_password=(EditText) findViewById(R.id.et_password);
et_repassword=(EditText) findViewById(R.id.et_repassword);
    cb_agree=(CheckBox) findViewById(R.id.cb_agree);
    bt_register=(Button) findViewById(R.id.bt_register);

}
    public void country(){
        spinner = (Spinner) findViewById(R.id.spinner);
        //数据
        data_list = new ArrayList<String>();
        data_list.add("中国");
        data_list.add("美国");
        data_list.add("俄罗斯");
        data_list.add("德国");
        data_list.add("印度");
        data_list.add("英国");
        data_list.add("法国");
        data_list.add("加拿大");

        //适配器
        arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        //加载适配器
        spinner.setAdapter(arr_adapter);
    }
    public void listener(){
        cb_agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Toast.makeText(Register1.this,isChecked+"",To)
                bt_register.setEnabled(isChecked);
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapter = (ArrayAdapter<String>) parent.getAdapter();
                String country=adapter.getItem(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String province=et_province.getText().toString();
                if(TextUtils.isEmpty(province)){
                    Toast.makeText(getApplicationContext(), "请输入地区", Toast.LENGTH_SHORT).show();
                    return;
                }
                String city=et_city.getText().toString();
                if(TextUtils.isEmpty(city)){
                    Toast.makeText(getApplicationContext(), "请输入城市", Toast.LENGTH_SHORT).show();
                    return;
                }
                String firstname=et_firstname.getText().toString();
                if(TextUtils.isEmpty(firstname)){
                    Toast.makeText(getApplicationContext(), "请输入您的姓", Toast.LENGTH_SHORT).show();
                    return;
                }
                String name=et_lastname.getText().toString();
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(getApplicationContext(), "请输入您的名", Toast.LENGTH_SHORT).show();
                    return;
                }
                String email=et_email.getText().toString();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "请输入邮箱地址", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!isEmail(email)){
                    Toast.makeText(getApplicationContext(), "请输入正确的邮箱地址", Toast.LENGTH_SHORT).show();
                    return;
                }
                String remail=et_remail.getText().toString();
                if(!email.equals(remail)){
                    Toast.makeText(getApplicationContext(), "两次邮箱地址不一致", Toast.LENGTH_SHORT).show();
                    return;
                }
                String phone=et_phone.getText().toString();
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(getApplicationContext(), "请输入电话号码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!isMobile(phone)){
                    Toast.makeText(getApplicationContext(), "请输入正确的电话号码", Toast.LENGTH_SHORT).show();
                    return;
                }
                String password=et_password.getText().toString();
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!ispwd(password)){
                    Toast.makeText(getApplicationContext(), "密码格式不正确", Toast.LENGTH_SHORT).show();
                    return;
                }
                String repassword=et_repassword.getText().toString();
                if(!password.equals(repassword)){
                    Toast.makeText(getApplicationContext(), "两次密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Intent intent=new Intent(Register881Activity.this,SuccessActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
    public boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }
    public static boolean isMobile(String mobiles) {
        String tel = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        Pattern p = Pattern.compile(tel);
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
    public static boolean ispwd(String password) {
        String pwd = "^(?=.*?[0-9])[a-zA-Z0-9]{8,}$";
        Pattern p = Pattern.compile(pwd);
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
