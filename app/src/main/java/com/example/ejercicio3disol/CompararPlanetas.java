package com.example.ejercicio3disol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CompararPlanetas extends AppCompatActivity {

    private AutoCompleteTextView a1;
    private TextView diametroI;
    private TextView distanciaSolI;
    private TextView densidadI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comparar_planetas);

        List<Planeta> planetas = new ArrayList<>();

        planetas.add(new Planeta("Mercurio", "0.382", "0.387", "5400"));
        planetas.add(new Planeta("Venus", "0.949", "0.723", "5250"));
        planetas.add(new Planeta("Tierra", "1", "1", "5520"));
        planetas.add(new Planeta("Marte", "0.53", "1.542", "3960"));
        planetas.add(new Planeta("Júpiter", "11.2", "5.203", "1350"));
        planetas.add(new Planeta("Saturno", "9.41", "9.539", "700"));
        planetas.add(new Planeta("Urano", "3.38", "19.81", "1200"));
        planetas.add(new Planeta("Neptuno", "3.81", "30.07", "1500"));
        planetas.add(new Planeta("Plutón", "???", "39.44", "5?"));

        ArrayAdapter<Planeta> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, planetas);

        a1.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Planeta planetaSeleccionado = (Planeta) a1.getAdapter().getItem(position);
                diametroI.setText(String.valueOf(planetaSeleccionado.getDiametro()));
                distanciaSolI.setText(String.valueOf(planetaSeleccionado.));  //Solucionar esto
                densidadI.setText(String.valueOf(planetaSeleccionado.getDensidad()));
            }
        });
    }
}
