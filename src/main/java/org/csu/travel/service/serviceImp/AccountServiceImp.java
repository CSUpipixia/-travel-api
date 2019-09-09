package org.csu.travel.service.serviceImp;

import org.csu.travel.domain.Account;
import org.csu.travel.persistence.AccountMapper;
import org.csu.travel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account getAccount(Account account) {
        return accountMapper.getAccountByUsernameAndPassword(account);
    }

    @Override
    public Account getAccount(String username) {
        return accountMapper.getAccountByUsername(username);
    }

    @Override
    public void updateAccount(Account account) {
        if (account.getPassword() != null) {
            accountMapper.updatePassword(account);
        }else{
            accountMapper.updateAccount(account);
        }
    }
}
