package com.example.jsb.ms_lab06_201302476_jeonseongbae;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by jsb on 2017-10-19.
 */

public class Fragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        // 화면 inflate
        ViewGroup rootView;

        rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        //버튼 이벤트 정의
        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // fragment를 호출한 액티비티 얻기
                MainActivity activity = (MainActivity) getActivity();
                activity.onFragmentChanged(0);
            }
        });
        return rootView;
    }

}
