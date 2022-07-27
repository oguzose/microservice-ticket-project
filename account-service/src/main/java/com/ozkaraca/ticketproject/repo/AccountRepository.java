package com.ozkaraca.ticketproject.repo;

import com.ozkaraca.ticketproject.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CassandraRepository<Account, String> {
}
