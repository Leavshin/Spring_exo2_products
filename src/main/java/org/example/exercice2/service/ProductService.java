package org.example.exercice2.service;

import org.example.exercice2.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class ProductService {

    private final Map<UUID, Product> products;

    public ProductService(){
        products = new HashMap<>();

        Product productA = Product.builder()
                .id(UUID.randomUUID())
                .name("Chocolat") //48090156-ec3a-4f67-87d3-71345b68060c
                .category("Epicerie")
                .price(2.50)
                .build();
        Product productB = Product.builder()
                .id(UUID.randomUUID())
                .name("Jus d'orange") //3da24c13-4a4a-4b70-8c1e-10eaf5e72e19
                .category("Boisson")
                .price(1.50)
                .build();
        Product productC = Product.builder()
                .id(UUID.randomUUID())
                .name("Gâteaux") //e4679867-1fd8-4802-a06d-e86953fcf9b0
                .category("Epicerie")
                .price(2.00)
                .build();

        products.put(productA.getId(),productA);
        products.put(productB.getId(),productB);
        products.put(productC.getId(),productC);
    }

    public List<Product> getAllProducts(){
        return products.values().stream().toList();
    }
    public Product getProductById(UUID id){
        return products.get(id);
    }

    public Product getProductByCategory(String category){
        return products.values().stream().filter(c -> c.getCategory().equals(category)).findAny().orElse(null);
    }

}
