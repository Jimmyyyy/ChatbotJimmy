package GroupFiles;

import java.util.Scanner;
import java.util.Random;

public class JimmyCalculator implements Chatbot {

	private boolean inMathLoop;
	private String mathResponse;
	private boolean loop;
	private String firstNum;
	private String secondNum;
	private int answer;

	public void talk() {
		inMathLoop = true;

		while (inMathLoop) {
			mathResponse = JimmyMain.promptInput();
			if (JimmyMain.findKeyword(mathResponse, "no", 0) >= 0) {

				JimmyMain.print("Ok, let's go back");
				inMathLoop = false;
				JimmyMain.promptForever();

			}

			else if (JimmyMain.findKeyword(mathResponse, "yes", 0) >= 0) {
				JimmyMain.print(
						"Would you like me to calculate a simple random 2 numbers math question or would you like to make your own question?");
				mathResponse = JimmyMain.promptInput();

				if (JimmyMain.findKeyword(mathResponse, "own", 0) >= 0
						|| JimmyMain.findKeyword(mathResponse, "my", 0) >= 0) {

					loop = true;
					do {

						JimmyMain.print("Ok, please enter your first number:");
						boolean firstNumLoop = true;
						firstNum = JimmyMain.promptInput();

						while (!(firstNumLoop = firstNum.matches("[0-9]+"))) {
							System.out.println("You have entered " + firstNum
									+ ". Please correctly enter your first number again.");
							firstNum = JimmyMain.promptInput();
						}

						JimmyMain.print("Your first number is " + firstNum + ". Please enter your second number:");
						boolean secondNumLoop = true;
						secondNum = JimmyMain.promptInput();

						while (!(secondNumLoop = secondNum.matches("[0-9]+"))) {
							System.out.println("You have entered " + secondNum
									+ ". Please correctly enter your first number again.");
							secondNum = JimmyMain.promptInput();

						}

						JimmyMain.print(
								"Your second number is " + secondNum + ". Please enter your operator: +, -, *, / or ^");

						String operator = JimmyMain.promptInput();
						if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")
								|| operator.equals("^")) {

							JimmyMain.print("Your equation is " + firstNum + " " + operator + " " + secondNum
									+ ". Is this correct?");
							mathResponse = JimmyMain.promptInput();

							if (JimmyMain.findKeyword(mathResponse, "yes", 0) >= 0) {

								loop = false;
								JimmyMain.print("Ok, I will now calculate your math problem.");
								int num1 = Integer.parseInt(firstNum.replaceAll("(\\D)", "")); // removes
																								// all
																								// non
																								// digits
								int num2 = Integer.parseInt(secondNum.replaceAll("(\\D)", ""));
								if (operator.equals("+")) {
									answer = num1 + num2;
								}

								else if (operator.equals("-")) {
									answer = num1 - num2;
								} else if (operator.equals("*")) {
									answer = num1 * num2;
								} else if (operator.equals("/")) {
									answer = num1 / num2;
								} else if (operator.equals("^")) {
									answer = (int) Math.pow(num1, num2);
								}
								JimmyMain.print("The answer to your math question, " + firstNum + " " + operator + " "
										+ secondNum + " is " + answer + ".");

							} else {
								JimmyMain.print(
										"Since you have either entered the wrong math question or entered too many errors, let's restart.");
							}
						}

					} while (loop);

				} else {
					JimmyMain.print("Ok whatever! I'll think of a simple math question myself and answer it for you.");
					int randAnswer;
					Random nums = new Random();

					int determineOp = 1 + nums.nextInt(5);
					int rand1 = nums.nextInt(10000000);
					int rand2 = nums.nextInt(10000000);
					int rand3 = nums.nextInt(1000);
					int rand4 = nums.nextInt(1000);

					if (determineOp == 1) {
						randAnswer = rand1 + rand2;
						JimmyMain.print(
								"My random problem is " + rand1 + " + " + rand2 + ". The answer is " + randAnswer);
					} else if (determineOp == 2) {
						randAnswer = rand1 - rand2;
						JimmyMain.print(
								"My random problem is " + rand1 + " - " + rand2 + ". The answer is " + randAnswer);
					} else if (determineOp == 3) {
						randAnswer = rand1 * rand2;
						JimmyMain.print(
								"My random problem is " + rand1 + " * " + rand2 + ". The answer is " + randAnswer);
					} else if (determineOp == 4) {
						randAnswer = rand1 / rand2;
						JimmyMain.print(
								"My random problem is " + rand1 + " / " + rand2 + ". The answer is " + randAnswer);
					} else if (determineOp == 5) {
						randAnswer = (int) Math.pow(rand3, rand4);
						JimmyMain.print(
								"My random problem is " + rand3 + " ^ " + rand4 + ". The answer is " + randAnswer);
					}

				}

			} else {
				JimmyMain.print("I did not quite get that. Can you repeat yes or no?");
			}

		}

	}

	public boolean isTriggered(String userInput) {
		String[] triggers = { "calculator", "math", "calculators" };
		for (int i = 0; i < triggers.length; i++) {
			if (JimmyMain.findKeyword(userInput, triggers[i], 0) >= 0) {
				return true;
			}

		}
		return false;
	}

}
