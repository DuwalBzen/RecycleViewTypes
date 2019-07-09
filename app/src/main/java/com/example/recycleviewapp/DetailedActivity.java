package com.example.recycleviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

public class DetailedActivity extends AppCompatActivity {
    private ImageView detailed_image_id;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        detailed_image_id = findViewById(R.id.detailed_image_id);
        extras =getIntent().getExtras();
        detailed_image_id.setImageResource(extras.getInt("ïmage_id"));


    }
}
