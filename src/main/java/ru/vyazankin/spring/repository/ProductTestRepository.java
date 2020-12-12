package ru.vyazankin.spring.repository;

import org.springframework.stereotype.Component;
import ru.vyazankin.spring.entity.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;


@Component
public class ProductTestRepository implements ProductRepository {

    private List<Product> products;

    @PostConstruct
    private void initList(){
        products = new ArrayList<>();

        products.add(new Product(1, "Монитор 23'", BigDecimal.valueOf(8700)));
        products.add(new Product(2, "Монитор 34'", BigDecimal.valueOf(28900)));
        products.add(new Product(3, "Материнская плата + Celeron", BigDecimal.valueOf(6800)));
        products.add(new Product(4, "Материнская плата + Ryzen", BigDecimal.valueOf(15400)));
        products.add(new Product(5, "Материнская плата + Xeon с Али", BigDecimal.valueOf(4200)));
        products.add(new Product(6, "Плашка DDR3 8gb", BigDecimal.valueOf(3700)));
        products.add(new Product(7, "Плашка DDR4 8gb", BigDecimal.valueOf(6500)));
        products.add(new Product(8, "Клавиатура и мышь беспроводные, комплект", BigDecimal.valueOf(4300)));
        products.add(new Product(9, "Клавиатура механическая", BigDecimal.valueOf(9200)));
        products.add(new Product(10, "Мышь игровая", BigDecimal.valueOf(17000)));
        products.add(new Product(11, "Корпус с блоком питания 500W", BigDecimal.valueOf(6000)));
        products.add(new Product(12, "Корпус с блоком питания 800W игровой", BigDecimal.valueOf(11000)));
    }

    @Override
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Optional<Product> findProductByID(int id) {
        for (Product pr: products) {
            if (pr.getId() == id) return Optional.of(pr);
        }
        return Optional.empty();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void deleteProduct(Product product){
        products.remove(product);
    }

    @Override
    public void deleteProductByID(int ID){
        products.removeIf(product -> product.getId() == ID);
    }
}
