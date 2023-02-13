package com.example.hexagonal.adapters.inbound.mapper;

import com.example.hexagonal.adapters.inbound.entity.UserEntity;
import com.example.hexagonal.application.core.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserToUserEntityMapper{

    public UserEntity mapper(User user){
        var userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        return userEntity;
    }
}
