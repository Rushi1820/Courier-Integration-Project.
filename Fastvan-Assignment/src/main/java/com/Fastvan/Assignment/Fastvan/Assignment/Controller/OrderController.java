package com.Fastvan.Assignment.Fastvan.Assignment.Controller;

import com.Fastvan.Assignment.Fastvan.Assignment.Entity.Order;
import com.Fastvan.Assignment.Fastvan.Assignment.Entity.TrackingInfoDTO;
import com.Fastvan.Assignment.Fastvan.Assignment.Entity.User;
import com.Fastvan.Assignment.Fastvan.Assignment.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ontrac/orders")
public class OrderController {
    @Autowired
    private  OrderService orderService;


    @PostMapping("/createorder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            Order createdOrder = orderService.createOrder(order);
            return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getallorders")
    public Optional<List> getallorders(){
        Optional<List> orders= orderService.getallorders();
        return orders;
    }

    @GetMapping("/getorderbyId/{orderId}")
    public Optional<Order> getorderByID(@PathVariable Long orderId) {
        Optional<Order> order = orderService.getorderbyId(orderId);
        return order;
    }

    @PutMapping("/updateOrderByID/{orderId}")
    public Order updateorderById(@PathVariable Long orderId, @RequestBody Order order) throws IllegalAccessException {
        Order updateorder= orderService.upadateOrder(orderId, order);
        return updateorder;
    }

    @DeleteMapping("/deleteOrderByID/{orderId}")
    public ResponseEntity<String> deleteOrderById(@PathVariable Long orderId,@RequestParam("userId") Long userId) {
        boolean deleted = orderService.deleteOrder(orderId,userId);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        }
    }
    @GetMapping("/getTrackingInfoByID/{orderId}")
    public TrackingInfoDTO TrackingInfo(@PathVariable Long orderId){
        return orderService.createTrackingInfo(orderId);
    }

}
