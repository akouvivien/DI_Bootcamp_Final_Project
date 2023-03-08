package com.example.ApiProject.Service;

import com.example.ApiProject.Dto.LoginDto;
import com.example.ApiProject.Dto.SiginUpDto;
import com.example.ApiProject.Model.Users;

import org.springframework.stereotype.Service;


@Service
public interface UsersDetailsService {

    void registerUsers(SiginUpDto siginUpDto);

    Users authenticateUser(LoginDto loginDto);

    Users DecconectUsers (Long id);

}
