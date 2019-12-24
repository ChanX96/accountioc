package com.chanx.xml.service;

import com.chanx.xml.domain.Account;

import java.util.List;

// 账户业务层接口
public interface AccountService {

    // 查询所有
    List<Account> findAllAccount();

    // 查询一个
    Account findAccountById(Integer id);

    // 保存account
    void saveAccount(Account account);

    // 更新account
    void updateAccount(Account account);

    // 删除account
    void deleteAccount(Integer id);

    /**
     *
     * @param sourceName    转出账户名称
     * @param targetName    转入账户名称
     * @param money         转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
