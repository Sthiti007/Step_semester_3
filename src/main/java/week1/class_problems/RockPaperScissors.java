package session1.class_problems;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random rand = new Random();
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            String computerMove = moves[rand.nextInt(3)];
            String result = playRound(playerMoves[i], computerMove);
            System.out.println("Round " + (i + 1) + " - Player: " + playerMoves[i] + ", Computer: " + computerMove + " | " + result);
            
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }
        
        double winPercentage = (wins / 5.0) * 100;
        System.out.println("Final Summary | Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
}