package com.example.jsb.ms_hw08_201302476;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertItem extends AppCompatActivity {
    EditText company;
    EditText name;
    EditText price;
    EditText comment;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_item);
        company = (EditText) findViewById(R.id.company);
        name = (EditText) findViewById(R.id.name);
        price = (EditText) findViewById(R.id.price);
        comment = (EditText) findViewById(R.id.comment);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsertItem.this,MainActivity.class);
                intent.putExtra("company", company.getText().toString());
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("price", price.getText().toString());
                intent.putExtra("comment", comment.getText().toString());
                setResult(1, intent);

                finish();
            }
        });
    }

}
