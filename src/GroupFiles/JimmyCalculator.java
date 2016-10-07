package GroupFiles;

import java.util.Scanner;
public class JimmyCalculator implements Chatbot {

	private boolean inMathLoop;
	private String mathResponse;
	private String reply;
	private Scanner input = new Scanner(System.in);
	private boolean loop;
	private boolean loop2;
	public void talk() {
		inMathLoop = true;
		while (inMathLoop) {
		
			//static  call on promptInput method from JimmyMain class
			mathResponse = JimmyMain.promptInput();
			if (JimmyMain.findKeyword(mathResponse, "no", 0) >= 0)  {
				JimmyMain.print("Ok, let's go back");
				inMathLoop = false;
				JimmyMain.promptForever();
			}
			else if (JimmyMain.findKeyword(mathResponse, "yes", 0) >= 0) {
				JimmyMain.print("Would you like me to calculate a simple random 2 numbers math question or would you like to make your own question?");
				mathResponse = JimmyMain.promptInput();
				if (JimmyMain.findKeyword(mathResponse,"own",0) >= 0) {
					loop = true;
					do {
						JimmyMain.print("Ok, please enter your first number:");
						
						String firstNum =  JimmyMain.promptInput();
						while (loop2) {
							if(firstNum.matches(".*\\d+.*")) {
								loop2 = false;
								int num1 = Integer.parseInt(firstNum.replaceAll("[\\D]", "")); // removes all non digits
								JimmyMain.print("Your first number is " + num1 + ". Please enter your second number:");
										
						}
						else  {
								JimmyMain.print("Please enter a correct first number again.");	
							}

							
						}
						
						String secondNum = JimmyMain.promptInput();
						int num2 = Integer.parseInt(secondNum.replaceAll("[\\D]", ""));
						JimmyMain.print("Your second number is " + num2 + ". Please enter your operator: +, -, *, / or ^");
						
						String operator = JimmyMain.promptInput();
						if(operator.equals("+")||operator.equals("-")||operator.equals("*")||operator.equals("/")||operator.equals("^")) {
							
							JimmyMain.print("Your equation is " + num2 + mathResponse + num2 + ". Is this correct?");
							mathResponse = JimmyMain.promptInput();
							
							if(JimmyMain.findKeyword(mathResponse, "yes", 0) >= 0) {
								
								
								loop = false;
								
								
							}
							else {
								JimmyMain.print("Since you have either entered the wrong math question or entered too many errors, let's restart.");
							}
						}
						
							
					
					}
					while (loop);
						
					
					
				}
				else {
					JimmyMain.print("whatever");
				}
				
				
			}
			else {
				JimmyMain.print("I did not quite get that. Can you repeat?");				
			}

		}
		
	}

	private String nextLine() {
		// TODO Auto-generated method stub
		return null;
	}

	public  boolean isTriggered(String userInput) {
		String[] triggers = {"calculator","math","calculators"};
		for(int i = 0; i< triggers.length; i++) {
			if (JimmyMain.findKeyword(userInput,triggers[i],0)
					>= 0) {
				return true;
			}
	
		}
		return false;
	}

}