package GroupFiles;

import java.util.Scanner;
public class JimmyCalculator implements Chatbot {

	private boolean inMathLoop;
	private String mathResponse;
	private Scanner input = new Scanner(System.in);
	
	public void talk() {
		inMathLoop = true;
		while (inMathLoop) {
		
			//static  call on promptInput method from JimmyMain class
			mathResponse = JimmyMain.promptInput();
			if (mathResponse.indexOf("no") >= 0)  {
				JimmyMain.print("Ok, let's go back.");
				inMathLoop = false;
				JimmyMain.promptForever();
			}
			else if (JimmyMain.findKeyword(mathResponse, "yes", 0) >= 0) {
				JimmyMain.print("Ok, please enter your first number.");
				String firstnum =  input.next();
				int num1 = Integer.parseInt(firstnum.replaceAll("[\\D]", "")); // removes all non digits
				JimmyMain.print("Your first number is " + num1 + ". Is that correct?");
				if ()
			}
			else {
				JimmyMain.print("That answer was good too");				
			}

		}
		
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