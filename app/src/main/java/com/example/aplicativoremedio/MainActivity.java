package com.example.aplicativoremedio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static RecyclerView recyclerView;
    private static Integer count=0;
    private static final ArrayList<RemedioModelo> remedios = new ArrayList<>();
    FloatingActionButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new AdapterRE(this, remedios));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        button = findViewById(R.id.btnCriar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });
    }

    public void openActivity(){
        startActivity(new Intent(this, CriarRemedio.class));
        finish();
    }

    public static void addRemedio(String nome, String frequencia, String dose, String horario){
        remedios.add(new RemedioModelo(count, nome, frequencia, dose, horario));
        count++;
    }

    public static void editRemedio(Integer id, String nome, String frequencia, String dose, String horario){
        int index = -1;
        for (RemedioModelo remedio : remedios) {
            if (remedio.getId() == id) {
                index = remedios.indexOf(remedio);
            }
        }
        if (index!=-1) {
            remedios.set(index, new RemedioModelo(id, nome, frequencia, dose, horario));
        }
    }

    public static void deletarRemedio(Integer id){
        remedios.removeIf(remedio -> remedio.getId() == id);
    }

}