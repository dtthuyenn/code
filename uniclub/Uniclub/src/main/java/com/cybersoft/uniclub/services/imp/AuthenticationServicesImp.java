package com.cybersoft.uniclub.services.imp;

import com.cybersoft.uniclub.entity.User;
import com.cybersoft.uniclub.repository.UserRepository;
import com.cybersoft.uniclub.services.AuthenticationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service


//Mình tạo cái hàm AuthenticationServicesImp mình sẽ kế thuă AuthenticationServices
//đưa lên ioc để khi cần sử dụng thì lấy xuống

public class AuthenticationServicesImp  implements AuthenticationServices {
    @Autowired
    private UserRepository   userRepository ;


    @Override
    public boolean authentication(String username, String password) {

        Optional<User> userOptional= userRepository.findByUsernameAndPassword(username, password);
        //hàm present





        return userOptional.isPresent() ;
    }

    public boolean authenticate(String email, String password) {

        Optional<User> userOptional= userRepository.findByEmailAndPassword(email,password);
        //hàm present





        return userOptional.isPresent() ;
    }



}

