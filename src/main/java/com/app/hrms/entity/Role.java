package com.app.hrms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "app_role")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name ="role_id")
    private Long roleId;

    @Column (name ="role_name", nullable=false, unique=true, length=50)
    private String roleName;

    @Builder.Default
    @Column (name="is_active", nullable = false)
    private Boolean isActive = true;

    @ManyToMany(mappedBy = "roles")// Join owned by USER Entity and here refers it by roles.
    private Set<User> users;
}
