package com.example.jsb.ms_lab12_201302476_2;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText input01;
    TextView txtMsg;
    WebView webview;
    public static String defaultUrl = "https://m.naver.com";

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = (WebView) findViewById(R.id.webview);

        input01 = (EditText) findViewById(R.id.input01);
        input01.setText(defaultUrl);
        txtMsg = (TextView) findViewById(R.id.txtMsg);

        //버튼 이벤트 처리
        Button requestBtn = (Button) findViewById(R.id.requestBtn);
        requestBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String urlStr = input01.getText().toString();
                ConnectThread thread = new ConnectThread(urlStr);
                thread.start();
                webview();
            }
        });
    }

    // 소켓 연결할 스레드 정의
    private class ConnectThread extends Thread{
        String urlStr;
        public  ConnectThread(String inStr){ urlStr = inStr;}

        public void run(){
            try{
                final String output = request(urlStr);
                handler.post(new Runnable(){
                    public void run(){
                        txtMsg.setText(output);
                    }
                });
            }catch (Exception e){e.printStackTrace();}
        }
    }

    private String request(String urlStr) {
        StringBuilder output = new StringBuilder();
        try{
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn != null){
                conn.setConnectTimeout(10000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = null;
                while(true){
                    line = reader.readLine();
                    if (line==null){
                        break;
                    }
                    output.append(line+"\n");
                }
                reader.close();
                conn.disconnect();
            }
        }catch (Exception e){
            Log.e("HTTP", "Exception in processing response.",e);
            e.printStackTrace();
        }
        return output.toString();
    }
    public void webview() {
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
}
