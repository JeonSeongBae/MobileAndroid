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
import android.widget.GridView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
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
            view.setPrice(item.getPrice());
            view.setComment(item.getComment());
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

                String company = data.getStringExtra("company");
                String name = data.getStringExtra("name");
                String price = data.getStringExtra("price");

                int p = Integer.parseInt(price);
                DecimalFormat commas = new DecimalFormat("#,###");
                price = (String)commas.format(p);

                String comment = data.getStringExtra("comment");
                adapter.addIem(new SingerItem(company, name, price, comment, R.drawable.clothes5));
                adapter.notifyDataSetChanged();
                Toast.makeText(this,"상품이 등록되었습니다.",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abar = this.getSupportActionBar();
        abar.show();

        gridView = (GridView) findViewById(R.id.gridView);

        adapter = new SingerAdapter();
        adapter.addIem(new SingerItem("폴로","롱코트","300,000","기획상품",R.drawable.clothes1));
        adapter.addIem(new SingerItem("나이키","운동화","70,000","특가상품",R.drawable.clothes2));
        adapter.addIem(new SingerItem("폴로","남방","150,000","계절상품",R.drawable.clothes3));
        adapter.addIem(new SingerItem("리바이스","모자","40,000","반짝상품",R.drawable.clothes4));

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택된 제품 : "+item.getMobile()+"\n가격 : "+item.getPrice(),Toast.LENGTH_LONG).show();
            }
        });
    }


}
