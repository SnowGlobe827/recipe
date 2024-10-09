package com.rcp.rfg.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcp.rfg.jpa.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // username으로 사용자 조회
    Optional<UserEntity> findByUsername(String username);
	
}
