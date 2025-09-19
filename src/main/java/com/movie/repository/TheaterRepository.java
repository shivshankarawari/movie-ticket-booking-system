package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

    @Query("SELECT p FROM Theater p WHERE CONCAT(p.theaterName,' ',p.street,' ',p.state,' ',p.zip,' ',p.city) LIKE %?1%")
    List<Theater> findByKeyword(String keyword);

}
