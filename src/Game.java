import java.util.Scanner;
public class Game {
// declaring a final value to be used all over the program instead of using
// magic numbers
	public static final int MAX_COMPETITOR_NUMBER = 2;
// taking the inputs from the key board
	public static final Scanner sc = new Scanner(System.in);
// declaring the inputs
	public static int competitorNumber[] = new int[MAX_COMPETITOR_NUMBER];
	public static String competitorName[] = new String[MAX_COMPETITOR_NUMBER];
	public static int competitorAge[] = new int[MAX_COMPETITOR_NUMBER];
	public static int numberOfCoins[] = new int[MAX_COMPETITOR_NUMBER];
	public static int scoreAchieved[] = new int[MAX_COMPETITOR_NUMBER];
	public static int distanceReached[] = new int[MAX_COMPETITOR_NUMBER];
	public static int topRankings[] = new int[3];

	public static void main(String[] args) {
		mainMenu();
		getInput();
		max();
		selectedWinner();// calling the switch case to view the menu
	}

	public static void mainMenu() {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("                   ********* ******** ****  **** ********  ****     ********     ********   ****  **** **** *****");
		System.out.println("                   ********* ******** ****  **** ****  *** ****     ********     ****  ***  ****  **** ****  ****");
		System.out.println("                      ***    *****    *** ** *** ****  *** ****     ****         ****  ***  ****  **** *  **  ***");
		System.out.println("                      ***    *****    ****  **** ********  ****     ****         ********   ****  **** **  **  **");
		System.out.println("                      ***    ******** ****  **** ****      ******** ********     *********  ********** ***  *****");
		System.out.println("                      ***    ******** ****  **** ****      ******** ********     ****  ****  ********  ****  ****");
		System.out.println("*************************************************Insert competitor information to get started***********************************************");
		System.out.println("*******************************************You can insert competitor information upto 20 competitors****************************************");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
	}

	/**
	 * to get inputs about twenty competitors of who played temple run the
	 * information required from a single competitor are competitor
	 * number,competitor name,competitor age,number of coins earned,score and
	 * the distance competitor reached
	 */

	public static void getInput() {
		for (int i = 0; i < MAX_COMPETITOR_NUMBER; i++) {
// Taking the inputs
			System.out.println("******Competitor " + (i + 1) + "******");
			System.out.println("------------------------------------enter competitor number-------------------------------------------");
			competitorNumber[i] = inputValidation();
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			sc.nextLine();
			System.out.println("-------------------------------------enter competitor name-------------------------------------------");
			competitorName[i] = sc.nextLine();
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------enter competitor age--------------------------------------------");
			competitorAge[i] = inputValidation();
			// age validation-not letting to input age less than 0 and higher than 100
			while (competitorAge[i] < 0 || competitorAge[i] > 100) {
				System.out.println("Invalid age-please re-enter a valid age");
				competitorAge[i] = inputValidation();
			}
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("---------------------------enter the number of coins competitor earned--------------------------------");
			numberOfCoins[i] = inputValidation();
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("--------------------------enter the score achieved by the competitor----------------------------------");
			scoreAchieved[i] = inputValidation();
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("----------------------------enter the distance competitor achieved------------------------------------");
			distanceReached[i] = inputValidation();
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}
// to display all the competitor details at once
	public static void displayAll() {
		System.out.printf("%-20s%-20s%-10s%-20s%-20s%-20s\n", "Competitor Number", "Competitor Name", "Age",
				"Number Of Coins", "Score Achieved", "Distance Reached");
		for (int i = 0; i < MAX_COMPETITOR_NUMBER; i++) {
			System.out.printf("%-20d%-20s%-10d%-20d%-20d%-20d \n", competitorNumber[i], competitorName[i],
					competitorAge[i], numberOfCoins[i], scoreAchieved[i], distanceReached[i]);
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	// to find the maximum scores have earned under number of coins, the score
	// and the distance achieved
	public static void max() {
		int maxOfCoins = numberOfCoins[0];
		topRankings[0] = 0; // max coins
		int maxScoreAchieved = scoreAchieved[0];
		topRankings[1] = 0; // max score
		int maxDistanceReached = distanceReached[0];
		topRankings[2] = 0; // max distance

		for (int i = 1; i < MAX_COMPETITOR_NUMBER; i++) {
			if (numberOfCoins[i] > maxOfCoins) {
				maxOfCoins = numberOfCoins[i];
				topRankings[0] = i;
			}
			if (scoreAchieved[i] > maxScoreAchieved) {
				maxScoreAchieved = scoreAchieved[i];
				topRankings[1] = i;
			}
			if (distanceReached[i] > maxDistanceReached) {
				maxDistanceReached = distanceReached[i];
				topRankings[2] = i;
			}

		}

	}

	// display the three winners altogether
	public static void displayMax() {
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Max of Coins " + competitorName[topRankings[0]]);
		System.out.println("Max of Score " + competitorName[topRankings[1]]);
		System.out.println("Max of Distance " + competitorName[topRankings[2]]);
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------");
	}

	// displaying individual competitor details as the viewer needs
	public static void findCompetitor() {
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("Enter competitor number");
		int inputNum = inputValidation();
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------");

		int storedNum = -1;
		for (int i = 0; i < MAX_COMPETITOR_NUMBER; i++) {
			if (competitorNumber[i] == inputNum) {
				storedNum = i;
				break;
			}
		}
		if (storedNum == -1) {
			System.out.println("Input is not valid.Again input!");
		} else {
			System.out.println(" Competitor Number :" + competitorNumber[storedNum] + " Competitor Name :"
					+ competitorName[storedNum] + " Age :" + competitorAge[storedNum] + " Number Of Coins :"
					+ numberOfCoins[storedNum] + " Score Achieved :" + scoreAchieved[storedNum] + " Distance Reached :"
					+ distanceReached[storedNum]);
		}
	}

	// menu
	public static void selectedWinner() {
		System.out.println("1)If you want to display all the competitor details altogether input '1'");
		System.out.println("2)If you want to view the winner of Highest Score input '2'");
		System.out.println("3)If you want to view the winner of Maximum Distance Achieved input '3'");
		System.out.println("4)If you want to view the winner of Maximum Coins Collected input '4'");
		System.out.println("5)If you want to diplay all the three winners under the given titles 'Max of Coins', 'Max of Score', 'Max of Distance' input '5'");
		System.out.println("6)If you want to find a certain competitor details input '6'");
		System.out.println("7)If you want to **EXIT** the program input '7' ");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");

		int input = inputValidation();

		switch (input) {
		case 1:
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			displayAll();
			break;
		case 2:
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(competitorName[topRankings[1]]);// score
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			break;
		case 3:
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(competitorName[topRankings[2]]);// distance
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			break;
		case 4:
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(competitorName[topRankings[0]]);// coins
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			break;
		case 5:
			displayMax();
			break;
		case 6:
			findCompetitor();
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			break;
		case 7:
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Thankyou!");
			System.exit(0);
			break;
		default:
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Invalid Input");
		}
		selectedWinner();
	}
	public static int inputValidation() {
		int number;
		do {
			System.out.println("Please input the correct positive integer");
			while (!sc.hasNextInt()) {
				System.out.println("Input is invalid!Please re-enter the correct positive integer ");
				sc.next();
			}
			number = sc.nextInt();
		} while (number <= 0);
		// System.out.println(number);
		return number;
	}

}
