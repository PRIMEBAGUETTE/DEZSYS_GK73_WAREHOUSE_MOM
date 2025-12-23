package com.example.demo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ItemData {

    private String productID;
    private String productName;
    private String productCategory;
    private int productQuantity;
    private String productUnit;

    public ItemData() {}

    public ItemData(String productID, String productName, String productCategory, int productQuantity, String productUnit) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;
        this.productUnit = productUnit;
    }

    @JacksonXmlProperty
    public String getProductID() { return productID; }
    public void setProductID(String productID) { this.productID = productID; }

    @JacksonXmlProperty
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    @JacksonXmlProperty
    public String getProductCategory() { return productCategory; }
    public void setProductCategory(String productCategory) { this.productCategory = productCategory; }

    @JacksonXmlProperty
    public int getProductQuantity() { return productQuantity; }
    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }

    @JacksonXmlProperty
    public String getProductUnit() { return productUnit; }
    public void setProductUnit(String productUnit) { this.productUnit = productUnit; }
}
