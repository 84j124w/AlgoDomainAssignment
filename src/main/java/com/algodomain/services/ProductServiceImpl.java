package com.algodomain.services;

import com.algodomain.models.DTC;
import com.algodomain.models.GetProduct;
import com.algodomain.models.Product;
import com.algodomain.repos.DTCRepo;
import com.algodomain.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepo productRepo;
    @Autowired
    DTCRepo dtcRepo;

    @Override
    public Product addProduct(Product p) {
        Product product = null;
        try{
            product = productRepo.save(p);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product updateProduct(Product p) {
        Product product = null;
        try{
            Product oldProduct = productRepo.findById(p.getProductID()).get();
            oldProduct.setProductName(p.getProductName());
            oldProduct.setProductPrice(p.getProductPrice());
            oldProduct.setProductType(p.getProductType());
            oldProduct.setProductCategory(p.getProductCategory());
            product = productRepo.save(oldProduct);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<GetProduct> getProducts() {
        List<GetProduct> getProductList = new ArrayList<GetProduct>();

        try{
            List<Integer> p_ids = productRepo.findAll().stream().map( e-> e.getProductID()).collect(Collectors.toList());
            p_ids.forEach((e) -> {
                getProductList.add(getProduct(e));
            });

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return getProductList;
    }

    @Override
    public GetProduct getProduct(int p_id) {
        GetProduct getProduct = new GetProduct();
        try{
            Product product = productRepo.findById(p_id).get();
            DTC dtc = dtcRepo.getDTCByCategory(product.getProductCategory());
            getProduct.setProductId(product.getProductID());
            getProduct.setName(product.getProductName());
            getProduct.setProductType(product.getProductType());
            getProduct.setCategory(product.getProductCategory());
            getProduct.setBasePrice(product.getProductPrice());
            float productPrice = product.getProductPrice();
            float discount = dtc.getDiscount();
            float finalDiscountPrice = (productPrice*discount)/100;
            getProduct.setDiscount(finalDiscountPrice);

            float productGst = dtc.getGST();
            float priceAfterDiscount = (productPrice - finalDiscountPrice);
            float gstPrice = (priceAfterDiscount*productGst)/100;

            Map<String, Float> charges = new LinkedHashMap<>();
            charges.put("gst",gstPrice);
            charges.put("delivery",dtc.getDeliveryCharges());
            getProduct.setCharges(charges);

            float productFinalPrice = priceAfterDiscount+gstPrice+dtc.getDeliveryCharges();
            getProduct.setFinalPrice(productFinalPrice);



        }
        catch (Exception e){
            e.printStackTrace();
        }
        return getProduct;
    }

    @Override
    public String deleteProduct(int id) {
        String msg = "There is some server Error!";
        try{
            Product product = productRepo.findById(id).get();
            productRepo.delete(product);
            msg = "Product delete successfully!";
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return msg;
    }
}
