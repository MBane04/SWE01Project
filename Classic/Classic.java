package Classic;
import java.util.Random;
import java.util.Scanner;

public class Classic {
	static int round = 1;
	int playerWins = 0;
	int cpuWins = 0;
	String playerMove = "rock";
	String cpuMove = "rock";
	
	//every round get the player and CPU move, then check who won and increment the round
	String newRound()
	{
		System.out.println("Round: "+round);
		playerMove = getPlayerMove();
		cpuMove = getCpuMove();
		System.out.print("CPU move: ");
		//pause for dramatic effect:
		try {
			  Thread.sleep(1000);
			} catch (InterruptedException e) {
			  Thread.currentThread().interrupt();
			}
		System.out.println(cpuMove);
		String winner = checkResult(playerMove, cpuMove);
		if(winner.equals("player")) {
			playerWins++;
		} else if(winner.equals("computer")) {
			cpuWins++;
		}
		round++;
		return winner;
	}
	
	//takes the player move and checks for validation
	//any case works and allows for redo's on input to prevent progress loss
	String getPlayerMove()
	{
		System.out.println("Enter your move: ");
		Scanner in = new Scanner(System.in);
		String pMove = in.nextLine().toLowerCase();
		if (inputFlag(pMove) == false)
			return pMove;
		else 
		{
			System.out.println("Incorrect input");
			return getPlayerMove();
		}
	}
	
	//RNG that converts the found integers to strings
	String getCpuMove()
	{
		Random rand = new Random();
		int cpuMoveint = rand.nextInt(3);
		if(cpuMoveint == 0)
			return "rock";
		else if(cpuMoveint ==1)
			return "paper";
		else
			return "scissors";
	}
	
	//input validation
	boolean inputFlag(String check)
	{
		boolean flag = true;
		if (check.equals("rock") || check.equals("paper") || check.equals("scissors"))
			flag = false;
		return flag;
	}
	
	//Figures out who won
	public String checkResult(String player, String CPU)
	{
		String winner;
	    if (playerMove.equals(CPU)) {
	        winner = "tie";
	        } else if (player.equals("rock") && CPU.equals("scissors")) {
	            winner = "player";
	        } else if (player.equals("scissors") && CPU.equals("paper")) {
	            winner = "player";
	        } else if (player.equals("paper") && CPU.equals("rock")) {
	            winner = "player";
	        } else {
	            winner = "computer";
	        }
	    return winner;
	}
	
	public static void main(String[] args) 
	{
		Classic game = new Classic();
		String playAgain = "yes";
		Scanner in = new Scanner(System.in);
		
		while(playAgain.equals("yes")) {
			String winner = game.newRound();
			//pause to give player time to read cpu move before result
			try {
				  Thread.sleep(1000);
				} catch (InterruptedException e) {
				  Thread.currentThread().interrupt();
				}
			System.out.println("The winner is: " + winner+"\n");
			//another pause before asking to play again
			try {
				  Thread.sleep(1000);
				} catch (InterruptedException e) {
				  Thread.currentThread().interrupt();
				}
			
			//every odd round, see if the player wants to continue
			if(game.round % 2 == 0) {
				System.out.println("Want to go for best " + game.round + "/" + (game.round + 1) + "? (yes/no)");
				playAgain = in.nextLine().toLowerCase();
			}
		}
		in.close();
		
		//display who the overall winner was between the games
		if(game.playerWins > game.cpuWins) {
			System.out.println("The overall winner is: Player");
		} else if(game.cpuWins > game.playerWins) {
			System.out.println("The overall winner is: Computer");
		} else {
			System.out.println("It's a tie!");
		}
		System.out.println("Thanks for playing!");
	}
}
