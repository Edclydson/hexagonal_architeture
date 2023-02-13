package com.example.hexagonal.adapters.outbound.rest;

import com.example.hexagonal.application.core.domain.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "buscaCep", url = "https://viacep.com.br")
public interface GetAddressRest{

    @GetMapping("/ws/{zip}/json")
    ResponseEntity<Address> getAddress(@PathVariable String zip);
}
