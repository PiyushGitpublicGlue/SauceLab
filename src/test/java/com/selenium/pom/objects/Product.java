package com.selenium.pom.objects;

import com.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

public class Product {

    private int productId;
    private String productName;
    private String productTitle;


    public Product(){}
    public Product(int productId) throws IOException {
        Product[] products = JacksonUtils.deserializeJson("myProduct.json",Product[].class);
            for(Product product:products){
                if(product.productId==productId){
                    this.productId=productId;
                    this.productName=product.getProductName();
                    this.productTitle=product.getProductTitle();
                }
            }
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
    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }


}
