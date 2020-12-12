package ru.vyazankin.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vyazankin.spring.entity.Product;
import ru.vyazankin.spring.service.ProductService;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("products", productService.getProducts());
        return "all";
    }

    @GetMapping("/edit")
    public String edit(Model model){
        model.addAttribute("products", productService.getProducts());
        return "edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(Model model, @PathVariable Integer id){
        productService.deleteProductByID(id);
        return "redirect:/edit";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute Product product){
        productService.addProduct(product);
        return "redirect:/edit";
    }

}
