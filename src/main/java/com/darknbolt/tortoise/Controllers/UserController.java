package com.darknbolt.tortoise.Controllers;

import com.darknbolt.tortoise.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{id}/pic")
    public ResponseEntity<String> uploadProfilePicture(@PathVariable Long id, @RequestParam("image") MultipartFile imageFile) throws Exception{
        if (imageFile.isEmpty()) return ResponseEntity
                                    .badRequest()
                                    .body("No image provided");
        if(!imageFile.getContentType().startsWith("image/")) return ResponseEntity.badRequest().body("Only image files are allowed");

        Path baseDir = Paths.get("uploads/users");
        Path userDir = baseDir.resolve("user-" + id);

        Files.createDirectories(userDir);

        String originalFileName = imageFile.getOriginalFilename();
        String filename = originalFileName != null ? originalFileName : "profile-pic.png";

        Path filePath = userDir.resolve(filename);

        Files.write(filePath, imageFile.getBytes());

        return ResponseEntity.ok("Profile picture uploaded");
    }

}
