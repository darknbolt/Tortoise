package com.darknbolt.tortoise.Models;

import java.util.stream.Collectors;

public class UserDTOMapper {
    public static UserDTO map(User user){
        return new UserDTO(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRoles()
                        .stream()
                        .map(UserRole::getName)
                        .collect(Collectors.toSet())
        );
    }

    /*public static User map(UserDTO userDTO){
        return new User(
                userDTO.getUsername(),
                userDTO.getEmail(),
                userDTO.getPassword()
        );
    }*/
}
