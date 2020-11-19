package com.example.registramais.model;

import java.io.Serializable;

public class Product implements Serializable {

    private String id;
    private String nome;
    private String valor;


    public Product(String nome, String valor) {
        this.nome = nome;
        this.valor = valor;
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

    public String getValorComoString() {
        return String.valueOf(valor);
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
