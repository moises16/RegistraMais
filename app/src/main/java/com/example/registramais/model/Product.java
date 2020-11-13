package com.example.registramais.model;

public class Product {
    private String nomeCliente;
    private int numero;
    private String endereco;

    public Product(String nomeCliente, int numero, String endereco) {
        this.nomeCliente = nomeCliente;
        this.numero = numero;
        this.endereco = endereco;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
