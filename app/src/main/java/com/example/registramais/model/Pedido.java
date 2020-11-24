package com.example.registramais.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Pedido implements Serializable {
    private String id;
    private String nomeCliente;
    private String numero;
    private String data;
    private String nomeProduto;
    private double valorProduto;

    public Pedido(String nomeCliente, String numero) {
        Locale BRAZIL = new Locale("pt", "BR");
        this.nomeCliente = nomeCliente;
        this.numero = numero;

        this.data = DateFormat.getDateInstance(DateFormat.MEDIUM, BRAZIL).format(Calendar.getInstance().getTime());
    }

    public Pedido(String nomeCliente, String numero,String nomeProduto, double valorProduto) {
        Locale BRAZIL = new Locale("pt", "BR");
        this.nomeCliente = nomeCliente;
        this.numero = numero;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.data = DateFormat.getDateInstance(DateFormat.MEDIUM, BRAZIL).format(Calendar.getInstance().getTime());
    }

    public Pedido() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
