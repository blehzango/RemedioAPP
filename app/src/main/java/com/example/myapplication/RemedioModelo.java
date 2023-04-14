package com.example.myapplication;

public class RemedioModelo {
    private String nome_remedio;
    private Double dose;
    private Integer frequencia;
    private int img = android.R.drawable.btn_star ;

    public RemedioModelo(String nome_remedio, Double dose, Integer frequencia) {
        this.nome_remedio = nome_remedio;
        this.dose = dose;
        this.frequencia = frequencia;
       // this.img=img;
    }



    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
    public String getNome_remedio() {
        return nome_remedio;
    }

    public void setNome_remedio(String nome_remedio) {
        this.nome_remedio = nome_remedio;
    }

    public Double getDose() {
        return dose;
    }

    public void setDose(Double dose) {
        this.dose = dose;
    }

    public Integer getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Integer frequencia) {
        this.frequencia = frequencia;
    }
}
