package com.annotation.config;

import com.annotation.bean.Person;
import com.annotation.condition.LinuxCondition;
import com.annotation.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
public class MyConfig2 {

    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    //ConfigurableBeanFactory.SCOPE_SINGLETON（默认） #IOC容器启动时会调用方法创建对象放到容器中，以后每次取直接从容器中拿
    //ConfigurableBeanFactory.PROTOTYPE IOC容器启动是不会调用方法创建对象，每次调用对象时创建一个对象
    @Lazy
    //懒加载 针对单例bean，容器启动时先不创建对象，在第一次使用（获取）时创建对象，并初始化
    public Person person() {
        return new Person("zhangsan", 25);
    }

    @Conditional(value = {WindowsCondition.class})
    //@Conditional#value = Condition[]
    @Bean("billgates")
    //@Conditional("")
    public Person person01() {
        return new Person("BillGates", 62);
    }

    @Conditional(value = {LinuxCondition.class})
    @Bean("jack")
    public Person person02() {
        return new Person("JackMa", 50);
    }
}
