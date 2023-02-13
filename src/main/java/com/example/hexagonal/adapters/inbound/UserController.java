package com.example.hexagonal.adapters.inbound;

import com.example.hexagonal.adapters.inbound.mapper.UserRequestToUserMapper;
import com.example.hexagonal.adapters.inbound.request.UserRequest;
import com.example.hexagonal.application.core.domain.User;
import com.example.hexagonal.application.ports.in.SaveUserServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController{

    private final SaveUserServicePort saveUserServicePort;

    private final UserRequestToUserMapper userRequestToUserMapper;

    @PostMapping
    public User saveUser(@RequestBody UserRequest userRequest){
        var user = userRequestToUserMapper.mapper(userRequest);
        return saveUserServicePort.saveUser(user, userRequest.getZip());
    }
}
