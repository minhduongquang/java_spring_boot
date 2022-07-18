package com.example.tp1.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailDto implements Serializable {

    private static final long serialVersionUID = -4879107258819494620L;

    private Long orderId;
    private Long productId;
    private String name;
    private Float price;
    private Integer quantity;
    private String imgUrl;
    private String slug;
}