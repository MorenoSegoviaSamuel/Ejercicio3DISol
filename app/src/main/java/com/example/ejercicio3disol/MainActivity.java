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

    private final List<Integer> images;
    private RecyclerView recyclerView;

    private androidx.appcompat.widget.Toolbar toolbar;
    {
        images = new ArrayList<>();
        images.add(R.drawable.corona_solar);
        images.add(R.drawable.erupcionsolar);
        images.add(R.drawable.espiculas);
        images.add(R.drawable.filamentos);
        images.add(R.drawable.magnetosfera);
        images.add(R.drawable.manchasolar);
    }

    ImageButton opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opciones = findViewById(R.id.opciones);
        opciones.setOnClickListener(this::lanzarOpciones);

        recyclerView = findViewById(R.id.recyclerView);
        ItemAdapter adapter = new ItemAdapter(this,images);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }


    public void lanzarOpciones(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);  //Cambiar a opciones cuando este creada xd
        startActivity(intent);
    }
}