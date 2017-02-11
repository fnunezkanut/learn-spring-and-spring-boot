package com.oreilly;

import com.oreilly.entities.Game;
import com.oreilly.entities.Team;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        //ApplicationContext ctx = SpringApplication.run(Application.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Beans provided by Spring Boot:");
        String[] beanNames = context.getBeanDefinitionNames();

        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println( "BEAN: " + beanName);
        }

        //play game
        Game game = context.getBean("game", Game.class);
        System.out.println( "GAME: " + game.playGame() );

        //change away team
        Team royals = context.getBean("royals", Team.class);
        game.setAwayTeam( royals );
        System.out.println( "GAME: " + game.playGame() );

    }

}
