package com.darknbolt.tortoise.Models;

import java.util.stream.Collectors;

public class UserDTOMapper {
    public static UserDTO map(User user){
        return new UserDTO(
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
                        .stream()
                        .map(UserRole::getName)
                        .collect(Collectors.toSet())
        );
    }
}
