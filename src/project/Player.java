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
    private String playerID; 
    private final Pile playPile, wonPile;

    public Player(String name)
    {
        playerID= name;
        playPile = new Pile();
        wonPile = new Pile();
    }

    public String getPlayerID() 
    {
        return playerID;
    }

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
}
