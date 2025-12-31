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

    private String center(String text, int width) {
        if (text == null) {
            text = "";
        }
        if (text.length() >= width) {
            return text.substring(0, width);
        }

        int leftPadding = (width - text.length()) / 2;
        int rightPadding = width - text.length() - leftPadding;

        return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
    }

    public void displayOverStats() {

        final int BALL_W = 4;
        final int BAT_W = 7;
        final int BOWL_W = 7;
        final int REMARK_W = 12;

        String border = "+------+---------+---------+--------------+";

        System.out.println(border);
        System.out.println(
                "| " + center("Ball", BALL_W)
                + " | " + center("Batsman", BAT_W)
                + " | " + center("Bowler", BOWL_W)
                + " | " + center("Remark", REMARK_W) + " |"
        );
        System.out.println(border);

        for (int i = 0; i < 6; i++) {

            String batsman = "";
            String bowler = "";
            String remark;

            if (over[i].getBatterMove() != -1) {
                batsman = String.valueOf(over[i].getBatterMove());
                bowler = String.valueOf(over[i].getBowlerMove());

                if (over[i].isIsOut()) {
                    remark = "OUT";
                } else if (over[i].getBatterMove() == 0) {
                    remark = "Dot Ball";
                } else {
                    remark = "Earned " + over[i].getBatterMove();
                }
            } else {
                remark = "Pending";
            }

            System.out.println(
                    "| " + center(String.valueOf(i + 1), BALL_W)
                    + " | " + center(batsman, BAT_W)
                    + " | " + center(bowler, BOWL_W)
                    + " | " + center(remark, REMARK_W) + " |"
            );
        }

        System.out.println(border);
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
