package com.example.hexagonal.application.ports.in;

import com.example.hexagonal.application.core.domain.User;

public interface SaveUserServicePort{
    User saveUser(User user, String zip);
}
