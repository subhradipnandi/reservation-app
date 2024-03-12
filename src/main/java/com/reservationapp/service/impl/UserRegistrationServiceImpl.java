package com.reservationapp.service.impl;

import com.reservationapp.entity.UserRegistration;
import com.reservationapp.payload.UserRegistrationDto;
import com.reservationapp.repository.DriverRepository;
import com.reservationapp.repository.UserRegistrationRepository;
import com.reservationapp.service.UserRegistrationService;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserRegistrationDto createUser(UserRegistrationDto userRegistrationDto) {

        @Valid
        UserRegistration userRegistration = mapToEntity(userRegistrationDto);


        UserRegistration savedUser = userRegistrationRepository.save(userRegistration);

        return mapToDto(savedUser);

    }

    @Override
    public UserRegistrationDto getUserById(long id) {
        UserRegistration userRegistration = userRegistrationRepository.findById(id).get();
        return mapToDto(userRegistration);
    }

    public UserRegistration mapToEntity(UserRegistrationDto dto){
        return modelMapper.map(dto, UserRegistration.class);
    }

    public UserRegistrationDto mapToDto(UserRegistration userRegistration){
        UserRegistrationDto dto = modelMapper.map(userRegistration, UserRegistrationDto.class);
        dto.setPassword(null);
        return dto;
    }

}
