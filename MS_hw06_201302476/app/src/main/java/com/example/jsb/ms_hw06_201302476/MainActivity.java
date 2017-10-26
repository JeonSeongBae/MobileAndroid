package com.example.jsb.ms_hw06_201302476;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//1. 잘못된 url 입력시 오류 토스트 메시지 출력
//onReceiveError 메소드를 오버라이드 하여서 사용합니다.

//2. webview loadUrl(url) 사용시 새 창이 뜨는 경우
//webview.setWebViewClient(new WebViewClient() { }
//        다음 메소드를 사용하시면 화면 내부에서 webview가 열리는것을 확인하실 수 있습니다.

public class MainActivity extends AppCompatActivity {
    WebView webview;
    Button naver;
    Button move;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webview);
        naver = (Button) findViewById(R.id.naver);
        move = (Button) findViewById(R.id.move);
        url = (EditText) findViewById(R.id.url);
        webview();
        naver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naver();
            }
        });
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move();
            }
        });
    }

    private void webview() {
        webview.setWebViewClient (new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                switch (errorCode) {
                    case ERROR_AUTHENTICATION:
                        break;
                    // 서버에서 사용자 인증 실패
                    case ERROR_BAD_URL:
                        break;
                    // 잘못된 URL
                    case ERROR_CONNECT:
                        break;
                    // 서버로 연결 실패
                    case ERROR_FAILED_SSL_HANDSHAKE:
                        break;
                    // SSL handshake 수행 실패
                    case ERROR_FILE:
                        break;
                    // 일반 파일 오류
                    case ERROR_FILE_NOT_FOUND:
                        break;
                    // 파일을 찾을 수 없습니다
                    case ERROR_HOST_LOOKUP:
                        break;
                    // 서버 또는 프록시 호스트 이름 조회 실패
                    case ERROR_IO:
                        break;
                    // 서버에서 읽거나 서버로 쓰기 실패
                    case ERROR_PROXY_AUTHENTICATION:
                        break;
                    // 프록시에서 사용자 인증 실패
                    case ERROR_REDIRECT_LOOP:
                        break;
                    // 너무 많은 리디렉션
                    case ERROR_TIMEOUT:
                        break;
                    // 연결 시간 초과
                    case ERROR_TOO_MANY_REQUESTS:
                        break;
                    // 페이지 로드중 너무 많은 요청 발생
                    case ERROR_UNKNOWN:
                        break;
                    // 일반 오류
                    case ERROR_UNSUPPORTED_AUTH_SCHEME:
                        break;
                    // 지원되지 않는 인증 체계
                    case ERROR_UNSUPPORTED_SCHEME:
                        break;
                    // URI가 지원되지 않는 방식
                }
                Toast.makeText(MainActivity.this, "에러가 발생하였습니다.",Toast.LENGTH_LONG).show();
            }
        });
        webview.loadUrl("http://www.naver.com");
    }
    private void naver() {
        webview.loadUrl("http://www.naver.com");
    }
    private void move() {
        String moveUrl = url.getText().toString();
        webview.loadUrl(moveUrl);
    }
}

