package assignment2;

import java.util.Random;

import swiftbot.SwiftBotAPI;

public class dubious_swiftbot {
	
	//very simple will pick randomly between scardey and curious
	//could add the option to picl detective
	public static void start(SwiftBotAPI sb) {
		Random randint = new Random();
		int option = randint.nextInt(0, 2);
		
		if (option == 0) {
			System.out.println("scardey swiftbot randomly chosen");
			assignment2.scaredy_swiftbot.start(sb);
		}else {
			System.out.println("curious swiftbot randomly chosen");
			assignment2.curious_swiftbot.start(sb);
		}
	}
}
