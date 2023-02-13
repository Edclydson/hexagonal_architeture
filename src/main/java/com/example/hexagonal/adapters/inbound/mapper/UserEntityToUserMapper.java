package com.example.hexagonal.adapters.inbound.mapper;

import com.example.hexagonal.adapters.inbound.entity.UserEntity;
import com.example.hexagonal.application.core.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserMapper{

    public User mapper(UserEntity userEntity){
        var user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }
}
