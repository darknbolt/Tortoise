package com.darknbolt.tortoise.Services;

import com.darknbolt.tortoise.Models.UserDTO;
import com.darknbolt.tortoise.Models.UserDTOMapper;
import com.darknbolt.tortoise.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserDTO> getUserByUsername(String username){
        return  userRepository.findByUsername(username)
                .map(UserDTOMapper::map);
    }
}
