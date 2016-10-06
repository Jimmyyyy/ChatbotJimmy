package GroupFiles;

	public class JosephSports implements Chatbot{
	private static String response;
	private boolean inSportLoop;
	static boolean inMainLoop;
	public String Sports;
	public String[] baseballResponse = {};
	public String[] basketballResponse = {};
	public String[] hockeyResponse = {};
	public String[] footballResponse = {};
	// team position player 

	public void talk() {
		inSportLoop = true;
		while(inSportLoop) {
			response = JimmyMain.promptInput();
			
			if(isTriggered(response)) {
				inSportLoop = false;
				JimmyMain.promptForever();
			}
		}
	}
	
	public boolean isTriggered(String userInput) {
		String[] triggers = {"baseball","basketball","hockey","football"}; 
		for(int i = 0; i< triggers.length; i++) {	
		if(JimmyMain.findKeyword(userInput, triggers[i], 0) >=0 ){
				return true;
		}
			return false;
		}
		return inSportLoop;
	}
	
	public static void talkforever(){
		inMainLoop = true;
		while (inMainLoop) {
			JimmyMain.print("What is your favorite sport?");
			response = JimmyMain.promptInput();
			if (JimmyMain.findKeyword(response, "sports[]", 0) >= 0) {
				JimmyMain.print("That's wonderful.");
				
			} else if (response.indexOf("books") >= 0) {
				JimmyMain.print("Books are cool, tell me about them.");
				inMainLoop = false;
				JimmyMain.promptForever();
			}	
			else if (response.indexOf("games") >= 0) {
				JimmyMain.print("Games are fun tell me more");
				inMainLoop = false;
				JimmyMain.promptForever();
			} else {
				JimmyMain.print("I am sorry, but I am unfamiliar with that sport.");
			}
		}
	}
}

