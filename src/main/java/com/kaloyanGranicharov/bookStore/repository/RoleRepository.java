package com.kaloyanGranicharov.bookStore.repository;

import com.kaloyanGranicharov.bookStore.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);

    Optional<Role> findById(Long id);

    void deleteByName(String name);

}
