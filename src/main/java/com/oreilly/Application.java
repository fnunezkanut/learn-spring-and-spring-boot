package com.oreilly;

import com.oreilly.entities.Game;
import com.oreilly.entities.Team;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.NumberFormat;
import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

//        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Beans provided by Spring Boot:");
        String[] beanNames = context.getBeanDefinitionNames();

        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println( "BEAN: " + beanName);
        }

        //play game
        Game game1 = context.getBean("game", Game.class);
        System.out.println( "GAME: " + game1.playGame() );

        //change away team
        Game game2 = context.getBean("game", Game.class);
        Team royals = context.getBean("royals", Team.class);
        game2.setAwayTeam( royals );
        System.out.println( "GAME: " + game2.playGame() );


        System.out.println( game1 );

        NumberFormat numberFormat = context.getBean( NumberFormat.class );
        double amount = 123456.99;
        System.out.println( numberFormat.format( amount ) );
    }

}
