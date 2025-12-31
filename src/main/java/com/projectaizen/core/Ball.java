package com.projectaizen.core;

/**
 * This is the basic unit of our application - The Ball. The Ball class contains
 * the following variables: 
 *      1. batterMove(Byte) 
 *      2. bowlerMove(Byte) 
 *      3. isOut(Boolean) 
 *      4. runs(Byte) 
 * We can change the values only through
 * constructor and not by setters. We can get the values of the above
 * mentioned variables through Getters only.
 *
 * The isOut field is set to true if the batterMove and bowlerMove are equal.
 * Initially(Through default constructor) the batterMove, bowlerMove are set to
 * -1 to show a ball not played for the Over class. Also initially isOut is set
 * to false and runs = 0.
 *
 * @author Aryan
 */
public class Ball {

    private byte batterMove;    //  move made by batter in this ball
    private byte bowlerMove;    //  move made by bowler in this ball
    private boolean isOut;      //  was the batsman out on this ball
    private byte runs;          //  runs scored by batsman in this ball

    public byte getBatterMove() {
        return batterMove;
    }

    public byte getBowlerMove() {
        return bowlerMove;
    }

    public boolean isIsOut() {
        return isOut;
    }

    public byte getRuns() {
        return runs;
    }

    //  Main Constructor
    public Ball(byte batterMove, byte bowlerMove) {
        this.batterMove = batterMove;
        this.bowlerMove = bowlerMove;

        if (batterMove == bowlerMove) {
            this.isOut = true;
            this.runs = 0;
        } else {
            this.isOut = false;
            this.runs = batterMove;
        }
    }

    //  empty ball constructor
    public Ball() {
        this.batterMove = -1;
        this.bowlerMove = -1;
        this.isOut = false;
        this.runs = 0;
    }

}
