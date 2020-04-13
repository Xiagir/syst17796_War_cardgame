/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author megha, 2020
 */
public class Card
{
    //default modifier for child classes
    public enum Suit{HEARTS,SPADES,CLUBS,DIAMONDS};
    
    public enum Value{
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);
        private final int value;
        
        private Value(int value) {
        this.value = value;
    }
        public int getValue() {
        return value;
    }
    };
    
    private Suit suit;
    private Value value;
    
     public Card(Suit s, Value v)
        {
            suit=s;
            value=v;
        }
     
     
       /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * @return the value
     */
    public Value getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Value value) {
        this.value = value;
    }
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
@Override
  public String toString()
  {
    return this.value + " of " + this.suit;   
  }
    
}
