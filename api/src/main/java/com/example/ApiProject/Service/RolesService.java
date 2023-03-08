package com.example.ApiProject.Service;

import com.example.ApiProject.Dto.PatientDto;
import com.example.ApiProject.Dto.RolesDto;
import com.example.ApiProject.Model.Patient;
import com.example.ApiProject.Model.Roles;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RolesService {


    public Roles createRole(RolesDto rolesDto);

    Roles updateRole(Long id, RolesDto rolesDto);

    void deleteRoleId(Long id);

    Optional<Roles> getRoleId(Long id);


    List<Roles> getRoles();

    void deleteRoles();
}
