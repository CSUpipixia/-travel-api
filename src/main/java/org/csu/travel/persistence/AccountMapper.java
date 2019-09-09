package org.csu.travel.persistence;

import org.csu.travel.domain.Account;

public interface AccountMapper {

    Account getAccountByUsername(String username);

    Account getAccountByUsernameAndPassword(Account account);

    void updateAccount(Account account);

    void updatePassword(Account account);


}