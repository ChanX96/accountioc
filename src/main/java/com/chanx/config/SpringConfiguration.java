package com.chanx.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 *  新注解：
 *      @Configuration：指定当前类是一个配置类。
 *      @ComponentsScan：用于通过注解指定spring在创建容器时要扫描的包。
 *          属性：value和basePackages作用相同，指定创建容器时要扫描的包。使用此注解等同于在xml中配置了
 *               <context:component-scan base-package="com.chanx.annotation"></context:component-scan>
 *      @Bean：用于把当前方法的返回值用作bean对象存入spring的ioc容器中。
 *          属性：name用于指定bean的id。默认值为当前方法名称。
 *          细节：当使用注解配置方法时，如果方法有参数，spring框架回去容器中查找有没有可用的bean对象。
 *          查找的方式和@Autowired相同。
 */
// 配置类，作用和bean.xml相同
@Configuration
@ComponentScan("com.chanx.annotationwithoutioc")
public class SpringConfiguration {

    @Bean(name = "runner")
    public QueryRunner createQueryRunner(DataSource dataSource) {

        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource createDataSource() {

        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
            ds.setUser("root");
            ds.setPassword("123");
            return ds;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }
}
