package com.example1.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Buyer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyerID;
    private String buyerName;
    private String phone;
    private String email;
    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<Sale> sales;
}