package com.reservationapp.payload;

import javax.persistence.Lob;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {

    @NotEmpty
    @Size(min = 2, message = "Name should be atleast 2 characters")
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    private byte[] profilePicture;

}
