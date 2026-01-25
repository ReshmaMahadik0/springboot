package com.java.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SingletonCongfig.class, PrototypeConfig.class);

        Singleton s1 = applicationContext.getBean(Singleton.class);
        Singleton s2 = applicationContext.getBean(Singleton.class);

        System.out.println("s1 : " + s1.hashCode());
        System.out.println("s2 : " + s2.hashCode());
        System.out.println(s1 == s2);

        Prototype p1 = applicationContext.getBean(Prototype.class);
        Prototype p2 = applicationContext.getBean(Prototype.class);

        System.out.println("p1 : " + p1.hashCode());
        System.out.println("p2 : " + p2.hashCode());
        System.out.println(p1 == p2);
    }
}
