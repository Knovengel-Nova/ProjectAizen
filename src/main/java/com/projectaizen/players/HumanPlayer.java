package com.projectaizen.players;

import com.projectaizen.util.Utility;

/**
 *
 * @author Aryan
 */
public class HumanPlayer extends Player {

    @Override
    public byte getPlayerMove(){
        byte move = -1;
        System.out.print("\n"+getPlayerName()+", Enter Your move: ");
        move = Utility.sc.nextByte();
        return move;
    }
    
    public HumanPlayer(String playerName) {
        super(playerName);
    }
}
