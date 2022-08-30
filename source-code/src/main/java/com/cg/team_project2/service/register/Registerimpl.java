package com.cg.team_project2.service.register;

import com.cg.team_project2.model.Register;
import com.cg.team_project2.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class Registerimpl implements IRegisterService {

   @Autowired
   private RegisterRepository registerRepository;


    @Override
    public List<Register> findAll() {
        return registerRepository.findAll();
    }

    @Override
    public Optional<Register> findById(Long id) {
        return registerRepository.findById(id);
    }

    @Override
    public Register getById(Long id) {
        return null;
    }

    @Override
    public Register save(Register register) {
        return registerRepository.save(register);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Optional<Register> findRegisterByUserName(String username) {
        return registerRepository.findByUserName(username);
    }
}
