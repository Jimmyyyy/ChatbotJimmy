package GroupFiles;

import java.util.Scanner;

public class JimmyMain {
		
		static String response;
		static boolean inMainLoop;
		static Scanner input;
		static String user;

		static Chatbot books;
		static Chatbot sports;
		static Chatbot games;
		static Chatbot calculator;
		
				
		public static void main(String[] args) {
			createField(); 
			promptName();
			promptForever();
		}
		
		public static void promptName(){
			print("Hello! I am a chatbot. What is your name?");
			user = input.nextLine();

		}

		public static void promptForever() {
			inMainLoop = true;
			print("Hello " + user + "! May I know what your hobby is?");
			while (inMainLoop){
				response = promptInput();
				if(findKeyword(response, "no", 0) >= 0 || findKeyword(response, "nah", 0) >= 0){
					print("I will not take " + response + " for an answer");
					print(user + ", can you tell me what your hobby is?");
				}
				else if(sports.isTriggered(response)){
					print("Oh I love " + response +  " as well. Tell me what your favorite sport is.");
					inMainLoop = false;
					sports.talk();
				} 
				else if(books.isTriggered(response)){
					print("Oh I love " + response +  " as well. Tell me what your favorite genre is.");
					inMainLoop = false;
					books.talk();
				} 
				else if(calculator.isTriggered(response)){
					print("Oh I love " + response +  " as well. Would you like me to calculate something?");
					inMainLoop = false;
					calculator.talk();
				}
				else if (findKeyword(response, "yes", 0) >= 0 || 
						findKeyword(response, "ok", 0) >= 0 ||
						findKeyword(response, "fine", 0) >= 0){
					print("Ok, tell me what it is then.");
				}
				else {
					print("I do not understand your gibberish.");
				}
			}
		}

		public static int findKeyword(String searchString, String keyword, int startPos) {

			searchString = searchString.trim();
			searchString = searchString.toLowerCase();
			keyword = keyword.toLowerCase();  


			int pos = searchString.indexOf(keyword);

			
		
			while(pos >= 0){
		
				String before = "";
				String after = "";
	
				if(pos > 0){
					before = searchString.substring(pos-1, pos);
		
				}
			
				if(pos + keyword.length() < searchString.length()){
					after = searchString.substring(pos + keyword.length(), pos + keyword.length());
					
				}
				if(before.compareTo("a") < 0 && after.compareTo("a") < 0 && noNegations(searchString, pos)){
			
					return pos;
				}
				else{

					pos = searchString.indexOf(keyword, pos+1);
					
				}
			}
			
			return -1;
		}

		private static boolean noNegations(String searchString, int pos) {
		
			if(pos-3 >= 0 && searchString.substring(pos-3,pos).equals("no ")){
				return false;
			}
	
			if(pos-4 >= 0 && searchString.substring(pos-4,pos).equals("not ")){
				return false;
			}
		
			if(pos-6 >= 0 && searchString.substring(pos-6,pos).equals("never ")){
				return false;
			}
		
			if(pos-4 >= 0 && searchString.substring(pos-4,pos).equals("n't ")){
				return false;
			}
			return true;
		}

		public static String promptInput() {
			String userInput = input.nextLine();
			return userInput;
		}

		public static void createField() {
			input = new Scanner(System.in);
			user = "";

			calculator = new JimmyCalculator();
			sports = new JosephSports();
			books = new IvanBooks();
		}

		public static void demonstrateStringMethods(){
			String text1 = new String("What's poppin world!"); 
			String text2 = "What's poppin world!"; 			//same as above string var
			
			if(text1.equals(text2)){
				print("These strings are equal:");
			}
			print(text1);
			print(text2);
			
			String word1 = "aardvark";
			String word2 = "NotAardvark";
			
			if(word1.compareTo(word2) < 0){
				print("word1 comes before word2.");
			}
		}
		
		public static void print(String text){
			String printString = "";
			int cutoff = 35;

			while(text.length() > 0){
				String cut = "";
				String nextWord = "";
			
				while(cut.length() + nextWord.length() < cutoff && text.length() > 0){
		
					cut += nextWord;
					
					text = text.substring(nextWord.length());
			
					int endOfWord = text.indexOf(" ");
	
					if(endOfWord == -1){
						endOfWord = text.length()-1;
					}
					nextWord = text.substring(0,endOfWord+1);
					
				}
				printString += cut + "\n";
			}
			
			

			System.out.println(printString);
		}
		
		private static String getCut(String text, int cutoff, int cut){
			int cutIndex = cut * cutoff;
			if(cutIndex > text.length()){
				cutIndex = text.length();
			}
			String currentCut = text.substring(0, cutIndex);
			
			int indexOfLastSpace = currentCut.length()-1;

			for(int i = currentCut.length()-1; i >= 0; i--){
				String letter = currentCut.substring(i, i+1);
				if(letter.equals(" ")){
					indexOfLastSpace = i;
					break;
				}
			}
	
			currentCut = currentCut.substring(0, indexOfLastSpace);
			
			return currentCut;
		}
}
