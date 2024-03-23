package com.Fastvan.Assignment.Fastvan.Assignment.Repository;

import com.Fastvan.Assignment.Fastvan.Assignment.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
