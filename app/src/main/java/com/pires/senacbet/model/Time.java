package com.pires.senacbet.model;

public class Time {


    private int id;
    private String nome;
    private String cidade;
    private String pais;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_Time() {
        return nome;
    }
    public void setNome_Time(String nome) {
        this.nome = nome;
    }

    public String getCidade_Time() {
        return cidade;
    }
    public void setCidade_Time(String cidade) {
        this.cidade = cidade;
    }

    public String getPais_Time() {
        return pais;
    }
    public void setPais_Time(String pais) {
        this.pais = pais;
    }


    @Override
    public String toString() {
        return nome;
    }
}
