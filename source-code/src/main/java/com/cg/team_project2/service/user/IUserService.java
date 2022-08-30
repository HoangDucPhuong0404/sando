package com.cg.team_project2.service.user;

import com.cg.team_project2.model.User;
import com.cg.team_project2.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> , UserDetailsService {
    User getByUsername(String username);

    Optional<User> findByUsername(String username);


}
