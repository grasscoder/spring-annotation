package com.annotation.config;

import com.annotation.bean.Book;
import com.annotation.bean.Person;
import com.annotation.service.BookService;
import com.annotation.service.MyTypeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration //配置类==配置文件，告诉Spring这是一个配置类
@ComponentScan(value = "com.annotation", useDefaultFilters = false,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class})
        },
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Component.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})

        }
)
//@ComponentScan 扫描@Service/@Component/@Repository/@Controller 拒接修饰的类，可重复添加在同一个配置类上
//@ComponentScan value:指定要扫描的包路径
//@ComponentScan excludeFilters=Filter[]:排除要扫描的类
//@ComponentScan includeFilters=Filter[]:扫描的时候包含那些类
//@ComponentScan FilterType.ASSIGNABLE_TYPE按照指定的类型扫描，及其继承的子类都会被扫描
//@ComponentScan FilterType.CUSTOM 自定义过滤规则筛选，需要继承FilterType接口，并实现其match方法ß
//@ComponentScan FilterType.REGEX 按照指定的类型扫描，及其继承的子类都会被扫描
public class MainConfig {


    @Bean("person") //向容器注册一个bean,id =（默认）方法名，可以直接在@Bean("指定bean名")，返回类型：Person类型,默认是单例的
    public Person person() {
        return new Person("zhangsan", 20);
    }

    @Bean
    public Book book() {
        return new Book("spring源码", 2019);
    }
}
