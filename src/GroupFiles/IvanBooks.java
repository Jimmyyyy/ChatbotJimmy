package GroupFiles;

	public class IvanBooks implements Chatbot{
	//private static String response;
	private boolean inMainLoop;
	private boolean inBookLoop;
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
	public int Yes = JimmyMain.findKeyword(readF, "yes", 0);
	public int No = JimmyMain.findKeyword(readF, "no", 0);
	public void talk() {
		inMainLoop = true;
		while(inMainLoop) {
			inBookLoop = true;
			JimmyMain.print("Do you like to read Fantasy ?");
			while(inBookLoop){
				readF = JimmyMain.promptInput();
				if(Yes>=0){
					JimmyMain.print("Cool! "+ " That's my favorite genre.");
					inBotLoop = true;
				}
				else if (No>=0){
					JimmyMain.print("What genre do you like to read?");
					userGenre = JimmyMain.promptInput();
				}
				if(JimmyMain.findKeyword(userGenre, "fantasy", 0)>=0){
					JimmyMain.print("You said no before!" + "Whatever, lets talk about fantasy");
					inBotLoop = true;
				}
				else{
					JimmyMain.print("Your favorite genre is boring!" + "How about you let me recommend you some fantasy novels?");
				}
				if(No>=0){
					JimmyMain.print("Then I would rather not talk about books.");
					JimmyMain.promptForever();
				}
				else if (Yes>=0){
					inBotLoop = true;
				}

			}
			while(inBotLoop){
				JimmyMain.print("Do you like to read a series novel or a single novel?");
				readF = JimmyMain.promptInput();
				if(JimmyMain.findKeyword(readF, "seres", 0)>=0){
					JimmyMain.print("I recommend you to read : " + Fantasy.toString() +" .") ;
				}
				else{
					JimmyMain.print("I reccomend you to read: "+ Fantasy2.toString() + ".") ;
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
