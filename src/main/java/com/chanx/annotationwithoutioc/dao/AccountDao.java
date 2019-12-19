package com.chanx.annotationwithoutioc.dao;

import com.chanx.annotationwithoutioc.domain.Account;

import java.util.List;

// 账户持久层接口
public interface AccountDao {

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
