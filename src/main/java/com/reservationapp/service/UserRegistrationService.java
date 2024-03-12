package com.reservationapp.service;

import com.reservationapp.payload.UserRegistrationDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public interface UserRegistrationService {
    UserRegistrationDto createUser(UserRegistrationDto userRegistrationDto) ;

    UserRegistrationDto getUserById(long id);
}
