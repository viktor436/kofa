package com.kofa.kofa.entities;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Comment() {
    }

    public Comment(String comment,Product product) {
        this.comment = comment;
        this.product=product;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
