package com.Fastvan.Assignment.Fastvan.Assignment.Entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackingInfoDTO {
    private String currentLocation;
    private LocalDateTime estimatedDeliveryTime;
    private String status;
}

