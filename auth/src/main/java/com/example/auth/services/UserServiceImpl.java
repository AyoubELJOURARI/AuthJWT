package com.example.auth.services;

import com.example.auth.domaine.User;
import com.example.auth.exceptions.EtAuthException;
import com.example.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if (email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String firstname, String lastname, String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) email = email.toLowerCase();
        if (!pattern.matcher(email).matches()) throw new EtAuthException("Invalid Email Format !");
        Integer count = userRepository.getCountByEmail(email);
        if(count > 0) throw new EtAuthException("Email already in use");
        Integer userId = userRepository.create(firstname, lastname, email, password);

        return userRepository.findById(userId);
    }
}
