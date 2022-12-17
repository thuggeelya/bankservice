package ru.thuggeelya.server.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.thuggeelya.server.data.AccountRepository;
import ru.thuggeelya.server.service.BalanceService;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Log4j
public class BalanceServiceImpl implements BalanceService {

    private final AtomicInteger getBalanceCount = new AtomicInteger();
    private final AtomicInteger changeBalanceCount = new AtomicInteger();
    private final AccountRepository repository;

    @Autowired
    public BalanceServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Long> getBalance(Long id) {
        return repository.getBalance(id);
    }

    @Override
    public void changeBalance(Long id, Long amount) {
        repository.changeBalance(id, amount);
    }

    public void printStats() {
        log.debug("change: " + changeBalanceCount.getAndIncrement());
        log.debug("get   : " + getBalanceCount.getAndIncrement());
        log.debug("all   : " + getBalanceCount.get() + changeBalanceCount.get());
    }
}
