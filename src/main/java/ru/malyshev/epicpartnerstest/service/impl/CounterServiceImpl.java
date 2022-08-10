package ru.malyshev.epicpartnerstest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.malyshev.epicpartnerstest.model.Counter;
import ru.malyshev.epicpartnerstest.repository.CounterRepository;
import ru.malyshev.epicpartnerstest.service.CounterService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CounterServiceImpl implements CounterService {
    private final CounterRepository counterRepository;

    @Override
    public Counter getCount(String counterId) {
        return counterRepository.getCounterByCounterId(counterId);
    }

    @Override
    public List<Counter> getAllCounters() {
        return counterRepository.findAll();
    }

    @Override
    public int incrementCount(Counter counter) {
        Counter cnt = counterRepository.getCounterByCounterId(counter.getCounterId());
        cnt.setCount(counter.getCount() + cnt.getCount());
        counterRepository.save(cnt);
        return cnt.getCount();
    }
    @Override
    public boolean checkCounter(Counter counter) {

        if (counter == null || counter.getCounterId() == null || counter.getCounterId().length() > 10 || counter.getCount() <= 0) {
            return false;
        }
        return true;
    }
}
