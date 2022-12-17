package ru.thuggeelya.server.data;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RepositoryRestResource
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    @Query("select a.amount from Account a where a.id = ?1")
    Optional<Long> getBalance(Long id);

    @Transactional
    @Modifying
    @Query("update Account a set a.amount = ?2 where a.id = ?1")
    void changeBalance(Long id, Long amount);

}