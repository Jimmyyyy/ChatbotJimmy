package GroupFiles;

import java.util.Scanner;
public class JimmyCalculator implements Chatbot {

	private boolean inMathLoop;
	private String mathResponse;
	private String reply;
	private Scanner input = new Scanner(System.in);
	private boolean loop;
	
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
						int num1 = Integer.parseInt(firstNum.replaceAll("[\\D]", "")); // removes all non digits
						JimmyMain.print("Your first number is " + num1 + ". Please enter your second number:");
						String secondNum = JimmyMain.promptInput();
						int num2 = Integer.parseInt(secondNum.replaceAll("[\\D]", ""));
						JimmyMain.print("Your second number is " + num2 + ". Please enter your operator:");
						mathResponse = JimmyMain.promptInput();
						if(mathResponse.equals("+")||mathResponse.equals("-")||mathResponse.equals("*")||mathResponse.equals("/")||mathResponse.equals("^")) {
							JimmyMain.print("Your equation is " + num1 + mathResponse + num2 + ". Is this correct?");
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
				JimmyMain.print("That answer was good too");				
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