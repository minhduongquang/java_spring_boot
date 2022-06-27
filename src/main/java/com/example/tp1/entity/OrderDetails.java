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
@Table(name = "order_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails implements Serializable{
    @Serial
    private static final long serialVersionUID = 6146239863359503778L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Để id tự tăng ở phía DB, với .AUTO, sẽ tự tăng ở phía Java
    private Long id;

//    @Column(name = "orderID")
//    private Long orderID;
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"application", "hibernateLazyInit"})
    private Orders orders;

//    @Column(name = "productID")
//    private Long productID;
    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"application", "hibernateLazyInit"})
    private Products products;

    @Column(name = "price")
    private Float price;

    @Column(name = "quantity")
    private Integer quantity;
}
