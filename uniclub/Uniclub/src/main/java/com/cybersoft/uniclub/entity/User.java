package com.cybersoft.uniclub.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String email;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;



}
