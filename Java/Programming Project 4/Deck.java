
// dd3007, 03/27/2021
// Deck object design

import java.util.*;

public class Deck {
	
    private Card[] cards;
    private int top; //the index of the top of the deck
    private ArrayList <Card> hand;
    
    // we'll be incrementing top when exchanging cards
    //add more instance variables if needed
	
    public Deck(){
        
        //make a 52 card deck here 
        // change to array, 52 cards
        
        cards = new Card [52];
        hand = new ArrayList <Card> ();
        int top = 0;
        int index = 0;
        
        for (int s = 1; s < 5; s++){
            for (int r = 1; r <14; r++){
                cards[index] = new Card(s, r);
                index++;
            }
        }
    }
	
    public void shuffle(){
        
        //shuffle the deck here
        
        List <Card> cardsArrayList = new ArrayList <Card>();
        for (Card element: cards) {
            cardsArrayList.add(element);
        }
        Collections.shuffle(cardsArrayList);
        cardsArrayList.toArray(cards);
    }
    
    public Card cardDeal (){
        
        Card topCard = cards[top];
        hand.add(topCard);
        top++;
        
        if (top > 51) {
            shuffle();
            top = 0;
        }
        
        return topCard;
        
        // deal a single card here
        // top incremented inside of deal (top = index of next card to be dealt)
    }
    
    public ArrayList<Card> createHand(){
         
         shuffle();
         
         for (int n = 0; n < 5; n++) {
         cardDeal();
         }
         
         return hand;
     }
    
    public void displayHand (ArrayList <Card> hand){ // should I keep "hand" as an explicit parameter?
        
        for (int i = 0; i < hand.size(); i++){
            System.out.println (hand.get(i).toString());
        }
    }
    
    public void removeCard (Card c) {
        hand.remove(c);
    }
    //add more methods here if needed
}
