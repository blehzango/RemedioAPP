package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<RemedioModelo> remedios = new ArrayList<>();
    RecyclerView recyclerView;
    Button criarRemedio;
    Button deletarRemedio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView_remedios);
        criarRemedio = findViewById(R.id.criarRemedio);

        criarRemedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_layout);
                EditText nomeRemUsuario = dialog.findViewById(R.id.nome_usuario);
                EditText doseRemUsuario = dialog.findViewById(R.id.dosagem_usuario);
                EditText frequenciaRemUsuario = dialog.findViewById(R.id.frequencia_usuario);
                Button criarRemUsuario = dialog.findViewById(R.id.criarUsuario);

                criarRemUsuario.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nome = nomeRemUsuario.getText().toString();
                        Double dose = Double.parseDouble(doseRemUsuario.getText().toString());
                        Integer frequencia = Integer.parseInt(frequenciaRemUsuario.getText().toString());
                        remedios.add(new RemedioModelo(nome, dose, frequencia));
                        recyclerView.scrollToPosition(remedios.size() - 1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


        remedios.add(new RemedioModelo("nome", 1.5, 2));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RemediorRecyclerViewAdaptador adapter = new RemediorRecyclerViewAdaptador(this, remedios);
        recyclerView.setAdapter(adapter);

    }
}