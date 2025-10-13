package com.movie.service.serviceImplementation;

import com.movie.entity.User;
import com.movie.exception.ResourceNotFoundException;
import com.movie.repository.UserRepository;
import com.movie.request.UserRequest;
import com.movie.response.UserResponse;
import com.movie.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImplementation.class);
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(final ModelMapper modelMapper, final UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user = this.modelMapper.map(userRequest, User.class);
        final String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        User user1 = this.userRepository.save(user);
        return this.modelMapper.map(user1, UserResponse.class);
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, @Valid String userId) {
        User foundUser = this.modelMapper.map(this.getUserByUserId(userId), User.class);
        foundUser.setEmailId(userRequest.getEmailId());
        foundUser.setPassword(userRequest.getUserMobileNumber());
        foundUser.setUserMobileNumber(userRequest.getUserMobileNumber());
        foundUser.setUserName(userRequest.getUserName());
        User updatedUser = this.userRepository.save(foundUser);
        return this.modelMapper.map(updatedUser, UserResponse.class);
    }

    @Override
    public List<UserResponse> getUserByKeyword(String keyword) {
        List<User> userBykeyWord = this.userRepository.findByKeyword(keyword);
        return userBykeyWord.stream().map(p -> this.modelMapper.map(p, UserResponse.class)).collect(Collectors.toList());

    }

    @Override
    public UserResponse getUserByUserId(String userId) {
        User foundUser = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND, String.format("User with id %s not found", userId)));

        return this.modelMapper.map(foundUser, UserResponse.class);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return this.userRepository.findAll().stream().map(Source -> this.modelMapper.map(Source, UserResponse.class)).collect(Collectors.toList());

    }

    @Override
    public void deleteUser(String userId) {
        User foundUser = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(HttpStatus.NOT_FOUND, String.format("User with id %s not found", userId)));

        this.userRepository.delete(foundUser);

    }

}
