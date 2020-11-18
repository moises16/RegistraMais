package com.example.registramais.model;

import java.io.Serializable;

public class Pedido implements Serializable {
    private int id;
    private String nomeCliente;
    private String numero;
    private String data;

    public Pedido(String nomeCliente, String numero, String data) {
        this.nomeCliente = nomeCliente;
        this.numero = numero;
        this.data = data;
    }

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
