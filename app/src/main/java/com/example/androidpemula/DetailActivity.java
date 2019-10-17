package com.example.androidpemula;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    TextView nama, alamat;
    ImageView imgDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        Items clubItems = getIntent().getParcelableExtra("data");

        nama = findViewById(R.id.nama);
        String text =  clubItems.getTitle();
        nama.setText(text);


        alamat = findViewById(R.id.alamat);
        String text2 = clubItems.getInfo();
        alamat.setText(text2);


        int Image = clubItems.getImage();
        imgDetail = findViewById(R.id.imgDetail);
        imgDetail.setImageResource(Image);
    }
}
