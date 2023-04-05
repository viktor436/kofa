package com.kofa.kofa.controlers;

import com.kofa.kofa.entities.Comment;
import com.kofa.kofa.entities.Product;
import com.kofa.kofa.repositories.CommentRepository;
import com.kofa.kofa.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/comment")
public class CommentController {
    private final CommentRepository commentRepo;
    private final ProductRepository productRepo;
    CommentController(CommentRepository commentRepo,ProductRepository productRepo){
        this.commentRepo=commentRepo;
        this.productRepo=productRepo;
    }

    @GetMapping("/all")
    public List<Comment> getAllComments(String productName){
        return commentRepo.findAllByProductName(productName);
        //return commentRepo.findAll();
    }

    @PostMapping("/new")
    public ResponseEntity<?> persistComment(String comment,String productName){
        Product product = productRepo.findByName(productName);
        Comment newComment = commentRepo.save(new Comment(comment, product));
        if(newComment==null){
            return  ResponseEntity.ok("Comment is blank!");
        }
        return  ResponseEntity.ok("Comment saved!");
    }
}
