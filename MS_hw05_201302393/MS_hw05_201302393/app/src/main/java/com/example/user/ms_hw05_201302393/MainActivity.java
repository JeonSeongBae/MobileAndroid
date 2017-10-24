package com.example.user.ms_hw05_201302393;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button dateButton,timeButton,saveButton;
    EditText inputID, inputTel;

    int b_year, b_month, b_day;
    int b_hour, b_minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateButton = (Button) findViewById(R.id.dateButton);
        timeButton = (Button) findViewById(R.id.timeButton);
        saveButton = (Button) findViewById(R.id.save);

        inputID = (EditText) findViewById(R.id.ID);
        inputTel = (EditText) findViewById(R.id.Tel);

        long now = System.currentTimeMillis();
        Date CD = new Date(now);

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy년 MM월 dd일");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH시 mm분");

        SimpleDateFormat Y = new SimpleDateFormat("yyyy");
        SimpleDateFormat M = new SimpleDateFormat("MM");
        SimpleDateFormat D = new SimpleDateFormat("dd");
        SimpleDateFormat H = new SimpleDateFormat("HH");
        SimpleDateFormat Min = new SimpleDateFormat("mm");

        b_year = Integer.parseInt(Y.format(CD));
        b_month = Integer.parseInt(M.format(CD));
        b_day = Integer.parseInt(D.format(CD));
        b_hour = Integer.parseInt(H.format(CD));
        b_minute = Integer.parseInt(Min.format(CD));

        dateButton.setText(sdfDate.format(CD));
        timeButton.setText(sdfTime.format(CD));

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDate();
            }
        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTime();
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }
    public void saveData(){
        if(inputID.getText().toString().equals("") || inputTel.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"이름과 전화번호를 입력해 주세요.", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(getApplicationContext(),"이름 : " + inputID.getText().toString() + ", 번호 : " +inputTel.getText().toString()
                    + "\n날짜 : " + b_year + "년 " + b_month + "월 " + b_day + "일,\n시간 : "+b_hour+"시 " +b_minute+"분", Toast.LENGTH_LONG).show();
        }
    }
    public void changeDate(){
        Context context = new ContextThemeWrapper(this, android.R.style.Theme_Holo_Light_Dialog);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context = this;
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, dateSetListener, b_year, b_month-1, b_day);
        datePickerDialog.show();
    }
    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateButton.setText(year+"년 "+(monthOfYear+1)+"월 "+dayOfMonth+"일");
            b_year = year;
            b_month = monthOfYear+1;
            b_day = dayOfMonth;
        }
    };

    public void changeTime(){
        Context context = new ContextThemeWrapper(this, android.R.style.Theme_Holo_Light_Dialog);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context = this;
        }
        TimePickerDialog timePickerDialog = new TimePickerDialog(context ,timeSetListener, b_hour, b_minute ,false);
        timePickerDialog.show();
    }
    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            timeButton.setText(hourOfDay+"시 "+minute+"분");
            b_hour = hourOfDay;
            b_minute = minute;
        }
    };

}
