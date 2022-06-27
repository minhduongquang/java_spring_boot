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
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable{

    @Serial
    private static final long serialVersionUID = -8120510975169670298L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Để id tự tăng ở phía DB, với .AUTO, sẽ tự tăng ở phía Java
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "hashPassword")
    private String hashPassword;

    @Column(name = "email")
    private String email;

    @Column(name = "createDate")
//    private String createDate;
    private Timestamp createDate;

    @Column(name = "imgUrl")
    private String imgUrl;

//    @Column(name = "roleId")
//    private Long roleID;
    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"application", "hibernateLazyInit"})
    private Roles roles;

    @Column(name = "isDeleted")
    private boolean isDeleted;
}
