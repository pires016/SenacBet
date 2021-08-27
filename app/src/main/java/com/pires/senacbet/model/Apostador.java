package com.pires.senacbet.model;


public class Apostador {


    private int id;
    private String nome;
    private String email;
    private String saldo;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSaldo() {
        return saldo;
    }
    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }


    @Override
    public String toString() {
        return nome;
    }
}

