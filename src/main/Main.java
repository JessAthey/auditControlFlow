package main;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AsciiChars.printNumbers();
		//AsciiChars.printUpperCase();
		//AsciiChars.printLowerCase();

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String name = input.nextLine();
		System.out.println("Hello " + name);

		while (true) {
			System.out.println("Do you want to continue? (y/n)");
			String response = input.nextLine();
			if (response.equalsIgnoreCase("n")) {
				System.out.println("Exiting the program.");
				break;
			}
			if (response.equalsIgnoreCase("y")) {

				ArrayList<Integer> nonMagicNums = new ArrayList<Integer>();

				System.out.println("Continuing the program");
				System.out.println("Do you have a red car? (y/n)");
				String redCar = input.nextLine();
				System.out.println("What is the name of your favorite pet?");
				String petName = input.nextLine();

				nonMagicNums.add(Character.getNumericValue(petName.trim().charAt(2)));

				// System.out.println(nonMagicNums.get(0)); Making sure previous code returned a
				// valid integer

				System.out.println("What is " + petName + "'s age?");
				int petAge = input.nextInt();
				input.nextLine(); // consume the newline character left in input buffer
				System.out.println("What is your lucky number?");
				int luckyNum = input.nextInt();
				input.nextLine(); // consume the newline character left in input buffer
				System.out.println("Do you have a favorite quarterback? (y/n)");
				String favQB = input.nextLine();
				Random random = new Random();
				ArrayList<Integer> lotteryNums = new ArrayList<Integer>();

				for (int i = 0; i < 4; i++) {
					int randomNum = random.nextInt(65) + 1;
					lotteryNums.add(randomNum);
				}
				// System.out.println(lotteryNums.size()); verifying data is present in array
				// list
				int magicBall = 0;

				if (favQB.equalsIgnoreCase("y")) {
					System.out.println("What is their jersey number?");
					int jerseyNum = input.nextInt();

					input.nextLine(); // consume the newline character left in input buffer

					int randomIndex = random.nextInt(lotteryNums.size());
					int randomNum = lotteryNums.get(randomIndex);

					magicBall = (jerseyNum * randomNum) % 75;
					nonMagicNums.add(randomNum - randomIndex);

					lotteryNums.add(magicBall);
					//System.out.println("Magic Ball: " + magicBall);
					// System.out.println(lotteryNums.size());

				} else if (favQB.equalsIgnoreCase("n")) {
					int randomIndex = random.nextInt(lotteryNums.size());
					int randomNum = lotteryNums.get(randomIndex);

					magicBall = (luckyNum * randomNum) % 75;
					lotteryNums.add(magicBall);
					// System.out.println("Magic Ball: " + magicBall);
					// System.out.println(lotteryNums.size());
					System.out.println("No worries! Moving on to next question...");
				}

				System.out.println("What is the two-digit model year of your car?");
				int carModel = input.nextInt();

				nonMagicNums.add(carModel + luckyNum);

				input.nextLine();
				System.out.println("Who is your favorite actor/actress?");
				String celebName = input.nextLine();
				nonMagicNums.add(Character.getNumericValue(celebName.trim().charAt(celebName.length()-1)));
				nonMagicNums.add(42);
				nonMagicNums.add(petAge + carModel);
				System.out.print("Lottery numbers: ");
				for(int i=0; i<nonMagicNums.size(); i++) {
					System.out.print(nonMagicNums.get(i));
					if(i < nonMagicNums.size()-1) {
						System.out.print(", ");
					}
				}
				System.out.println(" Magic Ball: " + magicBall);


				continue;
			}
			System.out.println("Invalid response. Please enter 'y' or 'n'.");
		}
	}

}
