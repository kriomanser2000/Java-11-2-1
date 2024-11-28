package com.example1.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Sale
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int saleID;
    private String productName;
    private double salePrice;
    @Temporal(TemporalType.DATE)
    private Date saleDate;
    @ManyToOne
    @JoinColumn(name = "sellerID")
    private Seller seller;
    @ManyToOne
    @JoinColumn(name = "buyerID")
    private Buyer buyer;
}