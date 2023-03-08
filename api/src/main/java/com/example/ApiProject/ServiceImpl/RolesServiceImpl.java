package com.example.ApiProject.serviceImpl;

import com.example.ApiProject.Dto.RolesDto;
import com.example.ApiProject.Model.Roles;
import com.example.ApiProject.Repository.RolesRepository;
import com.example.ApiProject.Service.RolesService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesServiceImpl  implements RolesService {

    @Autowired
    RolesRepository rolesRepo;

    @Override
    public Roles createRole(RolesDto rolesDto) {

        Roles addRoles = new Roles();

        addRoles.setName(rolesDto.getName());

        rolesRepo.save(addRoles);

        return addRoles;
    }



    @Override
    public Roles updateRole(Long id, RolesDto rolesDto) {

        Roles rolesToUpdate = rolesRepo.findById(id).orElse(null);

        if(rolesToUpdate !=null){

            BeanUtils.copyProperties(rolesRepo, rolesToUpdate, "id");

            rolesRepo.save(rolesToUpdate);
        }
        return rolesRepo.save(rolesToUpdate);
    }



    @Override
    public void deleteRoleId(Long id) {

        rolesRepo.deleteById(id);

    }

    @Override
    public Optional<Roles> getRoleId(Long id) {

        Optional<Roles> roleid = rolesRepo.findById(id);

        return roleid;
    }

    @Override
    public List<Roles> getRoles() {

        return  rolesRepo.findAll();
    }

    @Override
    public void deleteRoles() {

        rolesRepo.deleteAll();

    }
}
