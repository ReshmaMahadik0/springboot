package annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("annotation/prototype.xml");
        Message m1 = applicationContext.getBean("m1", Message.class);
        Message m2 = applicationContext.getBean("m1", Message.class);

        m1.setId(111);
        m1.setMessage("Hello");

        System.out.println("m1 : " +m1.hashCode());
        System.out.println("m2 : " +m2.hashCode());

        System.out.println(m1 == m2);

        System.out.println(m1.getId() + " : :" + m1.getMessage());
        System.out.println(m2.getId() + " : " + m2.getMessage());



    }
}
