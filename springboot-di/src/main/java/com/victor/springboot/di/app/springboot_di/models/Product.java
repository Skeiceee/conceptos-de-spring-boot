package com.victor.springboot.di.app.springboot_di.models;

public class Product implements Cloneable{
    private Long id;
    private String Name;
    private Long Price;

    public Product() {
    }

    public Product(Long id, String name, Long price){
        this.id = id;
        this.Name = name;
        this.Price = price;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public Long getPrice() {
        return Price;
    }
    public void setPrice(Long price) {
        Price = price;
    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(this.getId(), this.getName(), this.getPrice());
        }
    }

}
