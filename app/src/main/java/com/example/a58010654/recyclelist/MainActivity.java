package com.example.a58010654.recyclelist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<User> userList;
    private RecycleViewAdapter recycleViewAdapter;
    private RecyclerView recyclerView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        userList = new ArrayList<>();

        for(int i=0;i<10;i++)
            userList.add(new User("name"+i,"id"+i,"age"+i));

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recycleViewAdapter = new RecycleViewAdapter(userList, context, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                Log.v("11","click Card");
            }

            @Override
            public void onPositionMenuClick(int position) {
                Log.v("11","click Card Menu");
            }

            @Override
            public void onLongClicked(int position) {
                Log.v("11","long click");
            }
        });

        recyclerView.setAdapter(recycleViewAdapter);

    }


}
