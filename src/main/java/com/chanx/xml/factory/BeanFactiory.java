package com.chanx.xml.factory;

import com.chanx.xml.domain.Account;
import com.chanx.xml.service.AccountService;
import com.chanx.xml.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象工厂
 */
public class BeanFactiory {

    private AccountService accountService;
    private TransactionManager txManager;

    public final void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取Service代理对象
     * @return
     */
    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 添加事务支持
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue = null;
                try {
                    // 1. 开启事务
                    txManager.beginTransaction();
                    // 2. 执行操作
                    rtValue = method.invoke(accountService, args);
                    // 3. 提交事务
                    txManager.commit();
                    // 4. 返回结果
                    return rtValue;
                } catch (Exception e) {
                    // 5. 回滚操作
                    txManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    // 6. 释放连接
                    txManager.release();
                }
            }
        });
    }
}
