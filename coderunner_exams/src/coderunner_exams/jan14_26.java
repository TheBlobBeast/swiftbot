package coderunner_exams;

public class jan14_26 {
	public static void main(String[] args) {
		//Hello("max", "cockburn", 14);
		//System.out.println(B(20, 100));
		//System.out.println(KineticEnergy(5, 10));
		//System.out.println(ValidPoints(150, 100, 160, 60));
		//System.out.println(MakeSequence(7, 9));
		//double [] T = {14.5, 15.2, 16.0, 15.8, 17.1, 18.3, 19.0};
		//T= null;
		//PredictWeather(T, 5);
		//System.out.println(PredictWeather(T, 5));
		
		int [][] triangles = 
		    {
		        {1, 2, 2, 4, 6, 2, 90}, //angle is 90, (fx,fy) = (6,2)
		        {-126, -30, -126, -131, -147, -137, 93}, //angle is 93, (fx,fy) = (-147,-137)
		        null, //invalid null row
		        {}, //invalid empty row
		        {37, -125, -94}, //invalid row length
		        {-136, -114, -18, 105, -133, -35, 893} //invalid degree >360
		    };
		double[][] output = TriangleRotation(triangles);
		for(double[] a:output) {
			try {
			for (double b: a) {
				try {
				System.out.println(b);
				}catch (Exception e) {
					;
				}
			}
			}catch (Exception e) {
				;
			}
			
		}
	}
	public static String Hello(String forename, String surname, int age) {
		String message = "";
		String sage = String.valueOf(age);
		message += "Hello ";
		message += forename;
		message += " ";
		message += surname;
		message += " are you ";
		message += sage;
		message += " years old?";
		return message;
	}
	public static double B(double w, double h) {
		if (h<=0 | h<= 0) {
			return -1;
		}
		double ans = w/h*h;
		
		return ans;
	}
	public static double KineticEnergy(double m, double v) {
		if (m<0 | v<0){
			return -1;
		}
		double ans = 0.5 * m * (v*v);
		return ans;
	}
	
	public static int ValidPoints(int x1, int y1, int x2, int y2) {
		//this would be a lot easier if we could use external functions
		
		if ((x1<=100 && x1>=-100) && (y1<=100 && y1>=-100) && (x2<=100 && x2>=-100)	 && (y2<=100 && y2 >=-100)) {
			return 1;
		}else if ((x1<=100 && x1>=-100) && (y1<=100 && y1 >=-100)) {
			return 2;
		}else if ((x2<=100 && x2 >=-100) && (y2<=100 && y2 >=-100)) {
			return 3;
		}else {
			return 4;
		}
			
	}
	
	public static String MakeSequence(int S, int N) {
		if (S<0 | N<0) {
			return "ERROR#1";
		}
		if (N<S) {
			return "ERROR#2";
		}
		
		
		String ans = "";
		for (int x=S; x<=N; x++) {
			if(x==N) {
				ans += String.valueOf(x*x);
			}else {
				ans += String.valueOf(x*x);
				ans += " ";
			}
			//System.out.println(ans);
			//System.out.println(x*x);
		}
		return ans;
	}
	
	public static double[] PredictWeather(double[] T, int xdays) {
		if (T==null) {
			double[] ret = new double [xdays];
			//System.out.println(ret.length);
			for (int i=0; i<xdays; i++) {
				ret[i] = -1.0;
				//System.out.println(ret[i]);
			}
			return ret;
		}else if (T.length == 0) {
			double[] ret = new double [xdays];
			//System.out.println(ret.length);
			for (int i=0; i<xdays; i++) {
				ret[i] = -1.0;
				//System.out.println(ret[i]);
			}
			return ret;
		}
		
		if (xdays < 1) {
			double[] ret = new double [xdays];
			for (int i=0; i<xdays; i++) {
				ret[i] = -2.0;
			}
			return ret;
		}
		
		for (double each:T) {
			double[] ret = new double[xdays];
			if (each < -89.2 | each > 56.7) {
				for (int i=0; i<xdays; i++) {
					ret[i] = -3.0;
				}
			}
		}
		
		double[] change = new double[T.length -1];
		
		int counter = 0;
		double sum = 0;
		for (int i=0; i<T.length-1; i++) {
			change[i] = T[i+1] - T[i];
			//System.out.println(change[i]);
			sum += change[i];
		}
		
		double totalchange = sum/(T.length -1);
		//System.out.println(T.length);
		//System.out.println(sum/(T.length -1));
		//System.out.println(totalchange);
		double[] P = new double[xdays];
		int lastday = T.length -1;
		for (int x=0; x<xdays; x++) {
			P[x] = T[lastday] + (totalchange * (x+1));
			//System.out.println(P[x]);
		}
		
		return P;
	}
	
	public static double[][] TriangleRotation(int triangles[][]) {
		double pi = 3.141592;
		double ret[][] = new double[6][];
		pi = Math.PI;
		
		int count = 0;
		for (int[] each : triangles) {
			if (each == null) {
				double[] a = {-1.0};
				ret[count] = a;
				break;
			}else if(each.length != 7) {
				double[] a = {-2.0};
				ret[count] = a;
				break;
			}
			
			double [] rotation = new double[6];
			int x1 = each[0];
			int y1 = each[1];
			int x2 = each[2];
			int y2 = each[3];
			int fx = each[4];
			int fy = each[5];
			int angle = each[6];
			
			if (angle > 360 | angle < 0) {
				double[] a = {-3.0};
				ret[count] = a;
				break;
			}
			double theta = angle * (pi/180);
			
			rotation[0] = ((x1-fx) * Math.cos(theta) - (y1-fy) * Math.sin(theta)) + fx;
			System.out.println(rotation[0]);
			rotation[1] = ((x1-fx) * Math.sin(theta) + (y1-fy) * Math.cos(theta)) + fy;
			System.out.println(rotation[1]);
			rotation[2] = ((x2-fx) * Math.cos(theta) - (y2-fy) * Math.sin(theta)) + fx;
			rotation[3] = ((x2-fx) * Math.sin(theta) + (y2-fy) * Math.cos(theta)) + fy;
			rotation[4] = fx;
			rotation[5] = fy;
			count += 1;
			ret[count] = rotation;
		}
		return ret;
	}
}
