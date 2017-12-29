package com.yangjian.neworangemodule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @Bind(R.id.input_name)
    EditText inputName;
    @Bind(R.id.input_password)
    EditText inputPassword;
    @Bind(R.id.input_code)
    EditText inputCode;
    @Bind(R.id.btn_code)
    Button btnCode;
    @Bind(R.id.btn_register)
    AppCompatButton btnRegister;
    @Bind(R.id.link_login)
    TextView linkLogin;
    @Bind(R.id.input_phone)
    EditText inputPhone;
    @Bind(R.id.activity_register)
    LinearLayout activityRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        initListener();
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    //初始化监听
    private void initListener() {
        linkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.startActivity(RegisterActivity.this);
            }
        });
    }
}
