package com.example.registramais.model;

public class ItemList {
    private Product product;
    private int qtdProduct;

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

    public void setQtdProduct(int qtdProduct) {
        this.qtdProduct = qtdProduct;
    }
}
