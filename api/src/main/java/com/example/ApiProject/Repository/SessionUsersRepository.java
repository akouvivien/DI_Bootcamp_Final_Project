package com.example.ApiProject.repository;

import com.example.ApiProject.model.SessionUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SessionUsersRepository extends JpaRepository<SessionUsers,Long> {
}
