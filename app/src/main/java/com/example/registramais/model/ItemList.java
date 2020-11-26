package com.example.registramais.model;

public class ItemList extends Product {
    private Product product;
    private int qtdProduct;

    public ItemList(String nome, double valor, int qtdProduct) {
        super(nome, valor);
        this.product = product;
        this.qtdProduct = qtdProduct;
    }

    public ItemList(Product product, int qtdProduct) {
        this.product = product;
        this.qtdProduct = qtdProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQtdProduct() {
        return qtdProduct;
    }

    public void setQtdProduct(int qtdProduct)  {
        this.qtdProduct = qtdProduct;
    }
}
