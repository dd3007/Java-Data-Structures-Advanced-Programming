
// dd3007, 03/27/2021
// Player object design

public class Player {
	
    public int bankroll;
    private int bet;

    //you may choose to use more instance variables
		
    public Player(){		
        
        bankroll = 100;
        bet = 0;
    }
    
    public void bets(int amt){
        
        bankroll = bankroll - amt;
        bet = amt;
    }

    public void winnings(int odds){
        bankroll = bankroll + (odds * bet);
    }

    public int getBankroll(){
        return bankroll;
    }
    //you may wish to use more methods here
}


