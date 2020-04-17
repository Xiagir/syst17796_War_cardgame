
package project;

import java.util.ArrayList;

/**
 *
 * @author Maksim Chernov
 */
public class Pile {

    private ArrayList<Card> pile;
    private int front,end;
    
    public Pile() {
        pile = new ArrayList<>();
        front = 0; end = 0; 
    }
    
    public int getSize() {
        return end - front;
    }
    
    public void clear()
    {
        front = 0; end = 0;
    }
    public void addCard(Card c) { // add one card to pile
        pile.add(c);
        end ++ ;
    }
    
    public void addCards(Pile p) { // add cards to pile
            while(p.getSize() > 0) {
                addCard(p.nextCard());
            }
    }
        
    public Card nextCard() { // returns card that needed to play next from bottom of the deck
        if(front == end) return null;
        
        Card c = pile.get(front);
        front++;
        return c;
    }
    
}
