package com.example.jsb.ms_hw04_201302476_jeonseongbae_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputId;
    EditText inputPassword;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputId = (EditText) findViewById(R.id.input_id);
        inputPassword = (EditText) findViewById(R.id.input_pw);

        loginButton = (Button) findViewById(R.id.login_bt);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(inputId.getText().toString()) || TextUtils.isEmpty(inputPassword.getText().toString())){
                    Toast.makeText(MainActivity.this,"사용자명이나 비밀번호가 입력되지 않았습니다.", Toast.LENGTH_LONG).show();
                }else{
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                intent.putExtra("id", inputId.getText().toString());
                intent.putExtra("password", inputPassword.getText().toString());
                startActivityForResult(intent, 1);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 1) {
            String menuText = data.getStringExtra("bt");
            Toast.makeText(this, "메뉴 : " + menuText, Toast.LENGTH_SHORT).show();
        }
    }
}
