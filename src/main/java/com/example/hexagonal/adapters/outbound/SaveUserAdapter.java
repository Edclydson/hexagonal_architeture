package com.example.hexagonal.adapters.outbound;

import com.example.hexagonal.adapters.inbound.mapper.AddressToAddressEntityMapper;
import com.example.hexagonal.adapters.inbound.mapper.UserEntityToUserMapper;
import com.example.hexagonal.adapters.inbound.mapper.UserToUserEntityMapper;
import com.example.hexagonal.adapters.outbound.repository.UserRepository;
import com.example.hexagonal.application.core.domain.User;
import com.example.hexagonal.application.ports.out.SaveUserPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveUserAdapter implements SaveUserPort{
    private final UserRepository userRepository;
    private final UserToUserEntityMapper userToUserEntityMapper;
    private final UserEntityToUserMapper userEntityToUserMapper;
    private final AddressToAddressEntityMapper addressToAddressEntityMapper;

    @Override
    @Transactional
    public User saveUser(User user) {
        var userEntity = userToUserEntityMapper.mapper(user);
        var addressEntity = addressToAddressEntityMapper.mapper(user.getAddress());
        userEntity.setAddressEntity(addressEntity);
        return userEntityToUserMapper.mapper(userRepository.save(userEntity));

    }
}
