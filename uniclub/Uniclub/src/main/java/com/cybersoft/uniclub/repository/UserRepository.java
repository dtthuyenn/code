package com.cybersoft.uniclub.repository;

import com.cybersoft.uniclub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository


public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findByUsernameAndPassword(String username,String password );

    Optional<User> findByEmailAndPassword(String email, String password);

}
