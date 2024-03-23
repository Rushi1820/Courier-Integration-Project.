package com.Fastvan.Assignment.Fastvan.Assignment.Service;

import com.Fastvan.Assignment.Fastvan.Assignment.Entity.Order;
import com.Fastvan.Assignment.Fastvan.Assignment.Entity.TrackingInfoDTO;
import com.Fastvan.Assignment.Fastvan.Assignment.Entity.User;
import com.Fastvan.Assignment.Fastvan.Assignment.Enum.Role;
import com.Fastvan.Assignment.Fastvan.Assignment.Repository.OrderRepository;
import com.Fastvan.Assignment.Fastvan.Assignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private  OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;


    public Order createOrder(Order order) throws IllegalAccessException {
        User user = userRepository.findById(order.getUserId().getId())
                .orElseThrow(() -> new IllegalAccessException("User not found"));

        if (user.getRole().equals(Role.ADMIN) || user.getRole().equals(Role.CREATOR)) {
            order.setOrderDate(LocalDateTime.now());
            order.setCreatedAt(LocalDateTime.now());
            order.setEstimatedDelivery(LocalDateTime.now().plusDays(3));
            return orderRepository.save(order);
        } else {
            throw new IllegalAccessException("User does not have permission to create an order.");
        }
    }



    public Optional<List> getallorders() {
        Optional<List> orders = Optional.of(orderRepository.findAll());
        return orders;

    }

    public Optional<Order> getorderbyId(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order;

    }

    public Order upadateOrder(Long orderId, Order updatedOrder) throws IllegalAccessException {
        User user = userRepository.findById(updatedOrder.getUserId().getId())
                .orElseThrow(() -> new IllegalAccessException("User not found"));

        if (user.getRole().equals(Role.ADMIN) || user.getRole().equals(Role.CREATOR)) {
            Optional<Order> optionalOrder = orderRepository.findById(orderId);
            if (optionalOrder.isPresent()) {
                Order existingOrder = optionalOrder.get();

                if (updatedOrder.getSenderAddress() != null) {
                    existingOrder.setSenderAddress(updatedOrder.getSenderAddress());
                }
                if (updatedOrder.getRecipientAddress() != null) {
                    existingOrder.setRecipientAddress(updatedOrder.getRecipientAddress());
                }
                if (updatedOrder.getPackageWeight() != 0) {
                    existingOrder.setPackageWeight(updatedOrder.getPackageWeight());
                }
                if (updatedOrder.getPackageLength() != 0) {
                    existingOrder.setPackageLength(updatedOrder.getPackageLength());
                }
                if (updatedOrder.getPackageWidth() != 0) {
                    existingOrder.setPackageWidth(updatedOrder.getPackageWidth());
                }
                if (updatedOrder.getPackageHeight() != 0) {
                    existingOrder.setPackageHeight(updatedOrder.getPackageHeight());
                }
                if (updatedOrder.getOrderDate() != null) {
                    existingOrder.setOrderDate(updatedOrder.getOrderDate());
                }
                if (updatedOrder.getStatus() != null) {
                    existingOrder.setStatus(updatedOrder.getStatus());
                }
                if (updatedOrder.getUpdated_by() != null) {
                    existingOrder.setUpdated_by(updatedOrder.getUpdated_by());
                }
                if(updatedOrder.getUserId() != null){
                    existingOrder.setUserId((updatedOrder.getUserId()));
                }
                if (updatedOrder.getCurrentLocation() != null) {
                    existingOrder.setCurrentLocation(updatedOrder.getCurrentLocation());
                }
                Order aorder = optionalOrder.get();
                LocalDateTime creationTime = aorder.getCreatedAt();
                LocalDateTime updateTime = LocalDateTime.now();
                Duration timeDifference = Duration.between(creationTime, updateTime);

                LocalDateTime oldEstimatedDeliveryTime = aorder.getEstimatedDelivery();
                LocalDateTime newEstimatedDeliveryTime = oldEstimatedDeliveryTime.minus(timeDifference);

                aorder.setEstimatedDelivery(newEstimatedDeliveryTime);
                orderRepository.save(aorder);
                return orderRepository.save(existingOrder);
            } else {

                return null;
            }
        }
        return null;
    }

    public boolean deleteOrder(Long orderId,Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent() && (user.get().getRole().equals(Role.ADMIN) || user.get().getRole().equals(Role.CREATOR))) {
            Optional<Order> optionalOrder = orderRepository.findById(orderId);
            if (optionalOrder.isPresent()) {
                orderRepository.deleteById(orderId);
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public TrackingInfoDTO createTrackingInfo(Long orderId) {
        Optional<Order> orderID = orderRepository.findById(orderId);
        if (orderID.isPresent()) {
            Order order=orderID.get();
            TrackingInfoDTO trackingInfo = new TrackingInfoDTO();
            trackingInfo.setCurrentLocation(order.getCurrentLocation());
            trackingInfo.setEstimatedDeliveryTime(order.getEstimatedDelivery());
            trackingInfo.setStatus(order.getStatus());
            return trackingInfo;

        }
        return null;

    }
}
