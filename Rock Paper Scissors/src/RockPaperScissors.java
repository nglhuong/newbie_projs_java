import java.util.Random;

public class RockPaperScissors {
    private static final String[] computerChoices = {"Rock", "Paper", "Scissors"};

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    private String computerChoice;

    private int computerScore, playerScore;

    private Random random;

    // constructor to initialize random obj
    public RockPaperScissors(){
        random = new Random();
    }

    public String playRockPaperScissors(String playerChoice){
        // generate computer's choice
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        String result;

        if (computerChoice.equals("Rock")){
            if (playerChoice.equals("Paper")){
                result = "Player wins";
                playerScore++;
            } else if (playerChoice.equals("Scissors")){
                result = "Computer wins";
                computerScore++;
            } else result = "Draw";
        } else if (computerChoice.equals("Paper")){
            if (playerChoice.equals("Scissors")){
                result = "Player wins";
                playerScore++;
            } else if (playerChoice.equals("Rock")){
                result = "Computer wins";
                computerScore++;
            } else result = "Draw";
        } else {
            if (playerChoice.equals("Rock")){
                result = "Player wins";
                playerScore++;
            } else if (playerChoice.equals("Paper")){
                result = "Computer wins";
                computerScore++;
            } else result = "Draw";
        }

        return result;
    }
}
