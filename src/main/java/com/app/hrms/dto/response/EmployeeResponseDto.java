package com.app.hrms.dto.response;

import com.app.hrms.enums.Gender;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponseDto {
    private Long id;
    private String employeeCode;
    private String firstName;
    private String lastName;
    private String officeEmail;
    private String personalEmail;
    private String mobileNumber;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate joiningDate;
    private Long departmentId;
    private String departmentName;
    private Long designationId;
    private String designationName;
    private Boolean active;


}
