package com.oreilly;

import com.oreilly.config.AppConfig;
import com.oreilly.entities.Game;
import com.oreilly.entities.Team;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.NumberFormat;

@SpringBootApplication
public class RunDemo {

    public static void main(String[] args) {

//        ApplicationContext ctx = SpringApplication.run(Application.class, args);

//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);



        //play game
        Game game1 = context.getBean("game", Game.class);
        System.out.println( "GAME: " + game1.playGame() );

        //change away team
        Game game2 = context.getBean("game", Game.class);
        Team royals = context.getBean("royals", Team.class);
        game2.setAwayTeam( royals );
        System.out.println( "GAME: " + game2.playGame() );


        //format
        NumberFormat numberFormat = context.getBean( NumberFormat.class );
        double amount = 123456.99;
        System.out.println( numberFormat.format( amount ) );


        //close
        context.close();
    }

}
