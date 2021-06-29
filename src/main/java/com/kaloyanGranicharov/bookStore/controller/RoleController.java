package com.kaloyanGranicharov.bookStore.controller;


import com.kaloyanGranicharov.bookStore.converter.RoleConverter;
import com.kaloyanGranicharov.bookStore.dto.RoleDto;
import com.kaloyanGranicharov.bookStore.model.Role;
import com.kaloyanGranicharov.bookStore.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    private final RoleService roleService;
    private final RoleConverter roleConverter;

    public RoleController(RoleService roleService, RoleConverter roleConverter) {
        this.roleService = roleService;
        this.roleConverter = roleConverter;
    }

    @GetMapping
    public ResponseEntity<Set<RoleDto>> findAll(){
        Set<Role> roles = roleService.findAll();
        Set<RoleDto> rolesDto = new HashSet<>();
        for (Role role : roles){
            RoleDto roleDto = roleConverter.convertToDto(role);
            rolesDto.add(roleDto);
        }

        return ResponseEntity.ok(rolesDto);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<RoleDto> findByName(@PathVariable String name){
        Role role = roleService.findByName(name);
        RoleDto roleDto = roleConverter.convertToDto(role);
        return ResponseEntity.ok(roleDto);
    }




}
