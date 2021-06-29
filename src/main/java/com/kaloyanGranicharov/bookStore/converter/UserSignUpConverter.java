package com.kaloyanGranicharov.bookStore.converter;

import com.kaloyanGranicharov.bookStore.dto.UserSignUpDto;
import com.kaloyanGranicharov.bookStore.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserSignUpConverter {

    public User convertToEntity(UserSignUpDto userSignUpDto) {
        User user = User.builder()
                .email(userSignUpDto.getEmail())
                .username(userSignUpDto.getUsername())
                .firstName(userSignUpDto.getFirstName())
                .lastName(userSignUpDto.getLastName())
                .age(userSignUpDto.getAge())
                .build();
        return user;
    }


}
