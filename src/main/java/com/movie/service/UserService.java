package com.movie.service;

import java.util.List;

import com.movie.request.UserRequest;
import com.movie.response.UserResponse;

import jakarta.validation.Valid;

public interface UserService {

    UserResponse updateUser(UserRequest userRequest, @Valid String userId);

    List<UserResponse> getUserByKeyword(String keyword);

    UserResponse getUserByUserId(String userId);

    List<UserResponse> getAllUsers();

    void deleteUser(String userId);

    UserResponse saveUser(UserRequest userRequest);

}
