package com.chanx.xml.dao;

import com.chanx.xml.domain.Account;

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

    /**
     * 根据名称查询账户
     * @param accountName
     * @return 如果有一个唯一的结果就返回，如果没有结果就返回null。如果结果集超过一个就抛异常。
     */
    Account findAccountByName(String accountName);
}
