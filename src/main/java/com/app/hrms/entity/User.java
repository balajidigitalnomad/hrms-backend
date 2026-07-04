package com.app.hrms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "app_user")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "User name required.")
    @Size(max = 150, message = "User name should not exceeds 150 Characters.")
    @Email(message = "Invalid user name / personal email id here.")
    @Column(name = "username", nullable = false, length = 150, unique = true)
    private String username;

    @NotBlank(message = "Password required here.")
    @Size(max = 255, message = "Valid Password required.")
    @Column(name ="password", nullable = false, length = 255)
    private String password;

    @Builder.Default
    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;

    @Builder.Default
    @Column(name = "account_non_locked", nullable = false)
    private Boolean accountNonLocked = true;

    @Builder.Default
    @Column(name = "account_non_expired", nullable = false)
    private Boolean accountNonExpired = true;

    @Builder.Default
    @Column(name = "credentials_non_expired", nullable = false)
    private Boolean credentialsNonExpired = true;

    @Column(name = "employee_id")
    private Long employeeId;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "app_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @Builder.Default
    @Column(name= "is_active", nullable = false)
    private Boolean isActive = true;
}
