package com.example.tp1.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements Serializable{

    @Serial
    private static final long serialVersionUID = -6998473273446847935L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Để id tự tăng ở phía DB, với .AUTO, sẽ tự tăng ở phía Java
    private Long id;

//    @Column(name = "userID")
//    private Long userID;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"application", "hibernateLazyInit"})
    private Users users;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "createDate")
    private Timestamp createDate;
}
