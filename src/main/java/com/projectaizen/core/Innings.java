package com.projectaizen.core;

import java.util.ArrayList;
import com.projectaizen.core.Over;
import com.projectaizen.core.Ball;
import com.projectaizen.players.Player;

/**
 *
 * @author Aryan
 */
public class Innings {

    private ArrayList<Over> overs = new ArrayList<>();  //  stores all the overs of this inning
    private Ball currentBall;                           //  stores the state of batterMove, BowlerMover etc. to be added to the current over
    private Over currentOver;                           //  store the state of current over being played. after over is full, to be added to the ArrayList
    private int score;                                  //  stores the total score of this inning
    private boolean isDead;                             //  true if the playe(s) is dead
    private Player batsman;                             //  the batsman for this inning
    private Player bowler;                              //  the bowler for this inning

    public void getMoves() {
        // batterMove;
        byte batterMove;

        //bowlerMove;
        byte bowlerMove;

    }

    private void generateBall(byte batterMove, byte bowlerMove) {
        currentBall = new Ball(batterMove, bowlerMove);
        if(currentOver.isIsFull() == false){
            currentOver.updateOver(currentBall);
        }else{
            overs.add(currentOver);
            currentOver = new Over();
            currentOver.updateOver(currentBall);
        }
    }

    public Innings(Player batsman, Player bowler) {
        this.batsman = batsman;
        this.bowler = bowler;
        this.currentOver = new Over();
        this.isDead = false;
        this.score = 0;
    }

}
