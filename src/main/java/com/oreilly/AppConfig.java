package com.oreilly;

import com.oreilly.entities.BaseballGame;
import com.oreilly.entities.Game;
import com.oreilly.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.oreilly")
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier("redSox")
    private Team home;

    @Autowired
    @Qualifier("cubs")
    private Team away;

    @Bean
    public Game game() {
        BaseballGame game = new BaseballGame(home, away);
        game.setDataSource(dataSource);
        return game;
    }
    
}
