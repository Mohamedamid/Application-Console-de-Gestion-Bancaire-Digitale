package com.gestionBank.repositorie.impl;

import com.gestionBank.repositorie.AccountRepository;
import com.gestionBank.model.Account;

public class InMemoryAccountRepository implements AccountRepository {

    @Override
    public Account save(Account account){
        accounts.put(account.getAccountId(),account);
        return account;
    }
}
