/**
 * This class should run simulations to determine
 * whether or not the Odd-Even game is fair and if
 * not who has the advantage and what is a strategy
 * that will realize that adavantage.
 * 
 * 
 */

import java.util.Scanner;

public class Simulation{
    
    public static void main(String[] args){
        
        double t1 = 0; // threshold 1
        double t2 = 0; // threshold 2
        System.out.println("Insert number of games");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int maxMin = 0;
        int rowMin = 10;
        int minMax = 0;
        int columnMax = -10;
        double t1Optimal = 0;
        double t2Optimal = 0;
        
        while (t1 < 1) {
            while (t2 < 1){
            Game g = new Game(t1, t2); 
            g.play(n);
            int score = g.getP1Score();
            rowMin = Math.min(score, rowMin);    
            if (rowMin > maxMin){
                maxMin = rowMin;
                t1Optimal = t1;
                System.out.println(t1Optimal);
            }
            t2 = t2 + 0.05;    
            }
            t2 = 0;
            t1 = t1 + 0.05;
        }

        while (t2 < 1) {
            while (t1 < 1){
            Game g = new Game(t1, t2); 
            g.play(n); // Use n = 100.000 for accurate results
            int score = g.getP2Score();
            columnMax = Math.max(score, columnMax);    
            if (columnMax < minMax){
                minMax = columnMax;
                t2Optimal = t2;
                System.out.println(t2Optimal);
            }
            t1 = t1 + 0.05;    
            }
            t1 = 0;
            t2 = t2 + 0.05;
        }


        if (maxMin > 0) {
        System.out.println("Player 1 has an advantage at " + t1Optimal);
        System.out.println("The game is unfair!");
        }    

        else if (minMax < 0) {
        System.out.println("Player 2 has an advantage at " + t2Optimal);
        System.out.println("The game is unfair!");
        }

        else if (maxMin <= 0 && minMax >= 0) {
        System.out.println("The game is fair! No player has an advantage");
        }   
    }
}
