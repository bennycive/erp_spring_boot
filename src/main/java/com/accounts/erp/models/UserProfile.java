package com.accounts.erp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "user_profiles",
        uniqueConstraints = @UniqueConstraint(columnNames = "phoneNumber")
)
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    // Ensure phoneNumber is unique and required for each user
    @Column(unique = true)
    private String phoneNumber;

    private String gender;

    private LocalDate dateOfBirth;

    private String nationality;

    private String profileImageUrl;

    // Relation: One User can have one profile
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}
