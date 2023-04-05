package com.kofa.kofa.repositories;

import com.kofa.kofa.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
