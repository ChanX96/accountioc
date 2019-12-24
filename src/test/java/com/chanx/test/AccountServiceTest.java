package com.chanx.test;


import com.chanx.config.SpringConfiguration;
import com.chanx.xml.domain.Account;
import com.chanx.xml.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
* spring整合junit配置
*   1. 导入spring整合junit的jar
*   2. 使用junit提供的注解把原有的main方法替换掉，替换成spring提供的
 *          @RunWith
 *  3. 告知spring运行器，spring的ioc创建基于xml还是注解，并且说明位置。
 *          @ContextConfiguration
 *              locations：指定xml文件位置，加上classpath文件关键字表示在类路径下。
 *              classes：指定注解类所在的位置。
 *  当使用spring 5.X版本时，要求junit的jar必须是4.1.2及以上。
*/
// 使用junit单元测试
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

//    private ApplicationContext ac;
//    @Autowired
    private AccountService as;

    @Before
    public void init() {

        // 1.获取对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 2.获得业务层对象
        as = ac.getBean("accountService", AccountService.class);
    }

    @Test
    public void testFindAll() {


        // 3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {

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

        // 3.执行方法
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {

        // 3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456F);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {

        // 3.执行方法
        as.deleteAccount(4);
    }

    @Test
    public void testTransfer() {

        as.transfer("aaa", "bbb", 100F);
    }
}
