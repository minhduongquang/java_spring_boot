package com.example.tp1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products implements Serializable{

    @Serial
    private static final long serialVersionUID = -1313386128805182984L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Để id tự tăng ở phía DB, với .AUTO, sẽ tự tăng ở phía Java
    private Long id;

    @Column(name = "name")
    private String name;

// mapping các thuộc tính có khóa ngoại
//    @Column(name = "typeID")
//    private Long typeID;
    @ManyToOne
    @JoinColumn(name = "typeId", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"application", "hibernateLazyInit"})
    private ProductType productType;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Float price;

//    @Column(name = "unitID")
//    private Long unitID;
    @ManyToOne
    @JoinColumn(name = "unitId", referencedColumnName = "id")
//    @JsonIgnoreProperties(value = {"application", "hibernateLazyInit"})
    private UnitType unitType;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "slug")
    private String slug;

    @Column(name = "isDeleted")
    private Boolean isDeleted;
}
