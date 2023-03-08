package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.Roles;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
     Optional<Roles> findByName(String name);
}
