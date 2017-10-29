package com.example.jsb.ms_hw07_201302476;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;
    SingerAdapter adapter;
    Button button;
    EditText name;
    EditText phone;
    EditText birth;
    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {return items.size();}

        public void addIem(SingerItem item){items.add(item);}

        @Override
        public Object getItem(int position) {return items.get(position);}

        @Override
        public long getItemId(int position) {return position;}

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            SingerItemView view = new SingerItemView(getApplicationContext());

            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setYear(item.getYear());
            view.setImage(item.getResId());
            return view;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                name = (EditText) findViewById(R.id.name);
                phone = (EditText) findViewById(R.id.phone);
                birth = (EditText) findViewById(R.id.birth);
                adapter.addIem(new SingerItem(name.getText().toString(), phone.getText().toString(), birth.getText().toString(), R.drawable.customer));
                listView.setAdapter(adapter);
                name.setText("");
                phone.setText("");
                birth.setText("");
            }
        });
        adapter = new SingerAdapter();
//        adapter.addIem(new SingerItem("소녀시대","010-1000-1000",2007,R.drawable.customer));
//        adapter.addIem(new SingerItem("에이핑크","010-2000-2000",2011,R.drawable.customer));
//        adapter.addIem(new SingerItem("여자친구","010-3000-3000",2015,R.drawable.customer));
//        adapter.addIem(new SingerItem("레드벨벳","010-4000-4000",2014,R.drawable.customer));
//        adapter.addIem(new SingerItem("AOA","010-5000-5000",2012,R.drawable.customer));
//        adapter.addIem(new SingerItem("트와이스","010-6000-6000",2015,R.drawable.customer));

//        listView.setAdapter(adapter);

        textView = (TextView) findViewById(R.id.textView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택 : "+item.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }


}