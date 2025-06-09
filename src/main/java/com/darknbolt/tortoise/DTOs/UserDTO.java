package com.darknbolt.tortoise.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class UserDTO {
    private String username;
    private String password;

    @NotBlank(message = "{email.required}")
    @Email(message = "{email.EmailIsInvalid}")
    private String email;
    private String confirmPassword;
    private Set<String> roles;

    public UserDTO() {}

    public UserDTO(String username, String email, String password, Set<String> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UserDTO(String username, String email, String password, String confirmPassword, Set<String> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = password;
        this.roles = roles;
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getConfirmPassword() { return confirmPassword; }
    public Set<String> getRoles() { return roles; }

    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
}
