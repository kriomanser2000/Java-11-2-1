package com.example1.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Seller
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sellerID;
    private String sellerName;
    private String phone;
    private String email;
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Sale> sales;
}