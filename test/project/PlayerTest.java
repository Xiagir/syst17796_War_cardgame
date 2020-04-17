/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Maxim
 */
public class PlayerTest {
    private Player player;
    Deck deck;
    
    public PlayerTest() {
        player = new Player("Tester");
        deck = new Deck();
        deck.generateDeck();
    }
    

    /**
     * Test of playCard method, of class Player.
     */
    @Test
    public void testPlayCardGood() { // if last card of deck == to played card
        boolean expectedResult = true;
        boolean finalResult = false;
        System.out.println("playCardGood");
        Card expectedCard = deck.getCard(deck.getSize() - 1); // last card of the deck
        player.collectCard(deck.removeFromTop());
        Card cardResult = player.playCard();
        if(expectedCard.toString().equals(cardResult.toString())) {
            finalResult = true;
        }
        assertEquals(expectedResult, finalResult);
    }
    
      @Test
    public void testPlayCardBad() { // if 5th card of deck != to played card
        boolean expectedResult = false;
        boolean finalResult = false;
        System.out.println("playCardBad");
        Card expectedCard = deck.getCard(5); // fifth card of the deck
        player.collectCard(deck.removeFromTop());
        Card cardResult = player.playCard();
        if(expectedCard.toString().equals(cardResult.toString())) {
            finalResult = true;
        }
        assertEquals(expectedResult, finalResult);
    }
    
    
    @Test
    public void testPlayCardBoundary() { // if 3rd last card of deck == to 3rd played card
        boolean expectedResult = true;
        boolean finalResult = false;
        System.out.println("playCardBoundary");
        Card expectedCard = deck.getCard(deck.getSize() - 3); // last 3rd card of the deck
        player.collectCard(deck.removeFromTop()); //asking player to collect 3 cards from top of the deck
        player.collectCard(deck.removeFromTop());
        player.collectCard(deck.removeFromTop());
        player.playCard();
        player.playCard();
        Card cardResult = player.playCard(); //player plays 3 cards and we compare 3rd played card to 3rd last card of the deck
        if(expectedCard.toString().equals(cardResult.toString())) {
            finalResult = true;
        }
        assertEquals(expectedResult, finalResult);  
    }

    
}
