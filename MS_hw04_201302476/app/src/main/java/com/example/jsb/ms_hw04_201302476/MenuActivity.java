package com.example.jsb.ms_hw04_201302476;

        import android.Manifest;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.sax.StartElementListener;
        import android.support.annotation.NonNull;
        import android.support.v4.app.ActivityCompat;
        import android.support.v4.content.ContextCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    Button locationButton;
    Button cameraButton;
    Button calendarButton;
    Button loginButton;

    public static final int REQUEST_LOCATION = 1;
    public static final int REQUEST_CAMERA = 2;
    public static final int REQUEST_CALENDAR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String pw = intent.getStringExtra("pw");

        if(!id.equals("") && !pw.equals("")) {
            Toast.makeText(this, "username:" + id + ",password:" + pw, Toast.LENGTH_SHORT).show();
        }

        locationButton = (Button) findViewById(R.id.location_bt);
        cameraButton = (Button) findViewById(R.id.camera_bt);
        calendarButton = (Button) findViewById(R.id.calendar_bt);
        loginButton = (Button) findViewById(R.id.login_bt);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, PermissionActivity.class);

                switch (view.getId()) {
                    case R.id.location_bt:
                        permisstionCheck(Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_LOCATION);
                        break;
                    case R.id.camera_bt:
                        permisstionCheck(Manifest.permission.CAMERA, REQUEST_CAMERA);
                        break;
                    case R.id.calendar_bt:
                        permisstionCheck(Manifest.permission.READ_CALENDAR, REQUEST_CALENDAR);
                        break;
                    case R.id.login_bt:
                        Intent loginintent = new Intent(MenuActivity.this, MainActivity.class);
                        startActivity(loginintent);
                        break;
                    default:
                }
            }
        };

        locationButton.setOnClickListener(listener);
        cameraButton.setOnClickListener(listener);
        calendarButton.setOnClickListener(listener);
        loginButton.setOnClickListener(listener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Intent intent = new Intent(MenuActivity.this, PermissionActivity.class);

        switch (requestCode) {
            case REQUEST_LOCATION:
                intent.putExtra("type", "위치");
                break;
            case REQUEST_CAMERA:
                intent.putExtra("type", "카메라");
                break;
            case REQUEST_CALENDAR:
                intent.putExtra("type", "달력");
                break;
            default:
                break;
        }

        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            intent.putExtra("permission", true);
        } else {
            intent.putExtra("permission", false);
        }
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case 1:
                String type = data.getStringExtra("type");
                int response = data.getIntExtra("permission", 0);

                Toast.makeText(this, type + " 권한 응답, result code : " + response+"message:result message is OK!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    public void permisstionCheck(String type, int request) {
        int check = ContextCompat.checkSelfPermission(this, type);

        if(check == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "이미 권한이 있음.", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{type}, request);
        }
    }
}