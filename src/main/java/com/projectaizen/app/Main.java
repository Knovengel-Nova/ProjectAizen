package com.projectaizen.app;

import com.projectaizen.core.Inning;
import com.projectaizen.core.Match;
import com.projectaizen.players.BotPlayer;
import com.projectaizen.players.HumanPlayer;
import com.projectaizen.players.Player;

/**
 *
 * @author Aryan
 */
public class Main {

    public static void main(String[] args) {
        
        Player p1 = new HumanPlayer("Aryan");
        Player p2 = new BotPlayer();
        
        Match match = new Match();
        
        match.startMatch(p1, p2);
    }
}
