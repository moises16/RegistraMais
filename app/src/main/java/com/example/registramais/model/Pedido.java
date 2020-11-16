package com.example.registramais.model;

import java.io.Serializable;

public class Pedido implements Serializable {
    private String nomeCliente;
    private int numero;
    private String data;

    public Pedido(String nomeCliente, int numero, String data) {
        this.nomeCliente = nomeCliente;
        this.numero = numero;
        this.data = data;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
