package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RemediorRecyclerViewAdaptador extends RecyclerView.Adapter<RemediorRecyclerViewAdaptador.MyViewHolder> {
    Context context;
    ArrayList<RemedioModelo> remedios;

    public RemediorRecyclerViewAdaptador(Context context, ArrayList<RemedioModelo> remedios) {
        this.context = context;
        this.remedios = remedios;
    }

    @NonNull
    @Override
    public RemediorRecyclerViewAdaptador.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //infla o layout
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_linha, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RemediorRecyclerViewAdaptador.MyViewHolder holder, int position) {
    // dar valores para as views que criaram em recycler_view_linha layout
        //holder.tvNome.setText(RemedioModelo.get(position).getNome_remedio());
        RemedioModelo remedio = (RemedioModelo) remedios.get(position);
        holder.tvNome.setText(remedio.getNome_remedio());
        holder.tvFrequencia.setText(remedio.getFrequencia()+"");
    }

    @Override
    public int getItemCount() {
        // quer saber o numero de itens que voce quer exibir
        return remedios.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //pega todas as views do recycler_view_linhas layout

        ImageView imageView;
        TextView tvNome, tvFrequencia, tvDose;
        EditText etHora;
        CheckBox chB;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.pilula_imagem);
            tvNome =itemView.findViewById(R.id.nome_remedio);
            tvFrequencia =itemView.findViewById(R.id.frequencia_remedio);
            tvDose =itemView.findViewById(R.id.dose_remedio);
            etHora =itemView.findViewById(R.id.horarioremedio);
            chB =itemView.findViewById(R.id.checkBox);
        }

    }
}
