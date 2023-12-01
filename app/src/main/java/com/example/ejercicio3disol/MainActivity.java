package com.example.ejercicio3disol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<SolarImage> solarImageList;

    private RecyclerView recyclerView;

    private androidx.appcompat.widget.Toolbar toolbar;

    ImageButton opciones;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solarImageList = new ArrayList<>();
        solarImageList.add(new SolarImage(R.drawable.corona_solar, "Corona"));
        solarImageList.add(new SolarImage(R.drawable.erupcionsolar, "Erupcion"));
        solarImageList.add(new SolarImage(R.drawable.espiculas, "Espiculas"));
        solarImageList.add(new SolarImage(R.drawable.filamentos, "Filamentos"));
        solarImageList.add(new SolarImage(R.drawable.magnetosfera, "Magnetosfera"));
        solarImageList.add(new SolarImage(R.drawable.manchasolar, "Mancha"));

        opciones = findViewById(R.id.opciones);
        opciones.setOnClickListener(this::lanzarOpciones);

        recyclerView = findViewById(R.id.recyclerView);
        ItemAdapter adapter = new ItemAdapter(this,solarImageList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2 ));
        recyclerView.setAdapter(adapter);
    }


    public void lanzarOpciones(View view) {
        Intent intent = new Intent();
        intent.setClass(this, CompararPlanetas.class);
        startActivity(intent);
    }
}