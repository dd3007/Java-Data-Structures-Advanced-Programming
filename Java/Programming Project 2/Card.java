
// dd3007, 03/27/2021
// Card object design

public class Card implements Comparable<Card>{
	
    private int suit; //use integers 1-4 to encode the suit
    private int rank; //use integers 1-13 to encode the rank
	
    public Card(int s, int r){
        
        //make a card with suit s and rank r
        
        this.suit = s;
        this.rank = r;
    }
    
    
    public int compareTo(Card c){
        
        //use this method to compare cards so they 
        //may be easily sorted
        
        int answer = 0;
        
        if (this.rank < c.rank){
            answer = -1;
        }
        if (this.rank > c.rank){
            answer = 1;
        }
        if (this.rank == c.rank){
            if (this.suit < c.suit){
                answer = -1;
            }
            if (this.suit > c.suit){
                answer = 1;
            }
            if (this.suit == c.suit){
                answer = 0; // should never be returned
            }
        }
        return answer;
    }

    
    public String toString(){
        
        //use this method to easily print a Card object
        
        String suitName = "";
        String rankName = "";
        
        if (suit == 1){
        suitName = "Clubs";
        }
        else if (suit == 2){
        suitName = "Diamonds";    
        }
        else if (suit == 3){
        suitName = "Hearts";     
        }
        else if (suit == 4){
        suitName = "Spades";
        }
        
        if (rank == 1 || rank == 14){
        rankName = "Ace of ";
        }
        else if (rank == 11){
        rankName = "J of ";
        }
        else if (rank == 12){
        rankName = "Q of ";
        }
        else if (rank == 13){
        rankName = "K of ";
        }
        else {
        rankName = rank + " of ";
        }
        
        String description = rankName + suitName;
        return description;
    }

    public int getSuit() {
        return suit;
    }
    
    public int getRank() {
        return rank;
    }
}
