package com.oreilly;

import com.oreilly.entities.Game;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //ApplicationContext ctx = SpringApplication.run(Application.class, args);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        
        /*
        Person objA = (Person)ctx.getBean(Person.class);
        objA.setName("Ma Name D!");
        objA.setAge(78);
        System.out.println(objA.getName() + Integer.toString(objA.getAge()));

        Person objB = (Person)ctx.getBean(Person.class);
        objA.setName("MLLLLLL");
        objA.setAge(8);
        System.out.println(objB.getName() + Integer.toString(objB.getAge()));
        */

        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        Game g = ctx.getBean("game", Game.class);
        System.out.println(g.playGame());

    }

}
