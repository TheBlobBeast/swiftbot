package assignment2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.imageio.ImageIO;

import swiftbot.ImageSize;
import swiftbot.SwiftBotAPI;

public class other_functions {
	public static void take_image(SwiftBotAPI sb, String path) {
		BufferedImage img = sb.takeStill(ImageSize.SQUARE_1080x1080);
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		
		
		try {
			ImageIO.write(img, "jpg", new File(path + "/" + date + "/" + time));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[ERROR]  could not write the file ");
		} 	
	}
	
	public static void blink(SwiftBotAPI sb, int[] colour, int range) {
		
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
