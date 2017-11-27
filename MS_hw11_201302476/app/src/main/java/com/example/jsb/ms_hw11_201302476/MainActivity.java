package com.example.jsb.ms_hw11_201302476;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    WebView webview;
    EditText url;
    Handler handler = new Handler();
    TextView txtMsg;
    Button requestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webview);
        url = (EditText) findViewById(R.id.url);
        requestBtn = (Button) findViewById(R.id.requestBtn);
        txtMsg = (TextView) findViewById(R.id.txtMsg);

        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlStr = url.getText().toString();
                ConnectThread thread = new ConnectThread(urlStr);
                thread.start();
                webview(urlStr);
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

    public void webview(String urlStr) {
        webview.loadUrl(urlStr);
    }
}