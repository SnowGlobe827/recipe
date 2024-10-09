package com.rcp.rfg.jpa.service;

import java.util.Optional;

import com.rcp.rfg.jpa.entity.UserEntity;

public interface UserService {
	Optional<UserEntity> findByUsername(String username);
}
