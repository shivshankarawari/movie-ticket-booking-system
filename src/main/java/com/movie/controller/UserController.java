package com.movie.controller;

import com.movie.exception.ApiResponse;
import com.movie.request.UserRequest;
import com.movie.response.UserResponse;
import com.movie.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest) {
        log.info("user request {}", userRequest);
        UserResponse createdUser = this.userService.saveUser(userRequest);
        log.info("user response {}", createdUser);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }


    @GetMapping("/find/{userId}")
    public ResponseEntity<UserResponse> getUserByUserId(@PathVariable String userId) {

        UserResponse userById = this.userService.getUserByUserId(userId);
        log.info("user request {}", userById);
        return new ResponseEntity<>(userById, HttpStatus.OK);

    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserResponse> updateUser(@Valid @PathVariable String userId, @RequestBody UserRequest userRequest) {
        UserResponse updatedUser = this.userService.updateUser(userRequest, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping("/search/keywords/{keyword}")
    public ResponseEntity<?> getUserByKeyword(@PathVariable String keyword) {
        List<UserResponse> user = this.userService.getUserByKeyword(keyword);
        return new ResponseEntity<>((!user.isEmpty()) ? user : new ApiResponse("User not found with keyword: " + keyword, true), HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<?> getAllUsers() {
        List<UserResponse> users = this.userService.getAllUsers();
        return new ResponseEntity<>((!users.isEmpty()) ? users : new ApiResponse("User list is empty ", true), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId) {
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
    }
}
