package com.chanx.test;

import com.chanx.accountioc.domain.Account;
import com.chanx.accountioc.service.AccountService;
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

    }

    @Test
    public void testSave() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }
}
