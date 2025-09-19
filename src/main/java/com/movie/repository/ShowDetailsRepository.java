package com.movie.repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.entity.Screen;
import com.movie.entity.ShowDetails;

@Repository
public interface ShowDetailsRepository extends JpaRepository<ShowDetails, Long> {

    Set<ShowDetails> findByScreen(Screen screen);

    /**
     *
     @return true :if duplicate present
     */
    @Query(value = "SELECT IF(COUNT(*) > 0, 'true', 'false') FROM  movie_ticket_booking_system.show_details t WHERE t.screen_id =?1  AND t.show_time= ?2", nativeQuery = true)
    Boolean isDuplicate(Long theaterId, LocalDateTime showTime);

}
