package com.si6a.kuyrakit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvGunpla;
    private ArrayList<ModelGunpla> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGunpla = findViewById(R.id.rv_gunpla);
        rvGunpla.setHasFixedSize(true);

        data.addAll(DataGunpla.ambilDataGunpla());
        tampilDataCard();
    }

    private void tampilDataCard(){
        rvGunpla.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard ACard = new AdapterCard(data, MainActivity.this);
        rvGunpla.setAdapter(ACard);
    }

}