package com.example.jsb.ms_hw08_201302476;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    GridView gridView;
    SingerAdapter adapter;
    ActionBar abar;

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

            int numColumns = gridView.getNumColumns();
            int rowIndex = position/numColumns;
            int columnIndex = position%numColumns;
            Log.d("SingerAdapter","index : " + rowIndex+", "+columnIndex);
            return view;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.insert:
                Intent intent = new Intent(MainActivity.this, InsertItem.class);
                startActivityForResult(intent, 1);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abar = this.getSupportActionBar();
        abar.show();


        gridView = (GridView) findViewById(R.id.gridView);

        adapter = new SingerAdapter();
        adapter.addIem(new SingerItem("에이핑크","010-2000-2000",2011,R.drawable.clothes1));
        adapter.addIem(new SingerItem("여자친구","010-3000-3000",2015,R.drawable.clothes2));
        adapter.addIem(new SingerItem("레드벨벳","010-4000-4000",2014,R.drawable.clothes3));
        adapter.addIem(new SingerItem("AOA","010-5000-5000",2012,R.drawable.clothes4));

        gridView.setAdapter(adapter);

        editText = (EditText) findViewById(R.id.editText);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택 : "+item.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }


}
