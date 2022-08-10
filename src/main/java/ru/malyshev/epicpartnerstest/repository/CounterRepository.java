package ru.malyshev.epicpartnerstest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.malyshev.epicpartnerstest.model.Counter;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Long> {
    Counter getCounterByCounterId(String counterId);
}
