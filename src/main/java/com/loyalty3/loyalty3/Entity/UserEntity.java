package com.loyalty3.loyalty3.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nameUser;
    @Email(message = "Format Tidak Sesuai")
    private String email;
    private String password;
    private String phone;

    private String userType = "USER";

}
