package org.example.test2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private long price;

    @Column(name = "date")
    private Date date;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "textureId")
    private Long textureId;

    private Long workshopId;
}

