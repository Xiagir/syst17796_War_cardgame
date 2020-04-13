
package project;

/**
 *
 * @author Maksim Chernov
 */
public class WarGame {
    public static void main(String[] args) {
        Game g = new Game("WarGame");
        g.play();
        
           Player winner = g.getWinner();
           if(winner == null) System.out.println("It's a tie game!!");
           else System.err.println("\nThe winner of this game is: "+ winner.getPlayerID());
}
}
