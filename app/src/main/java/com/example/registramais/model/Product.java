package com.example.registramais.model;

import java.io.Serializable;

public class Product implements Serializable {

    private String id;
    private String nome;
    private double valor;


    public Product(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
