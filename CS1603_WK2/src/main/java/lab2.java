import swiftbot.*;

public class lab2 {
	public static final SwiftBotAPI INSTANCE = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		SwiftBotAPI.INSTANCE.move(100, 100, 1000);
		int x = 4;
		int y =10;
		
		int ans = x*y;
		System.out.println(ans);
		try {
			//SwiftbotAPI.INSTANCE.move(100,100,100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("test");
	}

}


