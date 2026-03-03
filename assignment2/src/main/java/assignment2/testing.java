package assignment2;
import java.util.Scanner;

//import assignment2.controller;


public class testing {
	public static void main(String[] args) {
		test_timer();
		if (prompt_user_to_continue() == "y") {
			System.out.println("contine with program");
		}
		
	}
	
	public static void test_timer() {
		long start_time = System.currentTimeMillis();
		
	
		while (true) {
			if ( ((System.currentTimeMillis() - start_time) < 5*1000)) {
				System.out.println("timer up");
				
			}
		}
	}
	
	/*
	 * function that occours after 3 objects ahve been detected within 5 miuns
	 * returns y if the user selects they want to contine
	 * returns n if they dont 
	 * returns fail if the function failed - shouldnt happen
	 */
	public static String  prompt_user_to_continue() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("the swiftbot has detected 3 objects within 5 minutes");
		boolean valid_responce = false;
		while (valid_responce == false) {
			System.out.println("would you like to continue with the program? (y/n)");
			String user_responce = scanner.next();

			if (user_responce.contentEquals("y") || user_responce.contentEquals("Y") ) {
				valid_responce = true;
				return "y";
			}else if (user_responce.contentEquals("n") || user_responce.contentEquals("N")) {
				valid_responce = true;
				return "n";
			}else {
				valid_responce = false;
				System.out.println("incorrect input");
			}
			
		}
		return "fail";
		
	}
}
