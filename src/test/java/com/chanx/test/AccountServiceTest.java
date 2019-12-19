package com.chanx.test;

import com.chanx.annotationwithoutioc.domain.Account;
import com.chanx.annotationwithoutioc.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

// 使用junit单元测试
public class AccountServiceTest {

    @Test
    public void testFindAll() {

        // 1.获取对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获得业务层对象
        AccountService as  = ac.getBean("accountService", AccountService.class);
        // 3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {

        // 1.获取对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获得业务层对象
        AccountService as  = ac.getBean("accountService", AccountService.class);
        // 3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {

        Account account = new Account();
        account.setId(4);
        account.setName("ddd");
        account.setMoney(1000.0F);
        // 1.获取对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获得业务层对象
        AccountService as  = ac.getBean("accountService", AccountService.class);
        // 3.执行方法
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {

        // 1.获取对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获得业务层对象
        AccountService as  = ac.getBean("accountService", AccountService.class);
        // 3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456F);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {

        // 1.获取对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获得业务层对象
        AccountService as  = ac.getBean("accountService", AccountService.class);
        // 3.执行方法
        as.deleteAccount(4);
    }
}
