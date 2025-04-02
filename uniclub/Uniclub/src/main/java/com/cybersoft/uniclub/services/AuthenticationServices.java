package com.cybersoft.uniclub.services;

public interface AuthenticationServices {
    boolean authentication(String username, String password);
    boolean authenticate(String email, String password);

}
