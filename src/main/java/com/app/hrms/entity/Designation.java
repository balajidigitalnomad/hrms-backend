package com.app.hrms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "app_designation")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "designation_id")
    private Long designationId;

    @Column (name ="designation_code", nullable=false, unique=true, length=10)
    private String designationCode;

    @Column (name = "designation_name", nullable=false, unique=true, length=100)
    private String designationName;

    @Builder.Default
    @Column (name = "active")
    private Boolean active =  true;

    @OneToMany(mappedBy = "designation")
    private Set<Employee> employees;

}
