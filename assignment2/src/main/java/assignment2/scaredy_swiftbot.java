package assignment2;

import swiftbot.SwiftBotAPI;
import swiftbot.Button;

import assignment2.other_functions;

import java.util.Random;


public class scaredy_swiftbot {
	//sb will be swiftbot for this code so i can easily refrence it with just 2 letters
	
	//public static SwiftBotAPI sb = SwiftBotAPI.INSTANCE;
	
	static int[] blue = {0,0,255};
	static int[] red = {255,0,0};

	public static void start(SwiftBotAPI sb) {
		//sb.fillUnderlights(blue);
		long start_time = System.currentTimeMillis();
		int objects_detected = 0;
		System.out.println(start_time);
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(start_time - System.currentTimeMillis());
		
		
		
		//mainloop for this program
		//checks if an object has been detected within 5 seconds
		//if not then will 
		while (true) {
			if ( ((System.currentTimeMillis() - start_time) < 5*1000)) {
				sb.fillUnderlights(blue);
				
				
				//if an object has been detected within 50cm
				if (sb.useUltrasound() < 50.0) {
					sb.fillUnderlights(red);
					other_functions.take_image(sb, "/home/max/detectobject");
					other_functions.blink(sb, red, 3);
					
					//going to need to change all the swiftbot valuse to the calibrate my swiftbot values
					//backup
					sb.move(-100, -100, 1000);
					//turn 180^o
					sb.move(-100, 100, 1000);
					//move away for 3 seconds
					sb.move(100, 100, 3000);
					
					
				//else then wander around
				}else {
					sb.move(100, 100, 500);
				}
				
			//this will move the swiftbot in a slightly different direction
			//direction is chosen randomly tho 
			}else {
				Random rand = new Random();
				
				sb.move(80 + rand.nextInt(19), 80 + rand.nextInt(19), 500);
				start_time = System.currentTimeMillis();
			}
		}

	}
	
	public static void move() {
		//change this to the best velocity from calibrate
		;
	}
}
