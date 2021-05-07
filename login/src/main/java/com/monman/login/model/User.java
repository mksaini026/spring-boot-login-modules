package com.monman.login.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String password;

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    private AuthProvider authProvider;

    private String providerId;

}
