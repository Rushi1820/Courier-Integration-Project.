package com.Fastvan.Assignment.Fastvan.Assignment.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_address_id", referencedColumnName = "address_id")
    private Address senderAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_address_id", referencedColumnName = "address_id")
    private Address recipientAddress;

    @Column(name = "package_weight")
    private double packageWeight;

    @Column(name = "package_length")
    private double packageLength;

    @Column(name = "package_width")
    private double packageWidth;

    @Column(name = "package_height")
    private double packageHeight;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name="Created_At")
    private LocalDateTime createdAt;

    @Column(name="Created_BY")
    private String created_by;

    @Column(name="Updated_by")
    private String updated_by;

    @Column(name = "status",nullable = false)
    private String status;

    @Column(name="Current Location")
    private String CurrentLocation;

    @Column(name="Estimated Delivery")
    private LocalDateTime  EstimatedDelivery;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User userId;
}
