package com.gestionBank.repositorie.impl;

import com.gestionBank.repositorie.AccountRepository;
import com.gestionBank.model.Account;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryAccountRepository implements AccountRepository {
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    @Override
    public Account save(Account account){
        accounts.put(account.getAccountId(), account);
        return account;
    }

    @Override
    public Optional<Account> findByAccountId(String accountId){
        return Optional.ofNullable(accounts.get(accountId));
    }

    @Override
    public List<Account> findByOwnerUserId(UUID ownerUserId){
        return accounts.values().stream()
                .filter(account -> account.getOwnerUserId().equals(ownerUserId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> findAll(){
        return new ArrayList<>(accounts.values());
    }

    @Override
    public void delete(String account){
        accounts.remove(accountId);
    }


}
