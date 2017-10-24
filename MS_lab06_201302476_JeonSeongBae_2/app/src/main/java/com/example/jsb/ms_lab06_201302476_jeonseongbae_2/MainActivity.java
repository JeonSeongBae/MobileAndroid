package com.example.jsb.ms_lab06_201302476_jeonseongbae_2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showMessage();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showList();
            }
        });
    }

    private void showMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("안내");
        builder.setMessage("종료하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton("예", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int whichButton){
                String message = "예 버튼이 눌렸습니다.";
                textView.setText(message);
            }
        });

        builder.setNeutralButton("취소", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int whichButton){
                String message = "취소 버튼이 눌렸습니다.";
                textView.setText(message);
            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int whichButton){
                String message = "아니오 버튼이 눌렸습니다.";
                textView.setText(message);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showList() {
        final String[] fruit = new String[] {"사과", "바나나", "포도", "귤"};
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("과일 선택");
        dialog.setItems(fruit, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                textView2.setText(fruit[which]);
            }
        });

        dialog.setPositiveButton("OK",null);
        dialog.show();
    }
}
