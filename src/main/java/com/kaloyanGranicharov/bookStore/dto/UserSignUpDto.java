package com.kaloyanGranicharov.bookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignUpDto {

    private String email;

    private String username;

    private String firstName;

    private String lastName;

    private Integer age;

}
