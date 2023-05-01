/**
 * This class represents the Odd-Even game
 * 
 * 
 */

import java.util.Scanner;

public class Game{
    
  public int p1Score;
  public int p2Score;
  private Scanner input;
  private double threshold1;
  private double threshold2;
  
  
/* this version of the game constructor is for Part 1
 * it takes no parameters */
    public Game() {
    }
    
// end of constructor
    
/* this version of the game constructor is for Part 2
 * It requires two doubles as parameters. You will use 
 * these to set the initial thresholds for you computer players */
    public Game (double t1, double t2){
        threshold1 = t1;
        threshold2 = t2;
    }
    
// end of constructor
   
/* this version of the play method is for Part 1
 * It takes no parameters and should play one interactive
 * version of the game */
    public void play(){
        System.out.println("Hello! Welcome to OddEven");
        int humanPosition = ChoosePlayer();
        System.out.println("How many rounds would you like to play?");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ComputerPlayer computer = new ComputerPlayer(0.5);
        p1Score = 0;
        p2Score = 0;
        int i = 0;
                
        while (i < n){
        
        System.out.println("Enter '1' or '2'");
        int humanValue = input.nextInt();    
        int computerValue = computer.getChoice();
            
        int sum = humanValue + computerValue;                  
                           
            if (sum % 2 == 0){
                p1Score = p1Score - sum;
                p2Score = p2Score + sum;
            }
            else {
                p1Score = p1Score + sum;
                p2Score = p2Score - sum;
            }
            
                
            if (humanPosition == 1){
                if (p1Score > 0){
                    System.out.println("You win!");
                    System.out.println("Computer Decision: " + computerValue);
                    System.out.println("Computer Player tokens: " + p2Score);
                    System.out.println("Your tokens: " + p1Score);
                }
                else if (p1Score < 0) {
                    System.out.println("Computer Player wins!");
                    System.out.println("Computer Decision: " + computerValue);
                    System.out.println("Computer Player tokens: " + p2Score);
                    System.out.println("Your tokens: " + p1Score);
                }
                else {
                    System.out.println("Player 1 and Player 2 draw!");
                    System.out.println("Computer Decision: " + computerValue);
                    System.out.println("Both players have 0 tokens");
                }
            }
            
            else {
                if (p2Score > 0){
                    System.out.println("You win!");
                    System.out.println("Computer Decision: " + computerValue);
                    System.out.println("Computer Player tokens: " + p1Score);
                    System.out.println("Your tokens: " + p2Score);
                }
                else if (p2Score < 0) {
                    System.out.println("Computer Player wins!");
                    System.out.println("Computer Decision: " + computerValue);
                    System.out.println("Computer Player tokens: " + p1Score);
                    System.out.println("Your tokens: " + p2Score);
                }
                else {
                    System.out.println("Player 1 and Player 2 draw!");
                    System.out.println("Computer Decision: " + computerValue);
                    System.out.println("Both players have 0 tokens");
                }
                i++;    
            }    
        }
        System.out.println("Thanks for playing!");
    }    
        
 // end of method   
    
/** this version of the play method is for Part 2
 * It takes a single int as a parameter which is the
 * number of computer vs. computer games that should be played */
    public void play(int games){
        ComputerPlayer robot1 = new ComputerPlayer(threshold1);
        ComputerPlayer robot2 = new ComputerPlayer(threshold2);
        
        p1Score = 0;
        p2Score = 0;
        int n = 0;
        
        while (n < games){
             int robot1Value = robot1.getChoice();
             int robot2Value = robot2.getChoice();
            
        int robotSum = robot1Value + robot2Value;                  
                           
        if (robotSum % 2 == 0){
            p1Score = p1Score - robotSum;
            p2Score = p2Score + robotSum;
        }
        else {
            p1Score = p1Score + robotSum;
            p2Score = p2Score - robotSum;
        }
            n++;
        }
    }  
    
// end of method    

/* this method should return the current score (number of tokens)
 * that player 1 has */
    public int getP1Score(){
        return p1Score;
    }
 
// end of method    
    
/* this method should return the current score (number of tokens)
 * that player 2 has */
    public int getP2Score(){
        return p2Score;
    }  

// end of method
    
    public int ChoosePlayer (){
        
        System.out.println("Player 1 = Odd Numbers; Player 2 = Even Numbers");
        System.out.println("Select player: '1' for player 1; '2' for player 2");
        Scanner input = new Scanner(System.in);
        int decision = input.nextInt();
        
        while (decision != 1 && decision != 2){
            System.out.println("Please enter either '1' or '2'");
            decision = input.nextInt();
        }
        return decision;
    
    }
        
}


// end of method

// end of class
