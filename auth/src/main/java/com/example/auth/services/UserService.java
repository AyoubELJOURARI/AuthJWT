package com.example.auth.services;

import com.example.auth.domaine.User;
import com.example.auth.exceptions.EtAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public interface UserService {
    User validateUser(String email, String password ) throws EtAuthException;
    User registerUser(String firstname, String lastname, String email, String password ) throws EtAuthException;
}
