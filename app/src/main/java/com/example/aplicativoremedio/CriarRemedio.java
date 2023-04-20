package com.example.aplicativoremedio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CriarRemedio extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_remedio);

        FloatingActionButton buttonCriar = findViewById(R.id.btnCriarRemedio);
        FloatingActionButton buttonDeletar = findViewById(R.id.btnDeletarRemedio);
        TextView id = findViewById(R.id.ptId);
        EditText nome = findViewById(R.id.ptNome);
        EditText frequencia = findViewById(R.id.ptFrequencia);
        EditText dose = findViewById(R.id.ptDose);
        EditText hora = findViewById(R.id.ptHorarioH);
        EditText minuto = findViewById(R.id.ptHorarioM);

        Bundle extras = getIntent().getExtras();
        if (extras!=null) {
            id.setText(extras.getString("ID_REMEDIO"));
            Log.d("EDITANDO", id.getText() + "");
            nome.setText(extras.getString("NOME_REMEDIO"));
            frequencia.setText(extras.getString("FREQUENCIA_REMEDIO"));
            dose.setText(extras.getString("DOSE_REMEDIO"));
            String horas = extras.getString("HORARIO_REMEDIO");
            hora.setText(horas.split(":")[0]);
            minuto.setText(horas.split(":")[1]);

            buttonCriar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (checkHora(hora.getText().toString(), minuto.getText().toString())) {
                        String horario = hora.getText().toString() + ":" + minuto.getText().toString();
                        MainActivity.editRemedio(Integer.parseInt(id.getText().toString()), nome.getText().toString(), frequencia.getText().toString(), dose.getText().toString(), horario);
                        startActivity(new Intent(CriarRemedio.this, MainActivity.class));
                        finish();
                    }
                }
            });

            buttonDeletar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.deletarRemedio(Integer.parseInt(id.getText().toString()));
                    startActivity(new Intent(CriarRemedio.this, MainActivity.class));
                    finish();
                }
            });
        } else {
            buttonCriar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (checkHora(hora.getText().toString(), minuto.getText().toString())) {
                        String horario = hora.getText().toString() + ":" + minuto.getText().toString();
                        MainActivity.addRemedio(nome.getText().toString(), frequencia.getText().toString(), dose.getText().toString(), horario);
                        startActivity(new Intent(CriarRemedio.this, MainActivity.class));
                        finish();
                    }
                }
            });

            buttonDeletar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(CriarRemedio.this, MainActivity.class));
                    finish();
                }
            });
        }
    }

    public boolean checkHora(String hora, String minuto) {
        int h = Integer.parseInt(hora);
        int m = Integer.parseInt(minuto);
        return !(h < 0 || h > 23 || m < 0 || m > 59);
    }
}
