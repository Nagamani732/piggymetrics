package com.piggymetrics.account.service;

import com.piggymetrics.account.domain.Account;
import com.piggymetrics.account.domain.Currency;
import com.piggymetrics.account.domain.Saving;
import com.piggymetrics.account.domain.User;
import com.piggymetrics.account.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private final Logger log = LoggerFactory.getLogger(getClass());
    //private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByName(String accountName) {
        return accountRepository.findByName(accountName);
    }

    @Override
    public Account create(User user) {

        // User creation has to be done on auth-service

        //Account creation
        Saving saving = new Saving();
        saving.setAmount(new BigDecimal(0));
        saving.setCurrency(Currency.getDefault());
        saving.setInterest(new BigDecimal(0));
        saving.setDeposit(false);
        saving.setCapitalization(false);

        Account account = new Account();
        account.setName(user.getUsername());
        account.setLastSeen(new Date());
        account.setSaving(saving);
        accountRepository.save(account);
        log.info("New account has been created: " + account.getName());

        return account;
    }

    @Override
    public void saveChanges(String name, Account update) {
    }
}
