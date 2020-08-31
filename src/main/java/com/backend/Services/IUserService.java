package com.backend.Services;

import com.backend.Entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();

    Optional<User> findById(String id);

    User updateOrCreate(User user);

    void deleteById(String id);
}
