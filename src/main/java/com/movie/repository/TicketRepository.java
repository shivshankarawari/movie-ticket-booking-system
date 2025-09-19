package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
