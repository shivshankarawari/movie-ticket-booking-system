package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT p FROM User p WHERE CONCAT(p.userName,' ', p.userMobileNumber,' ',p.emailId) LIKE %?1%")
    List<User> findByKeyword(String user);

}
