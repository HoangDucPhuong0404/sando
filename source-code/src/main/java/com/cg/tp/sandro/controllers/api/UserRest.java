//package com.cg.team_project2.controller.api;
//
//import com.cg.team_project2.exception.DataInputException;
//import com.cg.team_project2.model.Register;
//import com.cg.team_project2.service.register.IRegisterService;
//import com.cg.team_project2.utils.AppUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import javax.xml.ws.Response;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/auth")
//public class UserRest {
//
//    @Autowired
//    private IRegisterService registerService;
//
//    @Autowired
//    private AppUtils appUtils;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//
//    @PostMapping("/login")
//    public Response<?> login(){
//
//    }
//
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@Valid @RequestBody Register register, BindingResult bindingResult){
//        if (bindingResult.hasErrors()) {
//            return appUtils.mapErrorToResponse(bindingResult);
//        }
//        Optional<Register> registerOptional = registerService.findRegisterByUserName(register.getUserName());
//            if (registerOptional.isPresent()){
//                return new ResponseEntity<>("Email already Exists", HttpStatus.CONFLICT);
//            }
//        try {
//            registerService.save(register);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        }catch (DataIntegrityViolationException e){
//            throw new DataInputException("Account information is not valid, please check the information again");
//        }
//    }
//
//
//}
