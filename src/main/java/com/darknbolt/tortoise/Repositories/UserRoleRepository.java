package com.darknbolt.tortoise.Repositories;

import com.darknbolt.tortoise.Models.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    Optional<UserRole> findById(Long id);
    Optional<UserRole> findByName(String name);
}
