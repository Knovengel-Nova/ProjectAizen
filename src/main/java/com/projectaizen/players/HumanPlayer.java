package com.projectaizen.players;

import com.projectaizen.util.Input;

/**
 *
 * @author Aryan
 */
public class HumanPlayer extends Player {

    @Override
    public byte getPlayerMove(){
        byte move = -1;
        System.out.print(getPlayerName()+", Enter Your move: ");
        move = Input.sc.nextByte();
        return move;
    }
    
    public HumanPlayer(String playerName) {
        super(playerName);
    }
}
