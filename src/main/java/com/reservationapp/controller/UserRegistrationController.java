package com.reservationapp.controller;

import com.reservationapp.payload.UserRegistrationDto;
import com.reservationapp.service.UserRegistrationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/user")
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/save")
    public ResponseEntity<UserRegistrationDto> createUser(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("profilePicture") MultipartFile profilePicture
            ) throws Exception{

        UserRegistrationDto registrationDto = new UserRegistrationDto();
        registrationDto.setName(name);
        registrationDto.setEmail(email);
        registrationDto.setPassword(password);
        registrationDto.setProfilePicture(profilePicture.getBytes());

        UserRegistrationDto dto = userRegistrationService.createUser(registrationDto);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRegistrationDto> gtUserById(@PathVariable long id){
        UserRegistrationDto dto = userRegistrationService.getUserById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
