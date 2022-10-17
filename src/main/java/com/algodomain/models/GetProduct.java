package com.algodomain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GetProduct {
    private int productId;
    private String name;
    private String productType;
    private String category;
    private float basePrice;
    private float discount;
    private Map<String, Float> charges = new LinkedHashMap<>();
    private float finalPrice;


}
