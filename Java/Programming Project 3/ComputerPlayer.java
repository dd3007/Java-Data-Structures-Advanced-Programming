/**
 * This class represents a computer
 * player in the Odd-Even game
 * 
 *  
 */

public class ComputerPlayer{
    
    private double t;
    private double value;
    public int choice;
    
    public ComputerPlayer(double threshold){
        t = threshold;
        }
    
    public int ComputerPlay() {
        value = Math.random();
        
            if (value >= t) {
                choice = 2;
            }
            
            else {
                choice = 1;
            }
            return choice;
    }     
            
    public int getChoice(){
        return ComputerPlay();
    }
}

// end of class
