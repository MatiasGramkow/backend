package com.backend.Services;

import com.backend.Entities.User;
import com.backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateOrCreate(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(String id)
    {
        userRepository.deleteById(id);
    }
}
