package com.chanx.xml.service.impl;

import com.chanx.xml.dao.AccountDao;
import com.chanx.xml.domain.Account;
import com.chanx.xml.service.AccountService;
import com.chanx.xml.utils.TransactionManager;

import java.util.List;

// 账户业务层实现类

/**
 * 事务控制在业务层。
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {

        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {

        return findAccountById(id);
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

    public void transfer(String sourceName, String targetName, Float money) {

        // 2. 执行操作
        // 2.1 根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        // 2.2 根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        // 2.3 转出账户减钱
        source.setMoney(source.getMoney() - money);
        // 2.4 转入账户价钱
        target.setMoney(target.getMoney() + money);
        // 2.5 更新转出账户
        accountDao.updateAccount(source);
        // 2.6 更新转入账户
        accountDao.updateAccount(target);
    }
}
