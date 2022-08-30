package com.cg.team_project2.repository;

import com.cg.team_project2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User getByUsername(String username);

    Optional<User> findByUsername(String username);
}
