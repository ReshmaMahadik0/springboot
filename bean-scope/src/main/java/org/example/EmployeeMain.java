package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("singleton.xml");
        Employee e1 = applicationContext.getBean("emp1", Employee.class);
        Employee e2 = applicationContext.getBean("emp1", Employee.class);

        System.out.println("employee e1 : " +e1.hashCode());
        System.out.println("employee e2 : " +e2.hashCode());

        System.out.println(e1 == e2);


        Employee a1 = applicationContext.getBean("emp2", Employee.class);
        Employee a2 = applicationContext.getBean("emp2", Employee.class);
        System.out.println("employee a1 : " + a1.hashCode());
        System.out.println("employee a2 : " +a2.hashCode());
        System.out.println(a1 == a2);








    }
}
