package com.example.auth.repositories;

import com.example.auth.domaine.User;
import com.example.auth.exceptions.EtAuthException;

public interface UserRepository {

    Integer create(String firstname, String lastname, String email, String password) throws EtAuthException;

    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
