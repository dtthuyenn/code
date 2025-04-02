package com.cybersoft.uniclub.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany
    private List<User> users;


}
