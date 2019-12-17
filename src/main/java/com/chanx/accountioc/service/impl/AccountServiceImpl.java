package com.chanx.accountioc.service.impl;

import com.chanx.accountioc.dao.AccountDao;
import com.chanx.accountioc.domain.Account;
import com.chanx.accountioc.service.AccountService;

import java.util.List;

// 账户业务层实现类
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }
}
