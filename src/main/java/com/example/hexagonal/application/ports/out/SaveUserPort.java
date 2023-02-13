package com.example.hexagonal.application.ports.out;

import com.example.hexagonal.application.core.domain.User;

public interface SaveUserPort{
    User saveUser(User user);
}
