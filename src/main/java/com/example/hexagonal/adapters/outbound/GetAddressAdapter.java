package com.example.hexagonal.adapters.outbound;

import com.example.hexagonal.adapters.outbound.rest.GetAddressRest;
import com.example.hexagonal.application.core.domain.Address;
import com.example.hexagonal.application.ports.out.GetAddressPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetAddressAdapter implements GetAddressPort{

    private final GetAddressRest getAddressRest;


    @Override
    public Address getAddress(String zip) {
        var address = getAddressRest.getAddress(zip).getBody();
        return address;
    }
}
