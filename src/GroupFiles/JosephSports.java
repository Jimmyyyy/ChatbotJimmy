package GroupFiles;

import java.util.Scanner;

public class JosephSports implements Chatbot {
	private static String response;
	private static String answer;
	static boolean inMainLoop;
	public static String[] sports = { "baseball", "basketball", "hockey", "football" };
	public static String[] baseballResponse = { "The Mets are my favorite team", "My favorite position is shortstop.",
			"My favorite player is David Wright." };
	public static String[] basketballResponse = { "The Knicks are my favorite team",
			"My favorite position is shooting guard", "My favorite player is Lebron James." };
	public static String[] hockeyResponse = { "The Rangers are my favorite team",
			"My favorite position is right wing or left wing.", "My favorite player is Henrik Lundqvist." };
	public static String[] footballResponse = { "The Giants are my favorite team", "My favorite position is tight end.",
			"My favorite player is Eli Manning." };
	// team position player

	public void talk() {
		inMainLoop = true;
		while (inMainLoop) {
			JimmyMain.print("Oh can you repeat what you want to talk about again? I'm kinda stupid :)");
			response = JimmyMain.promptInput();

			if (JimmyMain.findKeyword(response, "no", 0) >= 0) {
				inMainLoop = false;
				JimmyMain.promptForever();
			} else if (JimmyMain.findKeyword(response, "sports", 0) >= 0) {
				JimmyMain.print("That's wonderful.");
				sportConversation();
			} else if (JimmyMain.findKeyword(response, "books", 0) >= 0) {
				JimmyMain.print("Books are cool, tell me about them.");
				inMainLoop = false;
				JimmyMain.promptForever();
			} else if (JimmyMain.findKeyword(response, "math", 0) >= 0) {
				JimmyMain.print("Math is fun tell me more");
				inMainLoop = false;
				JimmyMain.promptForever();
			} else {
				JimmyMain.print("I am sorry, but I am unfamiliar with that sport.");
			}
		}
	}

	public static void sportConversation() {
		JimmyMain.print("What sport do you want to talk about?");
		response = JimmyMain.promptInput();
		if (JimmyMain.findKeyword(response, "soccer", 0) >= 0) {
			JimmyMain.print("What is your favorite" + response + "team?");
			answer = JimmyMain.promptInput();
			if (JimmyMain.findKeyword(answer, "jets", 0) >= 0) {
				JimmyMain.print("Great minds think alike");
			} else {
				JimmyMain.print("They are ok. I guess.");
			}
			JimmyMain.print("What is your favorite position in that sport?");
			JimmyMain.input = new Scanner(System.in);
			JimmyMain.print("Me too.");
			JimmyMain.print("Who is your favorite player?");
			JimmyMain.input = new Scanner(System.in);
			JimmyMain.print(baseballResponse[2] + "What do you want to talk about now?");

		} else if (JimmyMain.findKeyword(response, "basketball", 0) >= 0) {
			JimmyMain.print("What is your favorite" + response + "team?");
			answer = JimmyMain.promptInput();
			if (JimmyMain.findKeyword(response, "answer", 0) >= 0) {
				JimmyMain.print("Great minds think alike");
			} else {
				JimmyMain.print("They are ok. I guess.");
			}
			JimmyMain.print("What is your favorite position in that sport?");
			JimmyMain.input = new Scanner(System.in);
			JimmyMain.print("Me too.");
			JimmyMain.print("Who is your favorite player?");
			JimmyMain.input = new Scanner(System.in);
			JimmyMain.print(basketballResponse[2] + "What do you want to talk about now?");
		} else if (JimmyMain.findKeyword(response, "hockey", 0) >= 0) {
			JimmyMain.print("What is your favorite" + response + "team?");
			answer = JimmyMain.promptInput();
			if (JimmyMain.findKeyword(answer, "rangers", 0) >= 0) {
				JimmyMain.print("Great minds think alike");
			} else {
				JimmyMain.print("They are ok. I guess.");
			}
			JimmyMain.print("What is your favorite position in that sport?");
			JimmyMain.input = new Scanner(System.in);
			JimmyMain.print("Me too.");
			JimmyMain.print("Who is your favorite player?");
			JimmyMain.input = new Scanner(System.in);
			JimmyMain.print(hockeyResponse[2] + "What do you want to talk about now?");
		} else if (JimmyMain.findKeyword(response, "football", 0) >= 0) {
			JimmyMain.print("What is your favorite" + response + "team?");
			answer = JimmyMain.promptInput();
			if (JimmyMain.findKeyword(answer, "giants", 0) >= 0) {
				JimmyMain.print("Great minds think alike");
			} else {
				JimmyMain.print("They are ok. I guess.");
			}
			JimmyMain.print("What is your favorite position in that sport?");
			JimmyMain.input = new Scanner(System.in);
			JimmyMain.print("Me too.");
			JimmyMain.print("Who is your favorite player?");
			JimmyMain.input = new Scanner(System.in);
			JimmyMain.print(footballResponse[2] + "What do you want to talk about now?");
		} else
			JimmyMain.print("Sorry I am unfamiliar with that sport. Can we talk about another?");
	}

	public boolean isTriggered(String userInput) {
		String[] triggers = { "baseball", "basketball", "hockey", "football", "sports" };
		for (int i = 0; i < triggers.length; i++) {
			if (JimmyMain.findKeyword(userInput, triggers[i], 0) >= 0) {
				return true;
			}

		}
		return false;
	}
}
