package com.gestionBank.repositorie;

import com.gestionBank.model.Account;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> findByAccoutId(String accoutId);
    List<Account> findAll();
    List<Account> findByOwnerUserId(UUID ownerUserId);
    void delete(Account account);
}
