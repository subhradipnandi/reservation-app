package com.reservationapp.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "use_registration")
public class UserRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size(min = 2, message = "Name should be atleast 2 characters")
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;
    @Lob
    @Column(name="profile_picture", columnDefinition = "LONGBLOB")
    private byte[] profilePicture;

}
