package com.example.hexagonal.adapters.inbound.mapper;

import com.example.hexagonal.adapters.inbound.entity.AddressEntity;
import com.example.hexagonal.application.core.domain.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AddressToAddressEntityMapper{

    public AddressEntity mapper(Address address){
        var addressEntity = new AddressEntity();
        BeanUtils.copyProperties(address, addressEntity);
        return addressEntity;
    }
}
