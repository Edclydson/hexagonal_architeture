package com.example.hexagonal.adapters.outbound.repository;


import com.example.hexagonal.adapters.inbound.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
}
