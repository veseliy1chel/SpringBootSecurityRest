package com.study.springbootsecurityrest.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "product_db")
public class Product {
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @NotEmpty(message = "Name must be not empty")
        @Size(min = 5, message = "Name must be more than 5 symbols")
        @Column(name = "name")
        private String name;

        @NotEmpty(message = "Address must be not null")
        @Size(min = 10,message = "Description must be more than 10 symbols")
        @Column(name = "description")
        private String description;


        @Min(value = 0,message = "only positive num")
        @Column(name = "price")
        private int price;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="shop_id")
        private Shop shop;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        @Override
        public String toString() {
                return "Product{" +
                        "name='" + name + '\'' +
                        ", description='" + description + '\'' +
                        ", price=" + price +
                        '}';
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public int getPrice() {
                return price;
        }

        public void setPrice(int price) {
                this.price = price;
        }

        public Shop getShop() {
                return shop;
        }

        public void setShop(Shop shop) {
                this.shop = shop;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Product product = (Product) o;
                return getShop().equals(product.getShop());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getShop());
        }
}
