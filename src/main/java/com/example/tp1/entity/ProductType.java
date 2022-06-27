package com.example.tp1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductType implements Serializable {
    private static final long serialVersionUID = -3962651328129057602L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Để id tự tăng ở phía DB, với .AUTO, sẽ tự tăng ở phía Java
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "slug")
    private String slug;

    @Column(name = "isDeleted")
    private Boolean isDeleted;

//bi-directional mapping mapping 2 chiều
    //one directional mapping, mapping 1 chiều
//    @OneToMany(mappedBy = "productType")
//    private List<Products> productsList;
}
