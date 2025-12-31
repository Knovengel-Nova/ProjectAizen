package com.projectaizen.core;

/**
 * This is the Class which will hold 6 Balls. it will have the following
 * Variables: 
 *      1.  over(Ball[]) 
 *      2.  totalRunsScored(Byte) 
 *      3.  wicketsTaken(Byte) 
 *      4.  currentBall(Byte) 
 *      5.  isFull(Boolean) 
 * Methods:
 *      1.  Getters for all variables
 *      2.  updateOver(Ball)
 *      3.  displayOverStats()
 * 
 * We can change the values of the above
 * mentioned variables through constructor. We can update the over array using
 * updateOver() method which takes in a Ball as parameter, when the over has 6
 * Balls the isFull is set to true To display the stats of the over we use the
 * displayOverStats() method. It displays the ball number, batterMove,
 * BowlerMove and Remark(remark is OUT if batterMove = bowlerMove, and blank
 * otherwise). if the Ball is unplayed in an over the batterMove = bowlerMove =
 * -1
 *
 * @author Aryan
 */
public class Over {

    private Ball[] over = new Ball[6];  //  holds 6 balls of the current over
    private byte totalRunsScored;       //  total runs scored by the batsman in this over
    private byte wicketsTaken;          //  total wickets taken by the bowler in this over
    private byte currentBall;           //  current ball of the over
    private boolean isFull;             //  determines if the over is full or not (has 6 balls)

    public byte getCurrentBall() {
        return currentBall;
    }

    public boolean isIsFull() {
        return isFull;
    }

    public void updateOver(Ball ball) {
        if (currentBall < 6) {
            over[currentBall] = ball;
            currentBall++;
            if (currentBall >= 6) {
                this.isFull = true;
            }
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
            System.out.print("| " + (i + 1));
            System.out.print("\t|\t" + over[i].getBatterMove() + "\t|\t" + over[i].getBowlerMove() + "\t|\t");
            if (over[i].isIsOut() == true) {
                System.out.println("OUT\t|");
            } else {
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
