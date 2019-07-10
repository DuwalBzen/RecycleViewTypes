package com.example.recycleviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Switch switch_id;
    private LinearLayout main_layout_id;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myadapter;
    private List<list_row_model> list_row_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        list_row_data=new ArrayList<>();
        main_layout_id=findViewById(R.id.main_layout_id);
        switch_id=findViewById(R.id.switch_id);

        switch_id.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    main_layout_id.setBackgroundColor(Color.BLACK);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                } else {
                    main_layout_id.setBackgroundColor(Color.WHITE);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
                }
            }



        });
        recyclerView=findViewById(R.id.main_recycleview_id);


        int image[]={
                R.drawable.thegoodquote_1,
                R.drawable.thegoodquote_2,
                R.drawable.thegoodquote_3,
                R.drawable.thegoodquote_4,
                R.drawable.thegoodquote_5,
                R.drawable.thegoodquote_6,
                R.drawable.thegoodquote_7,
                R.drawable.thegoodquote_8,
                R.drawable.thegoodquote_9,
                R.drawable.thegoodquote_10,
                R.drawable.thegoodquote_11,
                R.drawable.thegoodquote_12,
                R.drawable.thegoodquote_13,
                R.drawable.thegoodquote_14,
                R.drawable.thegoodquote_15,
                R.drawable.thegoodquote_16,
                R.drawable.thegoodquote_17,
                R.drawable.thegoodquote_18,
                R.drawable.thegoodquote_19,
                R.drawable.thegoodquote_20,

        };

        for(int i=0;i<image.length;i++){
            list_row_model items=new list_row_model(image[i]);
            list_row_data.add(items);
        }


        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myadapter=new RecycleViewAdapter(this,list_row_data);
        recyclerView.setAdapter(myadapter);

    }
}
