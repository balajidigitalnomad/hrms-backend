package com.app.hrms.entity;

import com.app.hrms.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "app_employee")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"department","designation"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @NotBlank(message = "Employee code required.")
    @Size(max = 20, message = "Employee code should not exceeds 20 Characters.")
    @Pattern(
            regexp = "^EMP\\d{6}$",
            message = "Employee code should follow the pattern EMP000001"
    )
    @Column(name = "employee_code", nullable=false, unique = true, length = 20)
    private String employeeCode;

    @NotBlank(message = "Employee First name required.")
    @Size(max = 150, message = "Employee First name should not exceeds 150 Characters.")
    @Column(name = "first_name", nullable = false, length = 150)
    private String firstName;

    @Size(max = 150, message = "Employee Last name should not exceeds 150 Characters.")
    @Column(name = "last_name", length = 150)
    private String lastName;

    @NotBlank(message = "Official email required.")
    @Email(message = "Invalid Official email.")
    @Column(name = "office_email", nullable = false, length = 150, unique = true)
    private String officeEmail;

    @NotBlank(message = "Personal email required.")
    @Email(message = "Invalid Personal email.")
    @Column(name = "personal_email", nullable = false, length = 150, unique = true)
    private String personalEmail;

    @NotBlank(message = "Mobile number required.")
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Mobile number should contains 10 digits"
    )
    @Column(name = "mobile_number", nullable = false, length = 10, unique = true)
    private String mobileNumber;


    @NotNull(message = "Gender required.")
    @Enumerated(EnumType.STRING)
    @Column(name ="gender", nullable = false)
    private Gender gender;

    @NotNull(message = "Employee Birth date required.")
    @Past
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NotNull(message = "Employee Joining date required.")
    @PastOrPresent
    @Column(name = "joining_date", nullable = false)
    private LocalDate joiningDate;

    @Builder.Default
    @Column(name="active",nullable = false)
    private Boolean active = true;

    @NotNull(message = "Employee department is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",  nullable = false)
    private Department department;

    @NotNull(message = "Employee designation is required.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "designation_id", nullable = false)
    private Designation designation;

    @OneToOne(mappedBy = "employee")
    private User user;
}

