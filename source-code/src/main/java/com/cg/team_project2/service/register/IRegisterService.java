package com.cg.team_project2.service.register;

import com.cg.team_project2.model.Register;
import com.cg.team_project2.service.IGeneralService;

import java.util.Optional;

public interface IRegisterService extends IGeneralService<Register> {
    Optional<Register> findRegisterByUserName(String username);


}
