package com.kofa.kofa.controlers;

import com.kofa.kofa.entities.Orders;
import com.kofa.kofa.entities.Product;
import com.kofa.kofa.repositories.OrderRepository;
import com.kofa.kofa.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/order")
public class OrderController {
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;


    OrderController(OrderRepository orderRepo,ProductRepository productRepo ){
        this.orderRepo=orderRepo;
        this.productRepo=productRepo;
    }
    @PostMapping("/new")
    public ResponseEntity<?> persistOrder(String name, String product, String clientTelNumber, String address){
        Orders newOrder = orderRepo.save(new Orders(name,clientTelNumber,address,product));

        return ResponseEntity.ok("Thank you " +newOrder.getFirstName()+". Your order id is: "+newOrder.getId()+".");
    }

//    @PostMapping("/new/many")
//    public ResponseEntity<?> persistOrders(String name, String products, String clientTelNumber, String address){
//        List<String> productsArray = Arrays.asList(products.split(","));
//        Set<Product> productsSet = new HashSet<>();
//        for(String product:productsArray){
//            if(productRepo.findByName(product)!=null){
//                productsSet.add(productRepo.findByName(product));
//            }
//            else{return ResponseEntity.ok("No such product!");}
//        }
//        Orders newOrder = orderRepo.save(new Orders(name,clientTelNumber,address,productsSet));
//
//        return ResponseEntity.ok("Thank you " +newOrder.getFirstName()+". Your order id is: "+newOrder.getId()+".");
//    }
}
