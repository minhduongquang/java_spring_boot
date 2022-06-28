package com.example.tp1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "unit_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnitType implements Serializable {
    private static final long serialVersionUID = 3_962_651_328_129_056_098L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Để id tự tăng ở phía DB, với .AUTO, sẽ tự tăng ở phía Java
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "isDeleted")
    private Boolean isDeleted;

}
