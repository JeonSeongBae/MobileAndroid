package com.example.jsb.ms_hw10_201302476_jeonseongbae;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    CustomerItemView view, view2, view3;
    Button start, stop;
    boolean ruuning = false;
    int selected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout= (FrameLayout) findViewById(R.id.container);
        view=new CustomerItemView(this);
        view2=new CustomerItemView(this);
        view3=new CustomerItemView(this);

        view.setName("김준수");
        view.setMobile("010-2000-2000");
        view.setAddress("서울시");
        view2.setName("이희선");
        view2.setMobile("010-3000-3000");
        view2.setAddress("부산시");
        view3.setName("최민수");
        view3.setMobile("010-4000-4000");
        view3.setAddress("대전시");

        frameLayout.addView(view);

        start=(Button)findViewById(R.id.start);
        stop=(Button)findViewById(R.id.end);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Animation thread=new Animation();
                thread.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                ruuning = false;
            }
        });
    }
    class Animation extends  Thread{
        Handler handler=new Handler();
        public void run(){
            ruuning = true;
            while(true){
                if(ruuning == false){
                    this.interrupt();
                    break;
                }
                handler.post(new Runnable(){
                    public void run() {
                        if (selected == 0) {
                            frameLayout.removeAllViews();
                            frameLayout.addView(view);
                        } else if (selected == 1) {
                            frameLayout.removeAllViews();
                            frameLayout.addView(view2);
                        } else if (selected == 2) {
                            frameLayout.removeAllViews();
                            frameLayout.addView(view3);
                        }
                    }
                });
                selected+=1;
                if(selected>2){
                    selected=0;
                }
                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                }
            }
        }
    }

}
