package com.rcp.rfg.jpa.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rcp.rfg.jpa.entity.UserEntity;
import com.rcp.rfg.jpa.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
