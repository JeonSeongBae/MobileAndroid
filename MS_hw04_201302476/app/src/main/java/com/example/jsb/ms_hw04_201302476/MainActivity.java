package com.example.jsb.ms_hw04_201302476;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
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
                String id = inputId.getText().toString();
                String pw = inputPassword.getText().toString();

                if(id.equals("") || pw.equals("")) {
                    Toast.makeText(MainActivity.this, "사용자명이나 비밀번호가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("pw", pw);
                    startActivity(intent);
                }

            }
        });

    }
}