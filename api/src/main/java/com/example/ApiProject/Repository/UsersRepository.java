package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.Users;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByLoginAndMdPasse(String login, String mdPasse);

    Boolean existsByLogin(String login);
    Boolean existsByEmail(String email);
}
