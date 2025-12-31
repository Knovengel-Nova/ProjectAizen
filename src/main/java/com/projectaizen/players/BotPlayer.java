package com.projectaizen.players;

import com.projectaizen.util.Utility;

/**
 *
 * @author Aryan
 */
public class BotPlayer extends Player {
    
    @Override
    public byte getPlayerMove(){
        return (byte)Utility.rand.nextInt(7);   //  generates a random number [0, 7)
    }
    
    public BotPlayer() {
        super("Simple Bot");
    }
}
