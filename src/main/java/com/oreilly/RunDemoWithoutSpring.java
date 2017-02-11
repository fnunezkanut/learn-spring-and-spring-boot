package com.oreilly;

import com.oreilly.entities.BaseballGame;
import com.oreilly.entities.RedSox;
import com.oreilly.entities.Royals;
import com.oreilly.entities.Team;

public class RunDemoWithoutSpring {

    public static void mainy(String args[]){
        Team rs = new RedSox();
        Team royals = new Royals();
        BaseballGame bg = new BaseballGame(royals,rs);
        System.out.println(bg.playGame());
    }
}
