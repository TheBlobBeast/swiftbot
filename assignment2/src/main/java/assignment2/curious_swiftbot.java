package assignment2;

import swiftbot.SwiftBotAPI;

public class curious_swiftbot {
	
	//public static SwiftBotAPI sb = SwiftBotAPI.INSTANCE;
	
	public static void start(SwiftBotAPI sb) {
		
		boolean object_found = false;
		double dist_to_obj = 0.0;
		
		while (!object_found) {
			dist_to_obj = sb.useUltrasound();
			
			//if the robot isnt exactly 30cm away
			//might have 
			while (dist_to_obj != 30) {
				
				//if more than 30cm then backup
				if (dist_to_obj > 30) {
					sb.move(-100, -100, 100);
				
				//if less than 30cm then go forward
				}else {
					sb.move(100, 100, 100);
				}
				
				
			}
		}
	}
}
