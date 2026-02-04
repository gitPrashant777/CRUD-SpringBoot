package com.crud.CRUD.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCT_MODEL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int price;
    private int stock;
    private String brand;
}
