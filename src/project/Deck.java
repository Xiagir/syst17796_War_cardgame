/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author megha,2020
 */
public class Deck 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    private int size;//the size of the grouping
    
    public Deck(int givenSize)
    {
        size = givenSize;
    }
    
    public void generateDeck() {
        int count=0;
        cards = new ArrayList<>(size);
       
        for(Card.Suit s:Card.Suit.values())
        {
            for(Card.Value v: Card.Value.values())
            {
                cards.add(count, new Card(s,v));
                count++;
            }
       }
    }
    
    public Card deal() {
        if(size == 0) return null;
        size--;
        return cards.get(size);
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }
    
    public Card removeFromTop() {
        Card card = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        return card;
    }
    
    public void addToTop(Card topCard) {
        cards.add(topCard);
    }

    // Add a group of cards to the bottom of a deck. Shuffle
    // the group of cards first to ensure randomness.
    public void addToBottom(Deck bottomCards) {
        bottomCards.shuffle();

        while(bottomCards.getSize() > 0) {
            cards.add(0, bottomCards.removeFromTop());
        }
    }
    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }
    
}//end class
