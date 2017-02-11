package com.oreilly.config;

import com.oreilly.entities.BaseballGame;
import com.oreilly.entities.Game;
import com.oreilly.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.text.NumberFormat;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.oreilly")
@EnableAspectJAutoProxy
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public NumberFormat numberFormat(){

        return NumberFormat.getCurrencyInstance();
    }

    @Autowired
    private List<Team> teams;

//    @Bean(initMethod = "startGame", destroyMethod = "endGame")
//    @Scope("prototype")
    @Bean
    public Game game() {

        BaseballGame game = new BaseballGame(teams.get(0), teams.get(1));
        game.setDataSource(dataSource);
        return game;
    }


        /*
    @Autowired
    @Qualifier("redSox")
    private Team home;

    @Autowired
    @Qualifier("cubs")
    private Team away;
    */
}
