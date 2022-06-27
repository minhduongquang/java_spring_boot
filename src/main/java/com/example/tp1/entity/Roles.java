package com.example.tp1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roles implements Serializable{

    @Serial
    private static final long serialVersionUID = 3475666825724684993L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Để id tự tăng ở phía DB, với .AUTO, sẽ tự tăng ở phía Java
    private Long id;

    @Column(name = "description")
    private String description;

}
