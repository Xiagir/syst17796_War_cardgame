
package project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Maksim Chernov
 */
public class WarGame {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Game g = new Game("WarGame");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.next();
        players.add(new Player(name));
        players.add(new Player("John Doe"));
        g.setPlayers(players);
        g.play();
        
           Player winner = g.getWinner();
           if(winner == null) System.out.println("It's a tie game!!");
           else System.err.println("\nThe winner of this game is: "+ winner.getPlayerID());
}
}
