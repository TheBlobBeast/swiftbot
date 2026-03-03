package assignment2;

import assignment2.scaredy_swiftbot;

import swiftbot.SwiftBotAPI;
import swiftbot.Button;
import swiftbot.ImageSize;

import java.awt.image.BufferedImage;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class controller {
	
	//public on purpouse so can be access by other parts of the program
	public static SwiftBotAPI sb = SwiftBotAPI.INSTANCE;
	
	public static void main(String[] args) {
		//exit with error code if the x button is pressed
		sb.enableButton(Button.X, () -> System.exit(0));
		int found_objects = 0;
		
		//change this when i have wifi to something that will get unix time
		Timer timer = new Timer();
		Long startTime = System.currentTimeMillis();
		
		
		//this is the main loop of the program
		while (true) {
			//if the swiftbot has detected more than 3 objects within 5 minutes
			if ((found_objects > 3) && (System.currentTimeMillis() - startTime > 5000*60 )) {
				prompt_user_to_continue();
			}else {
				int option = parse_qr();
				switch (option) {
				case 1:
					assignment2.scaredy_swiftbot.start(sb);
				case 2:
					assignment2.curious_swiftbot.start(sb);
				case 3:
					assignment2.detective_swiftbot.start(sb);
				case 4:
					assignment2.dubious_swiftbot.start(sb);
				}
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
	
	
	
	
	/*
	 * this funciton will take image repeatedly until a valud qr code has been found
	 * 
	 * will return:
	 * 1-scardey
	 * 2-curous
	 * 3-detective
	 * 4-dubious
	 * 
	 * 0-error, check this out bcs it should never happen
	 */
	public static int parse_qr() {
		boolean qr_code_read = false;
		System.out.println("place the swiftbot infront of the qr code");
		
		while (!qr_code_read) {
			BufferedImage img = sb.getQRImage();
			String message = sb.decodeQRImage(img);
			qr_code_read = true;
			
			switch (message) {
			case "scardey":
				System.out.println("scardey seiuftbot selected");
				//scaredy_swiftbot.main();
				return 1;
				
			case "curious":
				System.out.println("curious swiftbot selected");
				
				return 2;
				
			case "detective":
				System.out.println("detective swiftbot selected");
				
				return 3;
			
			case "dubious":
				System.out.println("dubious swiftbot selected");
				
				return 4;
				
			default:
				System.out.println("no QR code detected, trying again in 1s");
				qr_code_read = false;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}

		}
		System.out.println("something went wrong in parse qr code function");
		return 0;
	}
	
	
	
	
	
	//will blink the underlights a set colour for the times specified in range
	public static void blink(int[] colour, int range) {
		
		for(int i=0; i<= range; i++) {
			sb.fillUnderlights(colour);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sb.disableUnderlights();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}




































