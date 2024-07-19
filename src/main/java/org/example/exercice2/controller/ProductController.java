package org.example.exercice2.controller;


import org.example.exercice2.model.Product;
import org.example.exercice2.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String homePage(){
        return "welcome";
    }

    @GetMapping("/detail/{productId}")
    public String detailPage(@PathVariable("productId") UUID productId, Model model){
        Product product = productService.getProductById(productId);
        model.addAttribute("product",product);
        return "detailsProduct";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products",products);
        return "products";
    }

    @GetMapping("/search") // search?productCategory=Epicerie
    public String showContact(@RequestParam(value = "productCategory",required = false) String category,Model model){
        Product product = productService.getProductByCategory(category);
        if (product != null){
            model.addAttribute("product",product);
            return "detailsProduct";
        }else {
            return "welcome";
        }

    }



}
