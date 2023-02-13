package com.example.hexagonal.application.core.service;

import com.example.hexagonal.application.core.domain.User;
import com.example.hexagonal.application.ports.in.SaveUserServicePort;
import com.example.hexagonal.application.ports.out.GetAddressPort;
import com.example.hexagonal.application.ports.out.SaveUserPort;

public class SaveUserService implements SaveUserServicePort{

    private final SaveUserPort saveUserPort;

    private final GetAddressPort getAddressPort;

    public SaveUserService(SaveUserPort saveUserPort, GetAddressPort getAddressPort) {
        this.saveUserPort = saveUserPort;
        this.getAddressPort = getAddressPort;
    }

    @Override
    public User saveUser(User user, String zip) {
        var address = getAddressPort.getAddress(zip);
        user.setAddress(address);
        return saveUserPort.saveUser(user);
    }
}
