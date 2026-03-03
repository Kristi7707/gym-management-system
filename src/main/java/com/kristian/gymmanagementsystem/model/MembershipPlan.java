package com.kristian.gymmanagementsystem.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "membership_plans")
public class MembershipPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private int durationDays;
    private String description;
}
