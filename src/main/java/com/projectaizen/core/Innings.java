package com.projectaizen.core;

import java.util.ArrayList;
import com.projectaizen.core.Over;
import com.projectaizen.core.Ball;
import com.projectaizen.players.Player;

/**
 * This is the Inning of a match. this will have the following variables:
 *      1.  overs(Over[])
 *      2.  currentBall(Ball)
 *      3.  currentOver(Over)
 *      4.  score(int)
 *      5.  isDead(Boolean)
 *      6.  batsman(Player)
 *      7.  bowler(Player)
 *      8.  currentOverNumber
 * 
 * Methods:
 *      1.  Getters for score, isDead
 *      2.  start()
 *      3.  generateBall(Byte, Byte)
 * 
 * We can get the score and isDead through getters, we don't need getters for other variables.
 * The score is increased as per the batterMove, and the complete overs are added to the overs array.
 * 
 * @author Aryan
 */
public class Innings {

    private ArrayList<Over> overs = new ArrayList<>();  //  stores all the overs of this inning
    private Ball currentBall;                           //  stores the state of batterMove, BowlerMover etc. to be added to the current over
    private Over currentOver;                           //  store the state of current over being played. after over is full, to be added to the ArrayList
    private int score;                                  //  stores the total score of this inning
    private boolean isDead;                             //  true if the player(s) is dead
    private Player batsman;                             //  the batsman for this inning
    private Player bowler;                              //  the bowler for this inning
    private byte currentOverNumber;                     //  the ongoing over's number

    public int getScore() {
        return score;
    }

    public boolean isIsDead() {
        return isDead;
    }
    
    public void start() {
        
        do{
            // batterMove;
            byte batterMove;
            batterMove = batsman.getPlayerMove();

            //bowlerMove;
            byte bowlerMove;
            bowlerMove = bowler.getPlayerMove();

            generateBall(batterMove, bowlerMove);
            
            System.out.println("Score: "+this.score);
            System.out.println("Current Over: "+currentOverNumber);
            System.out.println("Current Ball: "+currentOver.getCurrentBall());
            System.out.println(batsman.getPlayerName()+"'s Move: "+batterMove);
            System.out.println(bowler.getPlayerName()+"'s Move: "+bowlerMove);
            
        }while(isDead != true);
        
        System.out.println("Innings over!\n Score: "+this.score);
        overs.add(currentOver);
        currentOver.displayOverStats();
    }

    private void generateBall(byte batterMove, byte bowlerMove) {
        currentBall = new Ball(batterMove, bowlerMove); //  Make a Ball with current moves
        if(currentOver.isIsFull() == false){            //  Update current Over
            currentOver.updateOver(currentBall);
        }else{                                          
            overs.add(currentOver);                     //  add currentOver into our overs array
            currentOver.displayOverStats();             //  display our current over's stats
            currentOver = new Over();                   //  make a new over
            currentOverNumber++;                        //  increase the ongoing over's number
            currentOver.updateOver(currentBall);        //  update current over
        }
        
        //  Check if the Batsman is Dead or not
        if(currentBall.getBatterMove() == currentBall.getBowlerMove()){
            this.isDead = true;
        }else{
            this.score += currentBall.getBatterMove();  //  Update innings Score
        }
    }

    public Innings(Player batsman, Player bowler) {
        this.batsman = batsman;
        this.bowler = bowler;
        this.currentOver = new Over();
        this.isDead = false;
        this.score = 0;
        this.currentOverNumber = 1;
    }

}
