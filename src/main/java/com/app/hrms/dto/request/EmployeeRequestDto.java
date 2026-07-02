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

    @NotBlank
    @Email
    private String personalEmail;

    @NotBlank
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Mobile number should not exceeds 10 digits."
    )
    private String mobileNumber;
    @NotNull
    private Gender gender;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private LocalDate joiningDate;
    @NotNull
    private Long departmentId;
    @NotNull
    private Long designationId;

}
