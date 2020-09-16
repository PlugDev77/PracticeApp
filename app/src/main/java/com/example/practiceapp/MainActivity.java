package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml 의 RecyclerView 와 연결
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        // 1줄에 하나씩 적용하기 위하여 LinearLayoutManager 를 이용
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Adapter 적용
        final RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        for (int i = 0; i < 10; i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            Data data = new Data();
            data.setTitle(Integer.toString(i));
            data.setContent(Integer.toString(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data data = new Data();
                data.setTitle("TEST TITLE");
                data.setContent("Content Title");

                adapter.addItem(data);
                adapter.notifyDataSetChanged();
            }
        });

        // 1. xml 에서 아이디 불러오기
        // 2. LayoutManager 로 나열 방식 정하기
        // 3. Adapter 로 아이템 구성 방식 정하기

    }
}