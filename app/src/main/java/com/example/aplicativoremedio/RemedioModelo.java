package com.example.aplicativoremedio;

import android.content.Intent;

import java.util.concurrent.atomic.AtomicInteger;

public class RemedioModelo {
    private Integer id;
    private String nome, frequencia, dose, horario;

    public RemedioModelo(Integer id, String nome, String frequencia, String dose, String horario) {
        this.id = id;
        this.nome = nome;
        this.frequencia = frequencia;
        this.dose = dose;
        this.horario = horario;
    }

    public int getId() { return id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}