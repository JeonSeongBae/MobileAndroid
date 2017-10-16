package com.example.jsb.ms_lab05_201302476_jeonseongbae;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        // 나의 이름을 가지고 온다.

        Intent passedIntent = getIntent();
        processIntent(passedIntent);
    }
    public void onButton1Clicked(View v){
        String name = editText.getText().toString();

        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("command", "show");
        intent.putExtra("name", name);
        startService(intent);
    }
    @Override
    protected void onNewIntent(Intent intent){
        processIntent(intent);

        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent){
        if(intent != null){
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");

            Toast.makeText(this, "command : " + command + ", name : " + name, Toast.LENGTH_SHORT).show();
        }
    }

}
