package com.example.ApiProject.repository;

import com.example.ApiProject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByLoginAndMdPasse(String login, String mdPasse);

    Boolean existsByLogin(String login);
    Boolean existsByEmail(String email);
}
