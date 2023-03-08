package com.example.ApiProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiProject.Model.SessionUsers;
@Repository
public interface SessionUsersRepository extends JpaRepository<SessionUsers,Long> {
}
