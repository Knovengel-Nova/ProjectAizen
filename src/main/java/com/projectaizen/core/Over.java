package com.projectaizen.core;

/**
 * 
 * @author Aryan
 */
public class Over {

    private Ball[] over = new Ball[6];  //  holds 6 balls of the current over
    private byte totalRunsScored;       //  total runs scored by the batsman in this over
    private byte wicketsTaken;          //  total wickets taken by the bowler in this over
    private byte currentBall;           //  current ball of the over
    private boolean isFull;

    public byte getCurrentBall() {
        return currentBall;
    }

    public boolean isIsFull() {
        return isFull;
    }

    public void updateCurrentBall() {
        if (this.currentBall < 6) {
            this.currentBall++;
            if (this.currentBall >= 5) {
                this.isFull = true;
            }
        } else {
            System.out.println("Over Out Of Range Error!");
        }
    }

    public void updateOver(Ball ball) {
        if (currentBall < 6) {
            over[currentBall] = ball;
            if (ball.isIsOut() == true) {
                this.wicketsTaken++;
            } else {
                this.totalRunsScored += ball.getBatterMove();
            }
        } else {
            System.out.println("Over Out Of Range Error!");
        }
    }

    public byte getTotalRunsScored() {
        return totalRunsScored;
    }

    public byte getWicketsTaken() {
        return wicketsTaken;
    }

    public void displayOverStats() {
        System.out.println("-------------------------------------------------------");
        System.out.println("| Ball\t|\tBatsman\t|\tBowler\t|\tRemark  |");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < 6; i++) {
            System.out.print("| "+(i + 1));
            System.out.print("\t|\t" + over[i].getBatterMove() + "\t|\t" + over[i].getBowlerMove() + "\t|\t");
            if (over[i].isIsOut() == true) {
                System.out.print("OUT\t|");
            }else{
                System.out.println("\t|");
            }
            System.out.println("-------------------------------------------------------");
        }
    }

    public Over() {
        /*  Initiallizing all the balls of the over to default values mentioned 
         *  in the Ball Class*/
        for (int i = 0; i < 6; i++) {
            over[i] = new Ball();
        }
        this.currentBall = 0;
        this.totalRunsScored = 0;
        this.wicketsTaken = 0;
        this.isFull = false;
    }
}
