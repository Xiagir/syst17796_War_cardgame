
package project;

import java.util.ArrayList;

/**
 *
 * @author Maksim Chernov
 */
public class Pile {

    private ArrayList<Card> pile;
    private int front,end;
    
    Pile() {
        pile = new ArrayList<>();
        front = 0; end = 0; 
    }
    
    public int getSize() {
        return end - front;
    }
    
    void clear()
    {
        front = 0; end = 0;
    }
    public void addCard(Card c) {
        pile.add(c);
        end ++ ;
    }
    
    public void addCards(Pile p) {
            while(p.getSize() > 0) {
                addCard(p.nextCard());
            }
    }
        
    public Card nextCard() {
        if(front == end) return null;
        
        Card c = pile.get(front);
        front++;
        return c;
    }
    
}
