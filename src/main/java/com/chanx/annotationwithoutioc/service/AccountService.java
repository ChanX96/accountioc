package com.chanx.annotationwithoutioc.service;

import com.chanx.annotationwithoutioc.domain.Account;

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
}
