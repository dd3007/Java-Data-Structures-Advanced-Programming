
// dd3007, 03/27/2021
// Game object design

import java.util.*;

public class Game {
	
    private Player p;
    private Deck cards;
    private ArrayList <Card> hand;
    private int suit;
    private int rank;
	
	
    public Game(String[] testHand){
        
        p = new Player ();
        cards = new Deck();
        hand = new ArrayList <Card> ();
        
        for (String element : testHand) {
            if (element.charAt(0) == 'c') {
                suit = 1;
            }
            else if (element.charAt(0) == 'd') {
                suit = 2;
            }
            else if (element.charAt(0) == 'h') {
                suit = 3;
            }
            else if (element.charAt(0) == 's') {
                suit = 4;
            }
            
            
            if (element.length() == 2) {
                rank = Integer.parseInt(element.substring(1,2));
            }
            else if (element.length() == 3) {
                rank = Integer.parseInt(element.substring(1,3));
            }
            
        hand.add(new Card (suit, rank));
        }
        
        
        // This constructor is to help test your code.
        // use the contents of testHand to
        // make a hand for the player
        // you must use the following encoding for cards
        // c = clubs
        // d = diamonds
        // h = hearts
        // s = spades
        // 1-13 correspond to ace-king
        // example: s1 = ace of spades
        // example: testhand = {s1, s13, s12, s11, s10} = royal flush
		
    }
	
    public Game(){
        
        p = new Player();
        cards = new Deck();
        hand = new ArrayList <Card> ();
        
        // This no-argument constructor is to actually play a normal game
    }
    
    
    public void play(){
        
        Scanner input = new Scanner (System.in);
        int decision = 1;
        
        System.out.println ("Welcome to Video Poker!");
        
        while (p.getBankroll() > 0 && decision != 0){
        
            System.out.println ("You currently have: " + p.getBankroll() + " tokens");
            System.out.println ("How much would you like to bet? (1-5 tokens)");

            int bet = input.nextInt();

            while (bet > 5 || bet < 1){
                System.out.println ("Enter a number between 1 and 5!");
                bet = input.nextInt();
            }

            p.bets(bet);

            System.out.println ("You now have " + p.getBankroll() + " tokens!");
            System.out.println ("Here is your hand: ");
            
            hand.removeAll(hand);
            hand = cards.createHand();
            cards.displayHand(hand);

            System.out.println ("Enter the position of the card you'd like to replace!");
            System.out.println ("For Card 1, enter 1, for Card 2, enter 2, etc.");
            System.out.println ("If you do not wish to replace anything, enter 0");   

            int position = input.nextInt();

            while (position > 0 || position < 0) {
                
                while (position > hand.size() || position < 0) {
                    System.out.println ("Enter a number between 1 and " + hand.size() + "!" );
                    position = input.nextInt();
                }
                
                while (position > 0) {
                    
                    if (hand.size() > 1) {
                        
                        while (position > hand.size() || position < 0) {
                            System.out.println ("Enter a number between 1 and " + hand.size() + "!" );
                            position = input.nextInt();
                        }

                        cards.removeCard(hand.get(position-1));

                        System.out.println ("Your remaining cards are: ");
                        cards.displayHand(hand);

                        System.out.println ("Enter the position of the card you'd like to replace!");
                        System.out.println ("For Card 1, enter 1, for Card 2, enter 2, etc.");
                        System.out.println ("If you do not wish to replace anything, enter 0");

                        position = input.nextInt();
                    }
                  
                    else {
                        System.out.println ("You have no more cards to replace!");
                        position = 0;
                        break;
                    }  
                }
        }
                
            int handSize = hand.size();
            
            if (handSize < 5) {
                for (int i = 0; i < 5 - handSize; i++){
                    cards.cardDeal();
                }
            }
            
            System.out.println ("This is your new hand:");
            cards.displayHand(hand);
            
            System.out.println ("Your hand is a: ");
            int odds = checkHand();
            p.winnings(odds);
            System.out.println ("You now have: " + p.getBankroll() + " tokens!");
            
            System.out.println ("Would you like to play again?");
            System.out.println ("If yes, enter '1', if no, enter '0'");
            
            decision = input.nextInt();
            
            while (decision < 0 || decision > 1){
                System.out.println ("Uh-oh! Seems you didn't insert a valid number!");
                System.out.println ("Please insert '1' for yes or '0' for no");
                decision = input.nextInt();
            }
        }
        
        System.out.println ("Thanks for playing!");
    }
            
        // this method should play the game	
    
    public void testPlay(){
       
        // this method is used for testing the checkHand method
        // it should evaluate the hand that was passed
        // as a command-line argument and print the result
        
        Scanner input = new Scanner (System.in);

        System.out.println ("The hand you entered is:");

        cards.displayHand(hand);
        
        System.out.println ("Your hand is a: ");
        checkHand();
        
    }
	
	public int checkHand(){
        
        // this method should take an ArrayList of five Card objects as input (we eliminated explicit parameter)
		// evaluate the hand
		// print the result to the console so the user can see it. 
        // return the multiplier that the bet should be multiplied by
        // you'll want to break this up into a bunch of helper methods  
        
        String handResult = "";
        int odds = 0;
        
        if (this.noPair()) {
            handResult = "No Pair :(";
            odds = 0;
        }
                 
        if (this.onePair()) {
            handResult = "One Pair";
            odds = 1;
        }
        
        if (this.twoPairs()) {
            handResult = "Two Pairs";
            odds = 2;
        }
        
        if (this.threeOfAKind()) {
            handResult = "Three of a Kind";
            odds = 3;
        }
        
        if (this.straight()) {
            handResult = "Straight";
            odds = 4;
        }
        
        if (this.flush()) {
            handResult = "Flush";
            odds = 5;
        }
        
        if (this.fullHouse()) {
            handResult = "Full House :)";
            odds = 6;
        }
        
        if (this.fourOfAKind()) {
            handResult = "Four of a Kind :)";
            odds = 25;
        }
        
        if (this.straightFlush()) {
            handResult = "Straight Flush :)";
            odds = 50;
        }
        
        if (this.royalFlush()) {
            handResult = "Royal Flush :D";
            odds = 250;
        }
        
        System.out.println(handResult);
        return odds;
    }
	
    // Helper methods:
        
    public boolean noPair(){
        
        // The lowest hand, containing five separate cards that do not match up
        //to create any of the hands below. 
        
        boolean test = false;
        
        Collections.sort(hand);
        
        if (!onePair() && !twoPairs() && !threeOfAKind() && !straight() && !flush() && !fullHouse() && !fourOfAKind() && !straightFlush() && !royalFlush()){
            test = true;
        }
        return test;
    }
    
    public boolean onePair(){
        
        //Two cards of the same value, for example two queens
        //Payout: 1
        
        boolean test = false;
        int count = 0;
            
        Collections.sort(hand);
        
        for (int i = 0; i < 5; i++) {
            for (int n = i; n < 5; n++) { // n = 0 or n = i
                if (i != n) {
                    if (hand.get(i).getRank() == hand.get(n).getRank()) {
                        count++;
                    }
                }
            }
        }
        
        if (count == 1) {
            test = true;
        }
        
        count = 0;
        return test;    
    }
    
    public boolean twoPairs(){
        
        //Two pairs, for example two queens and two 5’s
        //Payout: 2 
        
        boolean test = false;
        int count = 0;
            
        Collections.sort(hand);
        
        for (int i = 0; i < 5; i++) {
            for (int n = i; n < 5; n++) { // n = 0 or n = i
                if (i != n) {
                    if (hand.get(i).getRank() == hand.get(n).getRank()) {
                        count++;
                    }
                }
            }
        }
        
        if (count == 2) {
            test = true;
        }
        
        count = 0;
        return test;    
    }
    
    public boolean threeOfAKind(){
        
        //Three cards of the same value, for example three queens
        //Payout: 3 
        
        boolean test = false;
        int count = 0;
            
        Collections.sort(hand);
        
        for (int i = 0; i < 5; i++) {
            for (int n = i; n < 5; n++) { // n = 0 or n = i
                if (i != n) {
                    if (hand.get(i).getRank() == hand.get(n).getRank()) {
                        count++;
                    }
                }
            }
        }
        
        if (count == 3) {
            test = true;
        }
        
        count = 0;
        return test;    
    }
    
    public boolean straight(){
        
        //Five cards with consecutive values, not necessarily of the same suit,
        //such as 4, 5, 6, 7, and 8. The ace can either precede a 2 or follow a king
        //Payout: 4 
        
        boolean test = false;
        int firstCount = 0;
        int secondCount = 0;
        
        // if ace = 1
        
        Collections.sort(hand);
        
        for (int i = 0; i < 4; i++) {
            if (hand.get(i).getRank() == hand.get(i+1).getRank() - 1){
                firstCount++;
            }
        }
            
        // if ace = 14
        
        ArrayList <Card> temp = new ArrayList <Card>();
        
        for (int i = 0; i < 5; i++) {
            if (hand.get(i).getRank() > 1){
                temp.add(new Card (hand.get(i).getSuit(), hand.get(i).getRank()));
            }
            else if (hand.get(i).getRank() == 1){
                temp.add(new Card (hand.get(i).getSuit(), 14));
            }
        }
        
        for (int i = 0; i < 4; i++) {    
            if (temp.get(i).getRank() == temp.get(i+1).getRank() - 1){
                secondCount++;
            }
        }
        
        if (firstCount == 4 || secondCount == 4){
            test = true;
        } 
        
        return test;        
    }
    
    public boolean flush(){
        
        //Five cards, not necessarily in order, of the same suit
        //Payout: 5 
        
        boolean test = false;
        for (int i = 0; i < 4; i++) {
            if (hand.get(i).getSuit() == hand.get(i+1).getSuit()) {
                test = true;
                continue;
            }
            else if (hand.get(i).getSuit() != hand.get(i+1).getSuit()) {
                test = false;
                break;
            }
        }
     
        return test;
    }
    
    public boolean fullHouse(){
        
        //Three of a kind and a pair, for example three queens and two 5’s
        //Payout: 6 
        
        boolean test = false;
        int count = 0;
            
        Collections.sort(hand);
        
        for (int i = 0; i < 5; i++) {
            for (int n = i; n < 5; n++) { // n = 0 or n = i
                if (i != n) {
                    if (hand.get(i).getRank() == hand.get(n).getRank()) {
                        count++;
                    }
                }
            }
        }
        
        if (count == 4) {
            test = true;
        }
        
        count = 0;
        return test; 
    }
    
    public boolean fourOfAKind(){
        
        //Four cards of the same value, such as four queens
        //Payout: 25 
        
       boolean test = false;
       int count = 0;
            
        Collections.sort(hand);
        
        for (int i = 0; i < 5; i++) {
            for (int n = i; n < 5; n++) { // n = 0 or n = i
                if (i != n) {
                    if (hand.get(i).getRank() == hand.get(n).getRank()) {
                        count++;
                    }
                }
            }
        }
        
        if (count == 6) {
            test = true;
        }
        
        count = 0;
        return test;
    }
    
    public boolean straightFlush(){
        
        //A straight and a flush: Five cards with consecutive values of
        //the same suit
        //Payout: 50 
        
        boolean test = false;
            
        if (straight() && flush()){
            test = true;
        }
        
        return test;
    }
    
    public boolean royalFlush(){
        
        //The best possible hand in poker. A 10, jack, queen, king, and ace,
        //all of the same suit
        //Payout: 250
        
        boolean test = false;
            
        Collections.sort(hand);
        
        if (flush() && royalTest()) {
            test = true;
        }
            
        return test;
    }
    
    public boolean royalTest() {

        boolean test = false;
        int tens = 0;
        int js = 0;
        int qs = 0;
        int ks = 0;
        int aces = 0;
            
        for (int i = 0; i < 5; i++) {
            if (hand.get(i).getRank() == 10) {
                tens++;
            }
            else if (hand.get(i).getRank() == 11) {
                js++;
            }
            else if (hand.get(i).getRank() == 12) {
                qs++;
            }
            else if (hand.get(i).getRank() == 13) {
                ks++;
            }
            else if (hand.get(i).getRank() == 1 || hand.get(i).getRank() == 14) {
                aces++;
            }
        }
        
        if (tens == 1 && js == 1 && qs == 1 && ks == 1 && aces == 1) {
            test = true;
        } 
        
        return test;
    }

}
