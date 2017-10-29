package com.example.jsb.ms_hw07_201302476;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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
            view.setTag(position);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setTitle("안내")        // 제목 설정
                            .setMessage("삭제하시겠습니까?")        // 메세지 설정
                            .setCancelable(false)        // 뒤로 버튼 클릭시 취소 가능 설정
                            .setPositiveButton("예", new DialogInterface.OnClickListener(){
                                // 확인 버튼 클릭시 설정
                                public void onClick(DialogInterface dialog, int whichButton){
                                    int po = (int) view.getTag();
                                    items.remove(po);
                                    textView = (TextView) findViewById(R.id.textView);
                                    textView.setText(adapter.getCount()+"명");
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("아니오", new DialogInterface.OnClickListener(){
                                // 취소 버튼 클릭시 설정
                                public void onClick(DialogInterface dialog, int whichButton){
                                    dialog.cancel();
                                }
                            });
                    AlertDialog dialog = builder.create();    // 알림창 객체 생성
                    dialog.show();    // 알림창 띄우기
                }
            });
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
                textView = (TextView) findViewById(R.id.textView);
                textView.setText(adapter.getCount()+"명");
                name.setText("");
                phone.setText("");
                birth.setText("");
            }
        });
        adapter = new SingerAdapter();

    }


}