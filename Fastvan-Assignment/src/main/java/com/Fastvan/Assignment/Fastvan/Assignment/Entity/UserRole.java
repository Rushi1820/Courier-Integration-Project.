package com.Fastvan.Assignment.Fastvan.Assignment.Entity;


import com.Fastvan.Assignment.Fastvan.Assignment.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

}
