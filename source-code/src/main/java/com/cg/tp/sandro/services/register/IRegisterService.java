package com.cg.tp.sandro.services.register;

import com.cg.team_project2.model.Register;
import com.cg.tp.sandro.services.IGeneralService;

import java.util.Optional;

public interface IRegisterService extends IGeneralService<Register> {
    Optional<Register> findRegisterByUserName(String username);


}
