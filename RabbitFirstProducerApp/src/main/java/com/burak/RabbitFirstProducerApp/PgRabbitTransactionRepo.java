package com.burak.RabbitFirstProducerApp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PgRabbitTransactionRepo extends JpaRepository<PgRabbitTransaction,Integer> {

    public Optional<PgRabbitTransaction> findByEventId(String eventId);
}
