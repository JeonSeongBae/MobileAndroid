package com.example.jsb.ms_lab07_201302476_03;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ActionBar abar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 액션바 객체를 참조할 때는 getActionBar()메소드를 사용합니다.
        abar = this.getSupportActionBar();
        // 보여주고 싶다면 show() 메소드를 호출합니다.
        abar.show();
        // 감추고 싶다면 hide() 메소드를 호출합니다.
        //abar.hide();
        // 타이틀의 부제목을 설정합니다.
        abar.setSubtitle("옵션바 살펴보기");
        // 선택된 메뉴를 표시할 텍스트뷰
        textView = (TextView) findViewById(R.id.textView);
    }
    public void onButton1Clicked(View v){
        abar.setLogo(R.drawable.home);
        abar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_USE_LOGO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_refresh: // 새로고침 메뉴 선택
                textView.setText("새로고침 메뉴를 선택했습니다.");
                return true;
            case R.id.menu_search:
                textView.setText("검색 메뉴를 선택했습니다.");
                return true;
            case R.id.menu_settings:
                textView.setText("설정 메뉴를 선택했습니다.");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}