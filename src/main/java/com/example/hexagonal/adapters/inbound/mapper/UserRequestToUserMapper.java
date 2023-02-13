package com.example.hexagonal.adapters.inbound.mapper;

import com.example.hexagonal.adapters.inbound.request.UserRequest;
import com.example.hexagonal.application.core.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserRequestToUserMapper{

    public User mapper(UserRequest userRequest){
        var user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return user;
    }
}
