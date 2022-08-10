package ru.malyshev.epicpartnerstest.service;

import ru.malyshev.epicpartnerstest.model.Counter;

import java.util.List;

public interface CounterService {
    Counter getCount(String counterId);

    List<Counter> getAllCounters();
    int incrementCount(Counter counter);
    boolean checkCounter(Counter counter);
}
