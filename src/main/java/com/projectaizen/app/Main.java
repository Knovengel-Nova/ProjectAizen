package com.projectaizen.app;

import com.projectaizen.core.Innings;
import com.projectaizen.players.HumanPlayer;
import com.projectaizen.players.Player;

/**
 *
 * @author Aryan
 */
public class Main {

    public static void main(String[] args) {
        Player p1 = new HumanPlayer("Tawdolski");
        Player p2 = new HumanPlayer("Arnav");
        Innings i1 = new Innings(p1, p2);
        
        i1.start();
    }
}
