package com.study.springbootsecurityrest.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "shop_db")
public class Shop {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 8, message = "Имя должно быть от 8 символов длиной")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Address must be not null")
    @Size(min = 20,message = "Size must be more than 20 symbols")
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "shop",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Product> products;

    public Set<Product> getProducts() {
        return products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addProduct(Product product){
        products.add(product);
        product.setShop(this);
    }
    public void deleteProduct(Product product){
        products.remove(product);
        product.setShop(null);
    }
}
