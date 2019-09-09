package org.csu.travel.service;

import org.csu.travel.domain.Account;

public interface AccountService {
    //根据用户名和密码得到账户
    Account getAccount(Account account);

    //根据用户名得到账户
    Account getAccount(String username);

    //更新用户
    void updateAccount(Account account);

}
