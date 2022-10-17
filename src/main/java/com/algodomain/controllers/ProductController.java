package com.algodomain.controllers;

import com.algodomain.models.GetProduct;
import com.algodomain.models.Product;
import com.algodomain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;




    //for getting Product by id
    @GetMapping("/getProduct/{p_id}")
    public GetProduct getProduct(@PathVariable("p_id") int p_id){
        //System.out.println(p_id);
        return productService.getProduct(p_id);
    }

    //for getting list of products
    @GetMapping("/getProducts")
    public List<GetProduct>  getProducts(){
        return productService.getProducts();
    }

    //for adding Product
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }


    //for updating Product
    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }


    //for deleting Product
    @DeleteMapping("/deleteProduct/{p_id}")
    public String deleteProduct(@PathVariable("p_id") int p_id){
        System.out.println(p_id);
        return productService.deleteProduct(p_id);
    }
}
