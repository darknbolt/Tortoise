package com.darknbolt.tortoise.Services;

import com.darknbolt.tortoise.Models.User;
import com.darknbolt.tortoise.Models.UserDTO;
import com.darknbolt.tortoise.Models.UserDTOMapper;
import com.darknbolt.tortoise.Models.UserRole;
import com.darknbolt.tortoise.Repositories.UserRepository;
import com.darknbolt.tortoise.Repositories.UserRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    public void registerNewUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UserRole role = userRoleRepository.findByName("Explorer")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.getRoles().add(role);
        userRepository.save(user);
    }

    public Optional<UserDTO> getUserByUsername(String username){
        return userRepository.findByUsername(username)
                .map(UserDTOMapper::map);
    }
}
