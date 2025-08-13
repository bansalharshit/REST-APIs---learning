package com.bansalharshit.springboot.Learning.Rest.APIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentRequestDto {

    @NotBlank(message = "name should not be blank")
    @Size(min = 3,max = 30,message = "name size should be 3 to 30 characters")
    private String name;

    @Email
    @NotBlank(message = "Email Should not be blank")
    private String email;
}
