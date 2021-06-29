package com.kaloyanGranicharov.bookStore.service;

import com.kaloyanGranicharov.bookStore.exception.DataNotFoundException;
import com.kaloyanGranicharov.bookStore.model.Role;
import com.kaloyanGranicharov.bookStore.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new DataNotFoundException(String.format("Role %s does not exist.", name)));
    }

    public Role findById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(String.format("Role with id %d does not exist.", id)));
    }

    public Set<Role> findAll() {
        List<Role> rolesList = roleRepository.findAll();
        Set<Role> roles = rolesList.stream().collect(Collectors.toSet());
        return roles;
    }

    public void deleteByName(String name) {
        roleRepository.deleteByName(name);
    }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
