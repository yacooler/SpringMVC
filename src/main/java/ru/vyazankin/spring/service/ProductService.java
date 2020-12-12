package ru.vyazankin.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vyazankin.spring.entity.Product;
import ru.vyazankin.spring.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.getProducts();
    }

    public Optional<Product> getProductByID(int id){
        return productRepository.findProductByID(id);
    }

    public void addProduct(Product product){
        productRepository.addProduct(product);
    }

    public void deleteProduct(Product product){
        productRepository.deleteProduct(product);
    }

    public void deleteProductByID(int ID){
        productRepository.deleteProductByID(ID);
    }


}
