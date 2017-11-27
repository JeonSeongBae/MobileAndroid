package com.example.jsb.ms_lab12_201302476;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    EditText input01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input01 = (EditText) findViewById(R.id.input01);

        // 버튼 이벤트 처리
        Button button01 = (Button) findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String addr = input01.getText().toString().trim();

                ConnectThread thread = new ConnectThread(addr);
                thread.start();
            }
        });
    }

    private class ConnectThread extends Thread{
        String hostname;

        public ConnectThread(String addr){
            hostname = addr;
        }

        public void run(){
            try {
                int port = 5001;

                Socket sock = new Socket(hostname, port);
                ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
                outstream.writeObject("모바일소프트웨어설계");
                outstream.flush();

                ObjectInputStream inputStream = new ObjectInputStream(sock.getInputStream());
                String obj = (String) inputStream.readObject();

                Log.d("MainActivity", "서버에서 받은 메시지 : "+obj );

                sock.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
