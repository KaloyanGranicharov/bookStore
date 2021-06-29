package com.kaloyanGranicharov.bookStore.converter;

import com.kaloyanGranicharov.bookStore.dto.RoleDto;
import com.kaloyanGranicharov.bookStore.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    public Role convertToEntity(RoleDto roleDto) {
        Role role = Role.builder()
                .id(roleDto.getId())
                .name(roleDto.getName())
                .build();
        return role;
    }

    public RoleDto convertToDto(Role role) {
        RoleDto roleDto = RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .build();

        return roleDto;
    }
}
