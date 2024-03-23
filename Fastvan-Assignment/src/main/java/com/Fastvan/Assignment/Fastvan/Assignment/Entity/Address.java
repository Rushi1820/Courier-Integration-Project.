package com.Fastvan.Assignment.Fastvan.Assignment.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="address_id")
    private Long AddressID;

    @Column(name="Name")
    private String Name;

    @Column(name = "MainAddress")
    private String MainAddress;

    @Column(name = "Landmark")
    private String landmark;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode", nullable = false, length = 5)
    private Integer pincode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "phno")
    private String phonenum;
}