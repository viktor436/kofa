package com.kofa.kofa.controlers;

import com.kofa.kofa.entities.Orders;
import com.kofa.kofa.entities.Product;
import com.kofa.kofa.repositories.OrderRepository;
import com.kofa.kofa.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository productRepo;

    ProductController(ProductRepository productRepo ){
        this.productRepo=productRepo;
    }
    @PostMapping("/new")
    public ResponseEntity<?> persistProduct(String name, Float price, String description, String imageLink){
        Product newProduct = productRepo.save(new Product(name,price,description,imageLink));

        return ResponseEntity.ok("Thank you " +newProduct.getName()+" was saved successfully to our database with product id="+newProduct.getId()+". Your product should be listed at Kofa.Bg after short review from our moderation team.");
    }
}
