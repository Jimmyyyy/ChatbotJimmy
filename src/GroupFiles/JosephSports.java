package GroupFiles;

	public class JosephSports implements Chatbot{
	private static String response;
	private boolean inSportLoop;
	static boolean inMainLoop;
	public static String[] sports = {"baseball", "basketball", "hockey", "football"};
	public static String[] baseballResponse = {"The Mets are my favorite team", "My favorite position is shortstop.", "My favorite player is David Wright."};
	public static String[] basketballResponse = {"The Knicks are my favorite team", "My favorite position is shooting guard", "My favorite player is Lebron James."};
	public static String[] hockeyResponse = {"The Rangers are my favorite team", "My favorite position is right wing or left wing.", "My favorite player is Henrik Lundqvist."};
	public static String[] footballResponse = {"The Giants are my favorite team", "My favorite position is tight end.", "My favorite player is Eli Manning."};
	// team position player 

	
	public void talk(){
		inMainLoop = true;
		while (inMainLoop) {
			response = JimmyMain.promptInput();
			
			if(isTriggered(response)) {
				inSportLoop = false;
				JimmyMain.promptForever();
			
			if (JimmyMain.findKeyword(response, "sports[]", 0) >= 0) {
				JimmyMain.print("That's wonderful.");
				sportConversation();
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
	
	public static void sportConversation(){
		JimmyMain.print("What sport do you want to talk about?");
		response = JimmyMain.promptInput();	
		if(response == "baseball"){
			JimmyMain.print(baseballResponse[1] +"What is your favorite" + response + "team?");
			JimmyMain.print(baseballResponse[2] +"What is your favorite position in that sport?");
			JimmyMain.print(baseballResponse[3] +"Who is your favorite player?");
		}
		else if(response == "basketball"){
			JimmyMain.print(basketballResponse[1] +"What is your favorite" + response + "team?");
			JimmyMain.print(basketballResponse[2] +"What is your favorite position in that sport?");
			JimmyMain.print(basketballResponse[3] +"Who is your favorite player?");
		}
		else if(response == "hockey"){
			JimmyMain.print(hockeyResponse[1] +"What is your favorite" + response + "team?");
			JimmyMain.print(hockeyResponse[2] +"What is your favorite position in that sport?");
			JimmyMain.print(hockeyResponse[3] +"Who is your favorite player?");
		}
		else if(response == "football"){
			JimmyMain.print(footballResponse[1] +"What is your favorite" + response + "team?");
			JimmyMain.print(footballResponse[2] +"What is your favorite position in that sport?");
			JimmyMain.print(footballResponse[3] +"Who is your favorite player?");
		}
		else
			JimmyMain.print("Sorry I am unfamiliar with that sport. Can we talk about another?");
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
}	
