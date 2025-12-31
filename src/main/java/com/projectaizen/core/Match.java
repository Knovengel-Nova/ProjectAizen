package com.projectaizen.core;

import com.projectaizen.players.Player;
import com.projectaizen.util.Utility;

/**
 *
 * @author Aryan
 */
public class Match {
    private Player batsman;
    private Player bowler;
    private int target;
    
    public void startMatch(Player p1, Player p2){
        toss(p1, p2);
        
        Inning innings1 = new Inning(batsman, bowler);
        innings1.start();
        
        if(innings1.isIsInningOver()){
            this.target = innings1.getScore()+1;
        }
        
        System.out.println("Target for "+bowler.getPlayerName()+": "+target);
        
        Inning innings2 = new Inning(bowler, batsman, target);    //  switch roles.
        innings2.start();
        
        if(innings2.isIsInningOver()){
            if(innings2.getScore()< target){
                System.out.println(batsman.getPlayerName()+", you Won the match!");
            }else{
                System.out.println(bowler.getPlayerName()+", you Won the match!");
            }
        }
    }
    
    private void toss(Player p1, Player p2){
        
        /*
            will generate random number 0 or 1 - if 0 then p1 won the toss else p2 won the toss
            then based on who won the toss, we'll take in input from the winning player whether he wants to bat or bowl first.
            if ch becomes 0 then p1 will bat first, if it is 1 then p2 will bat first.
        */
        
        byte randomNumber = (byte)Utility.rand.nextInt(2);  
        byte ch = 1;
        
        if(randomNumber == 0){
            System.out.println(p1.getPlayerName()+", You won the toss!\nType in 0 for batting or 1 for bowling first:\t");
            ch = (byte)((p1.getPlayerMove()%2) == 0?0:1);
            //  if p1 chose 0(he wants to bat first) then ch will become 0 else 1(he wants to bowl first)
        }else{
            System.out.println(p2.getPlayerName()+", You won the toss!\nType in 0 for batting or 1 for bowling first:\t");
            ch = (byte)((p2.getPlayerMove()%2) == 0?1:0);
            //  if p2 chose 0(he wants to bat first) then ch will become 1 else 0(he wants to bowl first)
        }
        
        switch (ch) {
            case 0:
                this.batsman = p1;
                this.bowler = p2;
                System.out.println(p1.getPlayerName()+", you have to BAT first.");
                System.out.println(p2.getPlayerName()+", You'll have to BOWL first.\n");
                break;
            
            case 1:
                this.batsman = p2;
                this.bowler = p1;
                System.out.println(p2.getPlayerName()+", you have to BAT first.");
                System.out.println(p1.getPlayerName()+", You'll have to BOWL first.\n");
                break;
            
            default:
                throw new AssertionError();
        }
    }

    public Match() {
        this.target = 0;
    }
    
    
}
