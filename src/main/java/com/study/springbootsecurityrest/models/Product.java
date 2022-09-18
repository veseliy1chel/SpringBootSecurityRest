package com.study.springbootsecurityrest.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "shop_db")
public class Product {
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @NotEmpty(message = "Имя не должно быть пустым")
        @Size(min = 5, message = "Имя должно быть от 5 символов длиной")
        @Column(name = "name")
        private String name;

        @NotEmpty(message = "Address must be not null")
        @Size(min = 10,message = "Size must be more than 20 symbols")
        @Column(name = "description")
        private String description;

        @NotEmpty(message = "price must be not null")
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
