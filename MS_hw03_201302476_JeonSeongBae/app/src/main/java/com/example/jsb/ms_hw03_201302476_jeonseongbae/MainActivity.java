package com.example.jsb.ms_hw03_201302476_jeonseongbae;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements Button.OnClickListener{
    String firstNum="";
    String secondNum= "";
    String oper = "";
    boolean inputed = false; // 연산자가 입력되었었나
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        Button button0 = (Button) findViewById(R.id.n0);
        button0.setOnClickListener(this);
        Button button1 = (Button) findViewById(R.id.n1);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.n2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.n3);
        button3.setOnClickListener(this);
        Button button4 = (Button) findViewById(R.id.n4);
        button4.setOnClickListener(this);
        Button button5 = (Button) findViewById(R.id.n5);
        button5.setOnClickListener(this);
        Button button6 = (Button) findViewById(R.id.n6);
        button6.setOnClickListener(this);
        Button button7 = (Button) findViewById(R.id.n7);
        button7.setOnClickListener(this);
        Button button8 = (Button) findViewById(R.id.n8);
        button8.setOnClickListener(this);
        Button button9 = (Button) findViewById(R.id.n9);
        button9.setOnClickListener(this);
        Button buttonPlus = (Button) findViewById(R.id.plus);
        buttonPlus.setOnClickListener(this);
        Button buttonMinus = (Button) findViewById(R.id.minus);
        buttonMinus.setOnClickListener(this);
        Button buttonDivide = (Button) findViewById(R.id.divde);
        buttonDivide.setOnClickListener(this);
        Button buttonMultiply = (Button) findViewById(R.id.multiply);
        buttonMultiply.setOnClickListener(this);
        Button buttonClear = (Button) findViewById(R.id.clear);
        buttonClear.setOnClickListener(this);
        Button buttonResult = (Button) findViewById(R.id.result);
        buttonResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Object temp = view.getId();
        if (temp.equals(R.id.n0)){
            Number("0");
        } else if (temp.equals(R.id.n1)){
            Number("1");
        } else if (temp.equals(R.id.n2)){
            Number("2");
        } else if (temp.equals(R.id.n3)){
            Number("3");
        } else if (temp.equals(R.id.n4)){
            Number("4");
        } else if (temp.equals(R.id.n5)){
            Number("5");
        } else if (temp.equals(R.id.n6)){
            Number("6");
        } else if (temp.equals(R.id.n7)){
            Number("7");
        } else if (temp.equals(R.id.n8)){
            Number("8");
        } else if (temp.equals(R.id.n9)){
            Number("9");
        } else if (temp.equals(R.id.plus)){
            Operator("+");
        } else if (temp.equals(R.id.minus)){
            Operator("-");
        } else if (temp.equals(R.id.multiply)){
            Operator("*");
        } else if (temp.equals(R.id.divde)){
            Operator("/");
        } else if (temp.equals(R.id.clear)){
            Clear();
        } else if (temp.equals(R.id.result)){
            Result();
        } else {
            Toast.makeText(this, "(오류)", Toast.LENGTH_SHORT).show();
        }
    }

    public void Number(String num) {
        if(!inputed){
            firstNum=firstNum + num;
            editText.setText(firstNum);
        } else {
            secondNum = secondNum + num;
            editText.setText(firstNum + oper + secondNum);
        }
    }

    public void Operator(String operator){
        if (operator.equals("+")){
            this.oper = "+";
        } else if (operator.equals("-")){
            this.oper = "-";
        } else if (operator.equals("*")){
            this.oper = "*";
        } else if (operator.equals("/")){
            this.oper = "/";
        } else {
            Toast.makeText(this, "(오류)", Toast.LENGTH_SHORT).show();
        }
        editText.setText(firstNum + oper);
        inputed = true;
    }

    public void Result() {
        if (oper.equals("+")){
            Toast.makeText(this, String.valueOf(Integer.parseInt(firstNum) + Integer.parseInt(secondNum)), Toast.LENGTH_SHORT).show();
        } else if (oper.equals("-")){
            Toast.makeText(this, String.valueOf(Integer.parseInt(firstNum) - Integer.parseInt(secondNum)), Toast.LENGTH_SHORT).show();
        } else if (oper.equals("*")){
            Toast.makeText(this, String.valueOf(Integer.parseInt(firstNum) * Integer.parseInt(secondNum)), Toast.LENGTH_SHORT).show();
        } else if (oper.equals("/")){
            Toast.makeText(this, String.valueOf(Integer.parseInt(firstNum) / Integer.parseInt(secondNum)), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "(오류)", Toast.LENGTH_SHORT).show();
        }
        Clear();
    }

    public void Clear() {
        editText.setText("");
        firstNum="";
        secondNum="";
        oper="";
        inputed = false;
    }
}