package GroupFiles;



public class IvanBooks implements Chatbot{
	//private static String response;
	private boolean inMainLoop;
	private boolean inBookLoop;
	private boolean inOtherLoop;
	private boolean inAntLoop;
	//private boolean inUserLoop;
	private boolean inBotLoop;
	public String[] Genre = {"Fantasy", "Mystery", "Horror"};
	public String[] Fantasy = {"a " , "b ","c ","d ","e "};
	public String[] Fantasy2 = {"f", "g", "h" };
	//public String favGenre = "Fantasy";
	private String readF;
	private String userGenre;
	//public String[] Mystery = {"a", "b","c","d","e"};
//	public String[] Horror = {"a", "b","c","d","e"};
	//public int Yes = JimmyMain.findKeyword(readF, "yes", 0);
	//public int No = JimmyMain.findKeyword(readF, "no", 0);
	public void talk() {
		inMainLoop = true;
		while(inMainLoop) {
			inBookLoop = true;
			JimmyMain.print("Do you like to read Fantasy ?");
			while(inBookLoop){
				readF = JimmyMain.promptInput();
				if(JimmyMain.findKeyword(readF, "yes", 0)>=0){
					JimmyMain.print("Cool! "+ " That's my favorite genre.");
					inBookLoop = false;
					inBotLoop = true;
				}
				else if (JimmyMain.findKeyword(readF, "no", 0)>=0){
					JimmyMain.print("What genre do you like to read?");
					inBookLoop = false;
				}
				while(inAntLoop){
					userGenre = JimmyMain.promptInput();
					JimmyMain.print("Oh, your favorite genre is" + userGenre +"." + "Your favorite genre is boring!" 
							+ "How about we talk about Fantasy first? Let me recommend you some fantasy novels!");

					if(JimmyMain.findKeyword(userGenre, "no", 0)>=0){
						JimmyMain.print("Then I would rather not talk about books.");
						JimmyMain.promptForever();
					}
				}

			//	else if (JimmyMain.findKeyword(readF, "yes", 0)>=0){
			//		inBotLoop = true;
			//	}

			}
			while(inBotLoop){
				JimmyMain.print("Do you like to read a series novel or a single novel?");
				readF = JimmyMain.promptInput();
				if(JimmyMain.findKeyword(readF, "seres", 0)>=0){
					JimmyMain.print("I recommend you to read : " + Fantasy[0].toString() +" .") ;
					
				}
				else{
					JimmyMain.print("I reccomend you to read: "+ Fantasy2[0].toString() + ".") ;
					
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
	
	
		
	
	
	//public static void GenreType(){
	//	JimmyMain.print("What genre do you like?");
	//	response = JimmyMain.promptInput();
	//}
}
