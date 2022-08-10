package ru.malyshev.epicpartnerstest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.malyshev.epicpartnerstest.model.Counter;
import ru.malyshev.epicpartnerstest.service.CounterService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/counters")
public class CounterController {
    private final CounterService counterService;

    @GetMapping(value = "/{counterId}")
    public ResponseEntity<?> getCountById(@PathVariable(name = "counterId") String counterId) {

        Counter counter = counterService.getCount(counterId);

        return counter == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(counter.getCount(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> implementCount(@RequestBody Counter counter) {
        if (!counterService.checkCounter(counter)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (counterService.getCount(counter.getCounterId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        int newCount = counterService.incrementCount(counter);

        return new ResponseEntity<>(newCount, HttpStatus.OK);
    }
}