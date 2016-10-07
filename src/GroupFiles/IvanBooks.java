package GroupFiles;


public class IvanBooks implements Chatbot{
	private boolean inMainLoop;
	private boolean inBookLoop;
	private boolean inAntLoop;
	private boolean inNextLoop;
	private boolean inBotLoop;
	public String[] Genre = {"Fantasy", "Mystery ", "Horror"};
	public String[] Series = {"Harry Potter, Demonata, and Cirque Du Freak ", "Sherlock Holmes and The Girl With the Dragon Tattoo ", "Goosebumps,"};
	public String[] Single = {"Lady of the Shades", "The Secret of the Old Clock", " Doctor Sleep" };
	private String readA;
	private int number = 0;
	private int repeat = 2;
	private int clickCount = 0;

	public void talk() {
		inMainLoop = true;
		while(inMainLoop) {
			inBookLoop = true;
			JimmyMain.print("Do you like to read " + Genre[number] + "?");
			while(inBookLoop){
				readA = JimmyMain.promptInput();
				if(JimmyMain.findKeyword(readA, "yes", 0)>=0){
					JimmyMain.print("Cool! "+ " I want to talk about that genre right now.");
					inBookLoop = false;
					inBotLoop = true;
				}
				else if (JimmyMain.findKeyword(readA, "no", 0)>=0){
					JimmyMain.print("What genre do you like to read?");
					inBookLoop = false;
					inAntLoop = true;
				}
			}
				while(inAntLoop){
					
					readA = JimmyMain.promptInput();
					JimmyMain.print("Oh, you like to read the genre, " + readA +"." + "I don't want to talk about that one right now !" 
							+ "How about we talk about " + Genre[number]+ "?"+ "Let me recommend you some " + Genre[number] + "novels!");
					if(JimmyMain.findKeyword(readA, "no", 0)>=0){
						JimmyMain.print("Then I would rather not talk about books.");
						JimmyMain.promptForever();
					}
					else if(JimmyMain.findKeyword(readA, "ok", 0)>=0){
						JimmyMain.print("Awesome!");
						inAntLoop = false;
						inBotLoop = true;
					}
				
		}
	
			while(inBotLoop){
				JimmyMain.print("Do you like to read a series novel or a single novel?");				
				readA = JimmyMain.promptInput();
				if(JimmyMain.findKeyword(readA, "series", 0)>=0){
					
					JimmyMain.print("I recommend you to read " +Series[clickCount].toString() +".") ;				
					inBotLoop = false;
					inNextLoop = true;
				}
				else{
					JimmyMain.print("I recommend you to read "+ Single[clickCount].toString() + "." ) ;
					inBotLoop = false;
					inNextLoop = true;				
				}
			}
			while(inNextLoop){
				if(repeat != 0){
					JimmyMain.print("I have no more recommendations for" + Genre[number] + ".");
					number++;
					clickCount++;					
					inNextLoop = false;
					inMainLoop = true;
					repeat--;
				}
				else{;
					JimmyMain.print("That's all the books I have right now. Come back later.");
					JimmyMain.promptForever();
				}									
				}
			}
		}
	
	
	public boolean isTriggered(String userInput) {
		if(JimmyMain.findKeyword(userInput, "reading", 0)>=0){
			return true;
		}
		return false;
	}
	
}
