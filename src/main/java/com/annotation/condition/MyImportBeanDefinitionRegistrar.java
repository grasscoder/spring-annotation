package com.annotation.condition;

import com.annotation.bean.Dog;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * AnnotationMetadata:当前类的注解信息
     * BeanDefinitionRegistry：BeanDefinition中定义的注册类
     * 把所需要添加到容器的bean通过 BeanDefinitionRegistry.registerBeanDefinition()手动注册到IOC容器
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean defination = registry.containsBeanDefinition("");
        boolean defination2 = registry.containsBeanDefinition("");
        if (defination && defination2) {
            RootBeanDefinition bean = new RootBeanDefinition(Dog.class);
            //手动注册bean到容器中
            registry.registerBeanDefinition("aaa", bean);
        }

    }
}
