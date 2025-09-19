package com.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT p FROM Movie p WHERE CONCAT(p.movieName,' ',p.genre,' ',p.releaseDate,' ',p.description) LIKE %?1%")
    List<Movie> findByKeyword(String keyword);

}
