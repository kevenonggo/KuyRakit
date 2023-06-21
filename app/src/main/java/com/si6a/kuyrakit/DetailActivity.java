package com.si6a.kuyrakit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivFoto;
    private TextView tvGunpla, tvDeskripsi;
    private String yGunpla, yDeskripsi, yFoto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivFoto = findViewById(R.id.iv_foto);
        tvGunpla = findViewById(R.id.tv_gunpla);
        tvDeskripsi = findViewById(R.id.tv_deskripsi);

        Intent terima = getIntent();
        yGunpla = terima.getStringExtra("xGunpla");
        yDeskripsi = terima.getStringExtra("xDeskripsi");
        yFoto = terima.getStringExtra("xFoto");

        tvGunpla.setText(yGunpla);
        tvDeskripsi.setText((yDeskripsi));
        Glide
                .with(DetailActivity.this)
                .load(yFoto)
                .into(ivFoto);
    }
}
