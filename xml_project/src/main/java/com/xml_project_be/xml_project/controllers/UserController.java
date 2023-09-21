package com.xml_project_be.xml_project.controllers;

import com.xml_project_be.xml_project.dao.UserDao;
import com.xml_project_be.xml_project.dto.UserFilterDTO;
import com.xml_project_be.xml_project.models.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    @GetMapping("/test")
    public ResponseEntity<?> Test(){
        return ResponseEntity.ok("Successful");
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    @PostMapping("/filter")
    @PreAuthorize("hasAuthority('admin:read')")
    public List<User> getAllUsersByFilter(@RequestBody UserFilterDTO userFilterDTO){
        return userDao.filter(
                userFilterDTO.getFirstName(),
                userFilterDTO.getLastName(),
                userFilterDTO.getSecondName(),
                userFilterDTO.getLogin(),
                userFilterDTO.getEmail(),
                userFilterDTO.getRole(),
                userFilterDTO.getState(),
                userFilterDTO.getPhoneNumber()
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:read')")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userDao.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<?> createNewUser(@RequestBody @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return new ResponseEntity<>(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage(), HttpStatus.FORBIDDEN);
        userDao.save(user);
        return ResponseEntity.ok("Successful create");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        userDao.deleteById(id);
        return ResponseEntity.ok("Successful delete");
    }

    @GetMapping("/login")
    @PreAuthorize("hasAuthority('admin:read')")
    public Optional<User> gtUserByLogin(@RequestParam(name = "login") String login){
        return userDao.findByLogin(login);
    }
}
