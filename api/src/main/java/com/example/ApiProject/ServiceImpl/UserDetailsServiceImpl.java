package com.example.ApiProject.serviceImpl;

import com.example.ApiProject.Dto.LoginDto;
import com.example.ApiProject.Dto.SiginUpDto;
import com.example.ApiProject.Enums.SessionType;
import com.example.ApiProject.Model.*;
import com.example.ApiProject.Repository.RolesRepository;
import com.example.ApiProject.Repository.SessionUsersRepository;
import com.example.ApiProject.Repository.UsersRepository;
import com.example.ApiProject.Service.UsersDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UsersDetailsService {

    @Autowired
    UsersRepository usersRepo;

    @Autowired
    RolesRepository rolesRepo;

    @Autowired
    SessionUsersRepository sessionUsersRepo;
    @Override
    public void registerUsers(SiginUpDto signUpDto) {


        //verifie si l'utilisateur existe deja
        Boolean usersLogin = usersRepo.existsByLogin(signUpDto.getLogin());

        if (usersLogin) throw new ApplicationContextException("ce utilisateur existe deja");

        // verifie l'email dans la bd
        Boolean usersemail = usersRepo.existsByEmail(signUpDto.getEmail());

        if (usersemail) throw new ApplicationContextException("ce email est deja utiliser ");


        // create Patient
        Patient patient = new Patient();

        patient.setFirst_name(signUpDto.getFirst_name());

        patient.setLast_name(signUpDto.getLast_name());

        patient.setLogin(signUpDto.getLogin());

        patient.setMdPasse(signUpDto.getMdPasse());

        patient.setPhone_number(signUpDto.getPhone_number());

        patient.setAdresse(signUpDto.getAdresse());

        Roles roles = rolesRepo.findByName("Patient").get();

        patient.setRoles(roles);

        usersRepo.save(patient);

    }

//gestion de la connection

    @Override
    public Users authenticateUser(LoginDto loginDto) {

        Optional<Users> users = usersRepo.findByLoginAndMdPasse(loginDto.getLogin(), loginDto.getPassword());

        if (users.isPresent()){

            SessionUsers sessionUsers = new SessionUsers(SessionType.CONNECT);

            sessionUsersRepo.save(sessionUsers);

            return users.get();

        } else {

            throw  new ApplicationContextException("User not found");

        }


    }

//Gestion de la deconnection a rectifier

    @Override
    public Users DecconectUsers(Long id) {

        Optional<Users> users = usersRepo.findById(id);

        if (users.isPresent()){

            SessionUsers sessionUsers = new SessionUsers(SessionType.DISCONNECT);

            sessionUsersRepo.save(sessionUsers);

            return users.get();

        } else {

            throw  new ApplicationContextException("Utilisateur non trouvé");

        }

    }


}
