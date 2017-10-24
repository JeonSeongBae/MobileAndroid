package com.example.jsb.ms_hw05_201302476_jeonseongbae;

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
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button date;
    Button time;
    Button save;
    EditText name;
    EditText phone;
    int currentYear;
    int currentMonth;
    int currentDay;
    int currentHour;
    int currentMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = (Button) findViewById(R.id.date);
        time = (Button) findViewById(R.id.time);
        save = (Button) findViewById(R.id.save);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);

        currentUpdate();

        date.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               Context context = MainActivity.this;
               DatePickerDialog datePickerDialog = new DatePickerDialog(context, dateSetListener, currentYear, currentMonth-1, currentDay);
               datePickerDialog.show();
           }
        });

        time.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    Context context = MainActivity.this;
                    TimePickerDialog timePickerDialog = new TimePickerDialog(context ,timeSetListener, currentHour, currentMin ,false);
                    timePickerDialog.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    Toast.makeText(getApplicationContext(),"이름:" + name.getText().toString() + ",번호:" +phone.getText().toString() + "날짜:" + currentYear + "년" + currentMonth + "월" + currentDay + "일,시간 : "+currentHour+"시" +currentMin+"분", Toast.LENGTH_LONG).show();
            }
        });
    }
    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            date.setText(year+"년 "+(month+1)+"월 "+day+"일");
            currentYear = year;
            currentMonth = month;
            currentMonth++;
            currentDay = day;
        }
    };
    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int inputHour, int inputMin) {
            time.setText(inputHour+"시 "+inputMin+"분");
            currentHour = inputHour;
            currentMin = inputMin;
        }
    };

    private void currentUpdate() {

        Date currentDate = new Date(System.currentTimeMillis());
        currentYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(currentDate));
        currentMonth = Integer.parseInt(new SimpleDateFormat("MM").format(currentDate));
        currentDay = Integer.parseInt(new SimpleDateFormat("dd").format(currentDate));
        currentHour = Integer.parseInt(new SimpleDateFormat("HH").format(currentDate));
        currentMin = Integer.parseInt(new SimpleDateFormat("mm").format(currentDate));

        SimpleDateFormat newDate = new SimpleDateFormat("yyyy년 MM월 dd일");
        SimpleDateFormat newTime = new SimpleDateFormat("HH시 mm분");

        date.setText(newDate.format(currentDate));
        time.setText(newTime.format(currentDate));
    }
}
