package com.example.jsb.ms_hw04_201302476;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

public class PermissionActivity extends AppCompatActivity {
    TextView text;
    Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        text = (TextView) findViewById(R.id.permission_text);

        Intent intent = getIntent();
        final String type = intent.getStringExtra("type");
        final boolean permission = intent.getBooleanExtra("permission", false);
        String msg;
        if(!permission) {
            msg = type + "권한인증 실패";
        } else {
            msg = type + "권한인증 성공";
        }
        text.setText(msg);
        Toast.makeText(this, "titleMsg : " + msg, Toast.LENGTH_SHORT).show();
        menu = (Button) findViewById(R.id.permission_home);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(PermissionActivity.this, MenuActivity.class);
                it.putExtra("type", type);
                if(permission) {
                    it.putExtra("permission", -1);
                } else {
                    it.putExtra("permission", 0);
                }

                setResult(1, it);
                finish();
            }
        });

    }
}