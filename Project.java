/**
 *Project.java
 *Group 6
 *20 3 2020
 */
import java.util.*;

public class ProjectInst {

    //Data Members
    private Random rand;//generate random number for the computer
    private int randNo;//hold the random number after generated
    private String humanSide;//hold the side the human player wants to be
    private int sumFingers;//sum of Fingers played for both players
    private int humanFingers;//hold number entered by the human player
    private String roundSide;//hold the side for one round
    private String roundWinner;//holds who is the winner for an specif round
    private List<String> arrayRoundWinner;
    private List<Integer> arrayRoundWinnerPoints;
    private List<String> arrayHumanSide;
    private List<String> arrayComputerSide;
    private int totalRoundPPoints;
    private int totalRoundCPoints;
    private String computerSide;
    private int humanNumRounds;
    private int computerNumRounds;
    private int pExtraPoints;
    private int cExtraPoints;
    private int totalPExtraPoints;
    private int totalCExtraPoints;

    //contructor
    public ProjectInst() {
        rand = new Random();
        randNo = 0;
        sumFingers = 0;
        humanFingers = 0;
        roundSide = "";
        roundWinner = "";
        arrayRoundWinner = new ArrayList<String>();
        arrayRoundWinnerPoints = new ArrayList<Integer>();
        arrayHumanSide = new ArrayList<String>();
        arrayComputerSide = new ArrayList<String>();
        totalRoundPPoints = 0;
        totalRoundCPoints = 0;
        computerSide = "";
        humanNumRounds = 0;
        computerNumRounds = 0;
        pExtraPoints = 0;
        cExtraPoints = 0;
        totalPExtraPoints = 0;
        totalCExtraPoints = 0;
    }

    //setter
    public void setHumanSide(int humanSide) {
        if (humanSide == 0) {
            this.humanSide = "Even";
        } else if (humanSide == 1) {
            this.humanSide = "Odd";
        } else {
            this.humanSide = "Stop";
        }
    }

    public void setHumanFingers(int humanFinger) {
        this.humanFingers = humanFinger;
    }

    //Define which is the computer side based on the humanSide
    public void computerSide() {
        switch (this.humanSide) {
            case "Even":
                computerSide = "Odd";
                break;
            case "Odd":
                computerSide = "Even";
                break;
            default:
                computerSide = "Stop";
                break;
        }
    }

    //generate random number
    public void computeRandNo() {
        randNo = rand.nextInt(10 - 1) + 1;
    }

    //check evens and odds for each player
    int oddHCount, evenHCount = 0;
    int oddCCount, evenCCount = 0;
    public void evenOddCount() {
        arrayHumanSide.forEach((arrayHumanSide1) -> {
            if (arrayHumanSide1.equals("Odd")) {
                oddHCount=oddHCount+1;
            } else if (arrayHumanSide1.equals("Even")) {
                evenHCount=evenHCount+1;
            }
        });
        arrayComputerSide.forEach((arrayComputerSide1) -> {
            if (arrayComputerSide1.equals("Odd")){
                oddCCount=oddCCount+1;
            }
            else if(arrayComputerSide1.equals("Even")){
                evenCCount=evenCCount+1;
            }
        });

    }

    //check who gets the extra point and how many extra point each player received
    public void extraPoints() {
        if (humanFingers > randNo) {
            pExtraPoints = 2;
            cExtraPoints = 0;
            totalRoundPPoints = totalRoundPPoints + pExtraPoints;
            totalRoundCPoints = totalRoundCPoints + cExtraPoints;
            totalPExtraPoints = totalPExtraPoints + pExtraPoints;
            totalCExtraPoints = totalCExtraPoints + cExtraPoints;

        } else if (humanFingers == randNo) {
            pExtraPoints = 2;
            cExtraPoints = 2;
            totalRoundPPoints = totalRoundPPoints + pExtraPoints;
            totalRoundCPoints = totalRoundCPoints + cExtraPoints;
            totalPExtraPoints = totalPExtraPoints + pExtraPoints;
            totalCExtraPoints = totalCExtraPoints + cExtraPoints;
        } else {
            pExtraPoints = 0;
            cExtraPoints = 2;
            totalRoundCPoints = totalRoundCPoints + cExtraPoints;
            totalRoundPPoints = totalRoundPPoints + pExtraPoints;
            totalPExtraPoints = totalPExtraPoints + pExtraPoints;
            totalCExtraPoints = totalCExtraPoints + cExtraPoints;
        }
    }

    //check if the round is Even or Odd
    public void evenOddTest() {
        sumFingers = humanFingers + randNo;
        if (sumFingers % 2 == 0) {
            roundSide = "Even";
        } else {
            roundSide = "Odd";
        }
    }

    //even numbers by player
    //odd numbers by player
    //check how many times each player on the game
    public void winnerOfRound() {
        if (totalRoundPPoints > totalRoundCPoints) {
            humanNumRounds = humanNumRounds + 1;
            computerNumRounds = computerNumRounds + 0;
        } else if (totalRoundPPoints == totalRoundCPoints) {
            humanNumRounds = humanNumRounds + 0;
            computerNumRounds = computerNumRounds + 0;
        } else {
            humanNumRounds = humanNumRounds + 0;
            computerNumRounds = computerNumRounds + 1;
        }
    }

    //check who is the winner of the round
    public void compute() {
        computerSide();
        computeRandNo();
        evenOddTest();

        sumFingers = humanFingers + randNo;

        if (this.humanSide == roundSide) {
            roundWinner = "Player";
            arrayRoundWinner.add("Player");
            arrayRoundWinnerPoints.add(3);
            arrayHumanSide.add(humanSide);
            arrayComputerSide.add(computerSide);
            totalRoundPPoints = totalRoundPPoints + 3;
            extraPoints();
            winnerOfRound();

        } else {
            roundWinner = "Computer";
            arrayRoundWinner.add("Computer");
            arrayRoundWinnerPoints.add(3);
            arrayComputerSide.add(computerSide);
            arrayHumanSide.add(humanSide);
            totalRoundCPoints = totalRoundCPoints + 3;
            extraPoints();
            winnerOfRound();
        }
evenOddCount();
    }

//getter
    public String getRoundWinner() {
        return roundWinner;
    }

    public List<String> getArrayRoundWinner() {
        return arrayRoundWinner;
    }

    public List<Integer> getArrayRoundWinnerPoints() {
        return arrayRoundWinnerPoints;
    }

    public int getTotalRoundPPoints() {
        return totalRoundPPoints;
    }

    public int getTotalRoundCPoints() {
        return totalRoundCPoints;
    }

    public List<String> getArrayHumanSide() {
        return arrayHumanSide;
    }

    public List<String> getArrayComputerSide() {
        return arrayComputerSide;
    }

    public int getRandNo() {
        return randNo;
    }

    public String getHumanSide() {
        return humanSide;
    }

    public String getComputerSide() {
        return computerSide;
    }

    public int getHumanNumRounds() {
        return humanNumRounds;
    }

    public int getComputerNumRounds() {
        return computerNumRounds;
    }

    public int getTotalPExtraPoints() {
        return totalPExtraPoints;
    }

    public int getTotalCExtraPoints() {
        return totalCExtraPoints;
    }

    public int getOddHCount() {
        return oddHCount;
    }

    public int getEvenHCount() {
        return evenHCount;
    }

    public int getOddCCount() {
        return oddCCount;
    }

    public int getEvenCCount() {
        return evenCCount;
    }
    

}
