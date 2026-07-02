package com.app.hrms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "app_department")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "department_id")
    private Long departmentId;

    @Column(name ="department_code",nullable = false,unique = true, length = 10)
    private String departmentCode;

    @Column(name="department_name",nullable = false,unique = true,length =100)
    private String departmentName;

    @Builder.Default
    @Column (name="active")
    private Boolean active = true;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

}
