/**
 *ProjectApp.java
 *Group 6
 *20 3 2020
 */
import java.util.*;
import javax.swing.*;

public class ProjectApp {

    public static void main(String[] args) {

        //variables
        int humanSide;
        int humanFingers;
        List<String> listRounds = new ArrayList<String>();
        int totalRoundPPoints;
        int totalRoundCPoints;
        int askReplay;
        int randNo;
        String roundWinner;
        String computerSide;
        String humanSideSt;
        int computerNumRounds;
        int humanNumRounds;
        int totalPExtraPoints, totalCExtraPoints;
        int oddHCount, evenHCount, oddCCount, evenCCount;

        //objects
        Object[] options1 = {"Even", "Odd", "Stop"};//0=Even 1=Odd 2=Stop
        Object[] options2 = {">", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, "<"};
        ProjectInst myProjectInst = new ProjectInst();

        do {
            totalRoundPPoints = myProjectInst.getTotalRoundPPoints();
            totalRoundCPoints = myProjectInst.getTotalRoundCPoints();
            humanSide = JOptionPane.showOptionDialog(null, "Choose Even or Odd to Play the Game. \n\nPress STOP to exit the game.", "User's side", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
            if (humanSide != 2 && totalRoundPPoints < 12 && totalRoundCPoints < 12) {
                myProjectInst.setHumanSide(humanSide);
                humanFingers = JOptionPane.showOptionDialog(null, "Choose Between the numbers below: ", "User's choice", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, null);
                if (humanFingers >= 1 && humanFingers <= 10) {
                    myProjectInst.setHumanFingers(humanFingers);

                    myProjectInst.compute();
                    totalRoundCPoints = myProjectInst.getTotalRoundCPoints();
                    totalRoundPPoints = myProjectInst.getTotalRoundPPoints();
                    roundWinner = myProjectInst.getRoundWinner();
                    computerSide = myProjectInst.getComputerSide();
                    humanSideSt = myProjectInst.getHumanSide();
                    randNo = myProjectInst.getRandNo();
                    
                    //displays: computer's choice + n points each player + who won the round
                    JOptionPane.showMessageDialog(null, "Numbers: Computer " + randNo + " x " + humanFingers + " Player" + "\n" + "Side: Computer " + computerSide + " x " + humanSideSt + " Player" + "\nMarks: Computer " + totalRoundCPoints + " x " + totalRoundPPoints + " Player" + "\n" + "Winner:>> " + roundWinner + "<<");
                }

            }
        } while (humanSide != 2 && totalRoundPPoints < 12 && totalRoundCPoints < 12);
        
        
        if (humanSide != 2) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            askReplay = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "WARNING", dialogButton);
            if (askReplay == 0) {
                main(null);
            } else {
                JOptionPane.showMessageDialog(null, "Thank you for playing!");
            }
        }

        List<String> arrayRoundWinner = myProjectInst.getArrayRoundWinner();
        List<Integer> arrayRoundWinnerPoints = myProjectInst.getArrayRoundWinnerPoints();
        List<String> arrayHumanSide = myProjectInst.getArrayHumanSide();
        String resultRound = "";
        computerNumRounds=myProjectInst.getComputerNumRounds();
        humanNumRounds=myProjectInst.getHumanNumRounds();
        totalPExtraPoints=myProjectInst.getTotalPExtraPoints();
        totalCExtraPoints=myProjectInst.getTotalCExtraPoints();
        oddHCount=myProjectInst.getOddHCount();
        oddCCount=myProjectInst.getOddCCount();
        evenCCount=myProjectInst.getEvenCCount();
        evenHCount=myProjectInst.getEvenHCount();
        for (int i = 0; i < arrayRoundWinner.size(); i++) {
            resultRound = resultRound + "\n" + arrayRoundWinner.get(i) + " " + arrayRoundWinnerPoints.get(i) + " " + arrayHumanSide.get(i);
        }
        
        listRounds.add(resultRound);
        for (int i = 0; i < listRounds.size(); i++) {
            JOptionPane.showMessageDialog(null, "Round " + (i + 1) + "\n" + listRounds.get(i)+"\n"+"Player won "+humanNumRounds+" and lost "+computerNumRounds+"\nExtra Point: Player "+totalPExtraPoints+" x "+totalCExtraPoints+" Computer" + "\nEven: Player "+evenHCount+" x "+evenCCount+" Computer"+"\nOdd: Player "+oddHCount+" x "+oddCCount+" Computer");
        }

    }

}
