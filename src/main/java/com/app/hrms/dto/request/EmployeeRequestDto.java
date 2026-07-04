package com.app.hrms.dto.request;

import com.app.hrms.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRequestDto {
    @NotBlank
    private String employeeCode;

    @NotBlank
    private String firstName;
    private String lastName;

    @NotBlank
    @Email
    private String officeEmail;

    @Email
    private String personalEmail;

    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Mobile number should not exceeds 10 digits."
    )
    private String mobileNumber;

    private Gender gender;

    private LocalDate birthDate;

    private LocalDate joiningDate;

    private Long departmentId;

    private Long designationId;

    private Boolean isActive;

}
