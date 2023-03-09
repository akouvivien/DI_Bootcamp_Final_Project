package com.example.ApiProject.Controller;

import com.example.ApiProject.Dto.RolesDto;
import com.example.ApiProject.Model.Roles;
import com.example.ApiProject.Service.RolesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    RolesService rolesService;

    @GetMapping("")
    public ResponseEntity<List<Roles>> getALLRoles() {

        List<Roles> roles = rolesService.getRoles();

        return new ResponseEntity<>(roles, HttpStatus.OK);

    }

    @GetMapping("/{id}")

    public ResponseEntity<Roles> getroleById(@PathVariable("id") Long id) {

        Optional<Roles> rolesId = rolesService.getRoleId(id);

        return new ResponseEntity<>(rolesId.get(), HttpStatus.OK);
    }

    @PostMapping("")

    public ResponseEntity<Roles> createRoles(@Validated @RequestBody RolesDto rolesDto) {

        Roles roles = rolesService.createRole(rolesDto);

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PutMapping("/{id}")

    public ResponseEntity<Roles> updateRole(@PathVariable("id") long id, @RequestBody RolesDto rolesDto) {

        Roles newUpdateRoles = rolesService.updateRole(id,rolesDto);

        return new ResponseEntity<>(newUpdateRoles, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    //suppression en fonction de l'id
    public ResponseEntity<HttpStatus> deleteRole(@Validated @RequestBody @PathVariable("id") long id) {

        rolesService.deleteRoleId(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("")

    public ResponseEntity<HttpStatus> deleteAllSpeciality() {

        rolesService.deleteRoles();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
