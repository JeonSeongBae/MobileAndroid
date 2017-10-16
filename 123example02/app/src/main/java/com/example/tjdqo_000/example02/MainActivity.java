package com.example.tjdqo_000.example02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView01;
    ImageView imageView02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView01 = (ImageView)findViewById(R.id.imageView01);
        imageView02 = (ImageView)findViewById(R.id.imageView02);
        Button button01 = (Button)findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveImageUp();
            }
        });
        Button button02 = (Button)findViewById(R.id.button02);
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveImageDown();
            }
        });
        moveImageUp();
    }

    private void moveImageDown(){
        imageView01.setImageResource(0);
        imageView02.setImageResource(R.drawable.image01);
        imageView01.invalidate();
        imageView02.invalidate();
    }

    private void moveImageUp(){
        imageView01.setImageResource(R.drawable.image01);
        imageView02.setImageResource(0);
        imageView01.invalidate();
        imageView02.invalidate();
    }
}
