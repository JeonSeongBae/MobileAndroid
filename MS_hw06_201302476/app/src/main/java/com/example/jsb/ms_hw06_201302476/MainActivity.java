package com.example.jsb.ms_hw06_201302476;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

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
                String naverUrl = "http://www.naver.com";
                webview.loadUrl(naverUrl);
            }
        });

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String moveUrl = url.getText().toString();
                webview.loadUrl(moveUrl);
            }
        });
    }
    private void webview() {
        webview.setWebViewClient (new WebViewClient());
        webview.loadUrl("http://www.naver.com");
    }

}

