package com.example.jsb.ms_hw04_201302476_jeonseongbae_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Menu2Activity extends AppCompatActivity {
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        Toast.makeText(this, "titleMsg : " + getIntent().getStringExtra("permission"), Toast.LENGTH_LONG).show();
        Intent intent = getIntent();
        final String permission = intent.getStringExtra("permission");
        final String result = intent.getStringExtra("result");
        textView = (TextView) findViewById(R.id.permission);
        button = (Button) findViewById(R.id.menu_bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(Menu2Activity.this, MenuActivity.class);
                    intent.putExtra("menu", "titleMsg : "+ permission);
                switch (permission){
                    case "위치 권한 인증":
                        intent.putExtra("permission","위치");
                        intent.putExtra("result", result);
                        startActivity(intent);
                        finish();
                        break;
                    case "카메라 권한 인증":
                        intent.putExtra("permission","카메라");
                        intent.putExtra("result", result);
                        startActivity(intent);
                        finish();
                        break;
                    case "달력 권한 인증":
                        intent.putExtra("permission","달력");
                        intent.putExtra("result", result);
                        startActivity(intent);
                        finish();
                        break;
                    case "위치 권한 인증 실패":
                        intent.putExtra("permission","위치");
                        intent.putExtra("result", result);
                        startActivity(intent);
                        finish();
                        break;
                    case "카메라 권한 인증 실패":
                        intent.putExtra("permission","카메라");
                        intent.putExtra("result", result);
                        startActivity(intent);
                        finish();
                        break;
                    case "달력 권한 인증 실패":
                        intent.putExtra("permission","달력");
                        intent.putExtra("result", result);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        startActivity(intent);
                        finish();
                }
            }
        });
        textView.setText(permission);
    }
}
