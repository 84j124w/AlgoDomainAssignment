package com.algodomain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "dtc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DTCID;
    private String ProductCategory;
    private float Discount;
    private float GST;
    private float DeliveryCharges;

}
