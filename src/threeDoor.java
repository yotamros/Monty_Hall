/*
 * The goal of this program is to simulate the Monty Hall problem: 
 * http://en.wikipedia.org/wiki/Monty_Hall_problem
 * The program runs the experiment in two different ways.  First, it doesn't
 * allow the virtual participant to switch from the original choice of doors.  
 * The second variation forces the virtual participant to switch doors.  
 */

import java.util.Random;

public class threeDoor {
    public static void main(String[] args) {
        threeDoor td = new threeDoor();
        int numberOfTimesToRun = 10000;
        td.runWithoutSwitchingDoors(numberOfTimesToRun);
        td.runWithSwitchingDoors(numberOfTimesToRun);
    }
    int noSwitchWinner = 0;
    int switchWinner = 0;
    
    /*
     * Runs the experiment x amount of times without letting the virtual 
     * participant switch doors, ie. if the virtual participant original door  
     * choice was the winning door he/she is a winner, otherwise a loser.
     * @Param int times, the number of times to run the experiment. 
     */
    private void runWithoutSwitchingDoors(int times) {
        for (int i = 0; i < times; i++) {
            int winningDoor = assignRandomDoor(1, 3);
            int chosenDoor = assignRandomDoor(1, 3);
            if (winningDoor == chosenDoor) {
                noSwitchWinner++;
            }
        }
        printStats(noSwitchWinner, times, false);
    }
    
    /*
     * Runs the experiment x amount of times while forcing the virtual 
     * participant to switch doors, ie. if the virtual participant original door  
     * choice was the winning door he/she is a loser, otherwise a winner.
     * @param int times, the number of times to run the experiment. 
     */
    private void runWithSwitchingDoors(int times) {
        for (int i = 0; i < times; i++) {
            int winningDoor = assignRandomDoor(1, 3);
            int chosenDoor = assignRandomDoor(1, 3);
            if (winningDoor != chosenDoor) {
                switchWinner++;
            }
        }
        printStats(switchWinner, times, true);
    }
    
    /*
     * Prints the stats of the experiment
     * @Param int winner, number of times virtual user won.
     * @Param int times, number of times the experiment was conducted.
     * @Param boolean switchdoor, true if virtual user was forced to switch 
     * doors, false if user kept the original door choice. 
     */
    private void printStats(int winner, int times, boolean switchdoor) {
        System.out.println("=====================================");
        if (switchdoor == true) {
            System.out.println("Stats of player who switched doors:");
        } else {
            System.out.println("Stats of player who didn't switched doors:");
        }
        System.out.println("winner: " + winner);
        System.out.println("loser: " + (times-winner));
    }
    
    /*
     * Assigns random doors within the range of 1 and 3.
     * @param int min, the min value to chose from.
     * @param int max, the max value to chose from.
     */
    private int assignRandomDoor(int min, int max) {
        Random rand = new Random();
        int randomDoor = rand.nextInt((max - min) + 1) + min;
        return randomDoor;
    }
}
