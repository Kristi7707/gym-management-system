package com.kristian.gymmanagementsystem.model;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Data
@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String membershipType;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
}
