package com.example.jsb.ms_hw04_201302476_jeonseongbae_2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    Button positionButton;
    Button cameraButton;
    Button calenderButton;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String pw = intent.getStringExtra("password");
        String permission = intent.getStringExtra("permission");
        String menu = intent.getStringExtra("menu");

        String result = intent.getStringExtra("result");
        if (menu != null){
            Toast.makeText(this,permission+" 권한 응답" + ",resultcode:"+result+"message:result message is OK!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"username:"+id+",password:"+pw,Toast.LENGTH_LONG).show();
        }
        positionButton = (Button) findViewById(R.id.position_bt);
        cameraButton = (Button) findViewById(R.id.camera_bt);
        calenderButton = (Button) findViewById(R.id.calender_bt);
        loginButton = (Button) findViewById(R.id.login_bt);

        View.OnClickListener listener = new View.OnClickListener() {
            // 위험 권한 부여 요청

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, com.example.jsb.ms_hw04_201302476_jeonseongbae_2.MainActivity.class);

                switch (view.getId()) {

                    case R.id.position_bt:

                        int permissionCheck = ContextCompat.checkSelfPermission(MenuActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
                        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                            //권한 있음
                            Toast.makeText(MenuActivity.this, "권한이 있습니다.",Toast.LENGTH_LONG).show();
                        } else {
                            //권한 없음
                            ActivityCompat.requestPermissions(MenuActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                        }
                        break;
                    case R.id.camera_bt:
                         permissionCheck = ContextCompat.checkSelfPermission(MenuActivity.this, Manifest.permission.CAMERA);
                        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                            //권한 있음
                            Toast.makeText(MenuActivity.this, "권한이 있습니다.",Toast.LENGTH_LONG).show();
                        } else {
                            //권한 없음
                            ActivityCompat.requestPermissions(MenuActivity.this, new String[]{Manifest.permission.CAMERA}, 2);
                        }
                        break;
                    case R.id.calender_bt:
                         permissionCheck = ContextCompat.checkSelfPermission(MenuActivity.this, Manifest.permission.READ_CALENDAR);
                        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                            //권한 있음
                            Toast.makeText(MenuActivity.this, "권한이 있습니다.",Toast.LENGTH_LONG).show();
                        } else {
                            //권한 없음
                            ActivityCompat.requestPermissions(MenuActivity.this, new String[]{Manifest.permission.READ_CALENDAR}, 3);
                        }
                        break;
                    case R.id.login_bt:
                        startActivity(intent);
                        finish();
                    default:
                }
//                setResult(1, intent);
//                finish();
            }
        };

        positionButton.setOnClickListener(listener);
        cameraButton.setOnClickListener(listener);
        calenderButton.setOnClickListener(listener);
        loginButton.setOnClickListener(listener);


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch (requestCode){
            case 1: {
                Intent menuintent = new Intent(MenuActivity.this, Menu2Activity.class);
                if (grantResults.length>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // 권한을 승인함
                    menuintent = new Intent(MenuActivity.this, Menu2Activity.class);
                    menuintent.putExtra("permission", "위치 권한 인증");
                    menuintent.putExtra("result", "-1");
                    startActivity(menuintent);
                    finish();
                }else{
                    // 권한 거부
                    menuintent.putExtra("permission", "위치 권한 인증 실패");
                    menuintent.putExtra("result", "0");
                    startActivity(menuintent);
                    finish();
                }
            }
            break;
            case 2: {
                Intent menuintent = new Intent(MenuActivity.this, Menu2Activity.class);
                if (grantResults.length>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // 권한을 승인함
                    menuintent = new Intent(MenuActivity.this, Menu2Activity.class);
                    menuintent.putExtra("permission", "카메라 권한 인증");
                    menuintent.putExtra("result", "-1");
                    startActivity(menuintent);
                    finish();
                }else{
                    // 권한 거부
                    menuintent.putExtra("permission", "카메라 권한 인증 실패");
                    menuintent.putExtra("result", "0");
                    startActivity(menuintent);
                    finish();
                }
            }
            break;
            case 3: {
                Intent menuintent = new Intent(MenuActivity.this, Menu2Activity.class);
                if (grantResults.length>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // 권한을 승인함
                    menuintent = new Intent(MenuActivity.this, Menu2Activity.class);
                    menuintent.putExtra("permission", "달력 권한 인증");
                    menuintent.putExtra("result", "-1");
                    startActivity(menuintent);
                    finish();
                }else{
                    // 권한 거부
                    menuintent.putExtra("permission", "달력 권한 인증 실패");
                    menuintent.putExtra("result", "0");
                    startActivity(menuintent);
                    finish();
                }
            }
            break;
        }
    }

}
