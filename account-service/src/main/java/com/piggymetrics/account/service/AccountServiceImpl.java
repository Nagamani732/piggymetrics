package com.piggymetrics.account.service;

import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.User;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    @Override
    public Account findByName(String accountName) {
        return null;
    }

    @Override
    public Account create(User user) {
        return null;
    }

    @Override
    public void saveChanges(String name, Account update) {

    }
}
