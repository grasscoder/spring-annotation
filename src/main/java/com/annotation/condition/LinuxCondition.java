package com.annotation.condition;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    /*
     * ConditionContext:判断条件能使用的上下文环境
     * AnnotatedTypeMetadata:标记了conditional的注释信息
     *
     * */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //1、获取IOC 使用的beanFactory ，BeanFactory创建对象并装配的工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2、获取类加载器
        ClassLoader loader = context.getClassLoader();
        //3、获取环境信息
        Environment environment = context.getEnvironment();
        //4、获取bean定义的注册类，所有的bean 定义都在其中注册，可以查询是否存在bean定义，也可以使用其注册一个bean
        BeanDefinitionRegistry registry = context.getRegistry();

        String osName = environment.getProperty("os.name");
        System.out.println("操作系统类型：" + osName);
        if ("Linux".equals(osName) || "Mac OS X".equals(osName))
            return true;

        return false;
    }
}
