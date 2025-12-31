package com.projectaizen.players;

/**
 * This will be serving as a Parent class for human player and bot player. this
 * will have the following variables: 1. isDead(Boolean) 2. score(Integer) 3.
 * wickets(Byte) 4. playerName(String)
 *
 * Methods: 1. getters for above variables 2. updateScore(Byte) 3.
 * updateWicket() 4. getPlayerMove()
 *
 * The getPlayerMove will be Overridden by the Child classes.
 *
 * @author Aryan
 */
public class Player {

    private boolean isDead;
    private int score;
    private byte wickets;
    private String playerName;

    public boolean isIsDead() {
        return isDead;
    }

    public int getScore() {
        return score;
    }

    public byte getWickets() {
        return wickets;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void updateIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    public void updateScore(byte batterMove) {
        this.score += batterMove;
    }

    public void updateWickets() {
        this.wickets++;
    }

    //  will be overridden by the child classes
    public byte getPlayerMove() {
        return -1;
    }

    public Player(String playerName) {
        this.playerName = playerName;
        this.isDead = false;
        this.score = 0;
        this.wickets = 0;
    }

}
