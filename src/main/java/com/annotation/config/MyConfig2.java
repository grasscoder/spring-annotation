package com.annotation.config;

import com.annotation.bean.Car;
import com.annotation.bean.Person;
import com.annotation.condition.LinuxCondition;
import com.annotation.condition.MyImportBeanDefinitionRegistrar;
import com.annotation.condition.MyImportSelector;
import com.annotation.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
//@Conditional(value = {LinuxCondition.class})
//@Conditional 标注在类上，满足当前条件，这个类中配置的所有的bean才能生效
@Import({Car.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//@Import id默认组件全限定类名
//MyImportSelector.class 中定义了需要导入的类的全限定名
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
    /**
     * 给容器注册组件方式：
     * 1、包扫描 + 组件注解(@Service/@Component/@Repository/@Controller),适用于自己写的类
     * 2、@Bean 导入第三方的组件
     * 3、@Import 快速给容器中导入一个组件
     *      3-1：@Import({导入的类.class}),容器中会自动注册这些组件，id默认为类的全限定名
     *      3-2：ImportSelector 接口:返回需要导入的组件全类名（String数组）
     *      3-3：ImportBeanDefinitionRegistrar接口，
     *
     * */
}
