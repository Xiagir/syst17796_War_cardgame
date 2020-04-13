/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author megha,2020
 */
public class Player 
{
    private String playerID; //the unique ID for this player
    private Pile playPile, wonPile;
    /**
     * A constructor that allows you to set the player's unique ID
     * @param name the unique ID to assign to this player.
     */
    public Player(String name)
    {
        playerID= name;
        playPile = new Pile();
        wonPile = new Pile();
    }
    
    /**
     * @return the playerID
     */
    public String getPlayerID() 
    {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) 
    {
        playerID = givenID;
    }
    
    public Card playCard() {
        if(playPile.getSize() == 0)
            useWonPile();
        if(playPile.getSize() > 0)
            return playPile.nextCard();
        return null;
    }
    
    public void collectCard(Card c) {
        wonPile.addCard(c);
    }
    
    public void collectCards(Pile p) {
        wonPile.addCards(p);
    }
    
    public void useWonPile()
    {
        playPile.clear();
        playPile.addCards(wonPile);
        wonPile.clear();
    }
    
    public int getCardsLeft(){
        return playPile.getSize() + wonPile.getSize();
    }
    
    
    
//    /**
//     * The method to be instantiated when you subclass the Player class
//     * with your specific type of Player and filled in with logic to play your game.
//     */
//    public abstract void play();
    
}
