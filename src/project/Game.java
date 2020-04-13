/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author megha,2020
 */
public class Game 
{
    private final String gameName;//the title of the game
    private ArrayList <Player> players;// the players of the game
    
    public Game(String givenName)
    {
        gameName = givenName;
        players = new ArrayList();
    }

    /**
     * @return the gameName
     */
    public String getGameName() 
    {
        return gameName;
    }
    
     /**
     * @return the players of this game
     */
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList <Player> players) 
    {
        this.players = players;
    }
    
    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
     */
    public void play() {
        Deck deck = new Deck();
        deck.generateDeck();
        deck.shuffle();
        deck.shuffle();
        
        players.add(new Player("Maxim"));
        players.add(new Player("Vladyslav"));
        //players draw cards
        while(deck.getSize() >= 2) {
            players.get(0).collectCard(deck.removeFromTop());
            players.get(1).collectCard(deck.removeFromTop());
        }
        players.get(0).useWonPile();
        players.get(1).useWonPile();
        
        Pile warCards = new Pile();
        
        gameLoop : for(int i= 1; i<50;i++) {
            if(!enoughCards(1)) break gameLoop;
            
            Card c1 = players.get(0).playCard();
            Card c2 = players.get(1).playCard();
            System.out.println("\nTurn" + i + ": ");
            System.out.println(players.get(0).getPlayerID() + ": " + c1 + " ");
            System.out.println(players.get(1).getPlayerID() + ": " + c2 + " ");
            
            if(c1.getValue().ordinal() > c2.getValue().ordinal()) {
                players.get(0).collectCard(c1);
                players.get(0).collectCard(c2);
                System.out.println("player 1 gets card(s) ");
            }
            else if (c1.getValue().ordinal() < c2.getValue().ordinal()) {
                players.get(1).collectCard(c1);
                players.get(1).collectCard(c2);
                System.out.println("player 2 gets card(s)");
            }
            else // WAR happening
            {
                warCards.clear(); //clearing pile of war cards
                warCards.addCard(c1);
                warCards.addCard(c2);
                boolean done = false;
                do {                    
                    if (!enoughCards(2)){
                        break gameLoop;
                        }
                    System.out.println("\nWar! Players put down ");
                    System.out.println(2 +" card(s)");
                    
                    for (int j = 1; j < 2; j++) {
                        c1 = players.get(0).playCard();
                        c2 = players.get(1).playCard();
                        warCards.addCard(c1);
                        warCards.addCard(c2);
                    }
                    System.out.println(players.get(0).getPlayerID() + ": " + c1 + " ");
                    System.out.println(players.get(1).getPlayerID() + ": " + c2 + " ");
                    if(c1.getValue().ordinal() > c2.getValue().ordinal()) {
                        players.get(0).collectCards(warCards);
                        done = true;
                    }
                    else if(c1.getValue().ordinal() < c2.getValue().ordinal()) {
                        players.get(1).collectCards(warCards);
                        done = true;
                    }
                    
                } while (!done); // end of 100 turns 
            }
            System.out.println(players.get(0).getCardsLeft() + " to " + players.get(1).getCardsLeft());
        }
    }
    
    
    boolean enoughCards(int n)
    {
    if (players.get(0).getCardsLeft()< n ) {
        System.out.println(players.get(0).getPlayerID() +" has lost all of his cards");
       return false; 
    }  
    else if (players.get(1).getCardsLeft()< n ) {
        System.out.println(players.get(1).getPlayerID() +" has lost all of his cards");
       return false; 
    }  
    return true;
    }
    
    
    Player getWinner()
{
    if (players.get(0).getCardsLeft()> players.get(1).getCardsLeft()) {
         return players.get(0);
    }
    else if (players.get(1).getCardsLeft()> players.get(0).getCardsLeft()) {
        return players.get(1);
    } 
    else return null;
}
    
    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
//    public abstract void declareWinner();

   
    
}//end class
