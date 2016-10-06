package GroupFiles;



public class JimmyGames implements Chatbot {
	private String PlatformResponse;
	private boolean inPlatformLoop;
	private String platform;
	private String[] calmResponse = {"Let's say something else", "Let's keep talking about games."};
	private String[] angryResponse = {"Please stop repeating yourself","Do not say hello ever again"};
	
	private int PlatformCount;
	
	public JimmyGames() {
		PlatformCount = 0;
	}
	
	public void talk() {
		inPlatformLoop = true;
		while(inPlatformLoop) {
			PlatformCount++;
			printResponse();//helper method
			PlatformResponse = JimmyMain.promptInput();
			
			if(isTriggered(PlatformResponse)) {
				inPlatformLoop = false;
				JimmyMain.promptForever();
			}
		}
	}
	
	private void printResponse() {
		if(PlatformCount > 4) {
			
			int responseSelection = (int)(Math.random() * angryResponse.length);		
			JimmyMain.print(angryResponse[responseSelection]);
			
		}
		
		else {
			int responseSelection = (int)(Math.random() * calmResponse.length);		
			JimmyMain.print(calmResponse[responseSelection]);
		}
	}
	
	
	public  boolean isTriggered(String userInput) {
		String[] triggers = {"games"};
		for(int i = 0; i< triggers.length; i++) {
			if (JimmyMain.findKeyword(userInput,triggers[i],0)
					>= 0) {
				return true;
			}
	
		}
		return false;
	}
} 
	
