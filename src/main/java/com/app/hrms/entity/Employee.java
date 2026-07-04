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
    private Long employeeId;

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

    @Email(message = "Invalid Personal email.")
    @Column(name = "personal_email", nullable = false, length = 150, unique = true)
    private String personalEmail;

    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Mobile number should contains 10 digits"
    )
    @Column(name = "mobile_number", nullable = false, length = 10, unique = true)
    private String mobileNumber;

    @Enumerated(EnumType.STRING)
    @Column(name ="gender")
    private Gender gender;

    @Past
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @PastOrPresent
    @Column(name = "joining_date")
    private LocalDate joiningDate;

    @Builder.Default
    @Column(name="is_active")
    private Boolean isActive = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "designation_id")
    private Designation designation;


}

