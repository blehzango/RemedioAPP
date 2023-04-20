package com.example.aplicativoremedio;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class AdapterRE extends RecyclerView.Adapter<AdapterRE.MyViewHolder> {
    private ArrayList<RemedioModelo> remedios;
    private Context context;
    private LayoutInflater inflater;

    public AdapterRE(Context context, ArrayList<RemedioModelo> remedios) {
        this.context = context;
        this.remedios = remedios;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycle_viewer, parent, false) ;
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RemedioModelo remedio = this.remedios.get(position);
        holder.Nome.setText(remedio.getNome());
        holder.Frequencia.setText(remedio.getFrequencia());
        holder.Dose.setText(remedio.getDose());
        holder.Horario.setText(remedio.getHorario());
        holder.Id.setText(remedio.getId()+"");
    }

    @Override
    public int getItemCount() {
        return remedios.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Id, Nome, Frequencia, Dose, Horario;
        CheckBox Tomou;

        boolean jatomou = false;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Nome=itemView.findViewById(R.id.tvNome);
            Frequencia=itemView.findViewById(R.id.tvDose);
            Dose=itemView.findViewById(R.id.tvFrequencia);
            Horario=itemView.findViewById(R.id.tvHorario);
            Id=itemView.findViewById(R.id.tvId);
            Tomou=itemView.findViewById(R.id.btnTomouRemedio);
            Tomou.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    jatomou = !jatomou;
                }
            });
            itemView.setOnClickListener(this);
        }

        public String getNome() { return Nome.getText().toString(); }
        public String getFrequencia() { return Frequencia.getText().toString(); }
        public String getDose() { return Dose.getText().toString(); }
        public String getHorario() { return Horario.getText().toString(); }
        public String getId() { return Id.getText().toString(); }

        @Override
        public void onClick(View view) {
            if (!jatomou) {
                Intent i = new Intent(context, CriarRemedio.class);
                i.putExtra("ID_REMEDIO", getId());
                i.putExtra("NOME_REMEDIO", getNome());
                i.putExtra("FREQUENCIA_REMEDIO", getFrequencia());
                i.putExtra("DOSE_REMEDIO", getDose());
                i.putExtra("HORARIO_REMEDIO", getHorario());
                context.startActivity(i);
            } else {
                Toast.makeText(context, getNome()+" ja foi tomado e não pode ser editado/excluido!", Toast.LENGTH_SHORT).show();
            }
        }
    }

}