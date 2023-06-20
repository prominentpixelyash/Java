package com.prominentpixel.singleindexing;

import java.util.Objects;

public class Product {

    private int productId;
    private String productName;
    private int productPrice;
    private  String madeInCountry;
    private int numberOfProducts;
    private String productCategory;

    public Product() {
    }

    public Product(int productId, String productName, int productPrice, String madeInCountry, int numberOfProducts, String productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.madeInCountry = madeInCountry;
        this.numberOfProducts = numberOfProducts;
        this.productCategory = productCategory;
    }

    public Product(String productName, String madeInCountry, int numberOfProducts) {
        this.productName = productName;
        this.madeInCountry = madeInCountry;
        this.numberOfProducts = numberOfProducts;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getMadeInCountry() {
        return madeInCountry;
    }

    public void setMadeInCountry(String madeInCountry) {
        this.madeInCountry = madeInCountry;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && productPrice == product.productPrice && numberOfProducts == product.numberOfProducts && Objects.equals(productName, product.productName) && Objects.equals(madeInCountry, product.madeInCountry) && Objects.equals(productCategory, product.productCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productPrice, madeInCountry, numberOfProducts, productCategory);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", madeInCountry='" + madeInCountry + '\'' +
                ", numberOfProducts=" + numberOfProducts +
                ", productCategory='" + productCategory + '\'' +
                '}';
    }
}
