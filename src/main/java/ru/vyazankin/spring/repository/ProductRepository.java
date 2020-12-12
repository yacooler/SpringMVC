package ru.vyazankin.spring.repository;

import org.springframework.stereotype.Component;
import ru.vyazankin.spring.entity.Product;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductRepository {
    public List<Product> getProducts();
    public Optional<Product> findProductByID(int id);
    public void addProduct(Product product);
    public void deleteProduct(Product product);
    public void deleteProductByID(int ID);
}
