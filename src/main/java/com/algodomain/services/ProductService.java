package com.algodomain.services;

import com.algodomain.models.GetProduct;
import com.algodomain.models.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product p);
    public Product updateProduct(Product p);
    public List<GetProduct> getProducts();
    public GetProduct getProduct(int p_id);
    public String deleteProduct(int id);
}
