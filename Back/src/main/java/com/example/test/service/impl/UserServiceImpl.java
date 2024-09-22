package com.example.test.service.impl;

import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int jmbg) {
        return userRepository.findById(jmbg);
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

@Override
@Transactional
public User updateUser(int jmbg, String firstname,String lastname, int years) {
    User currentUser = userRepository.findById(jmbg)
            .orElseThrow();
    compareAndUpdateUser(currentUser, firstname,lastname,years);
    return currentUser;
}

private void compareAndUpdateUser(User currentUser,String firstname, String lastname,int years) {
    if (!currentUser.compare(firstname,lastname,years)) {
        currentUser.setLastname(
                lastname == null ? currentUser.getLastname() : lastname
        );
        currentUser.setFirstname(
                firstname == null ? currentUser.getFirstname() : firstname
        );
        currentUser.setYears(
                years == 0 ? currentUser.getYears() : years
        );
    }
}
}
