package coderunner_mocks;

import java.util.ArrayList;

//coderunner week 7 and week 8 answers


public class test {
	public static void main(String[] args) {
		MakeSequence(5);
		String grade = CalculateGradeLetter("h", "h");
		System.out.println(grade);
		System.out.println(PMT(50000, 6, 10));
		System.out.println((CalculateAngle(5,6,7)));
		
		int[][] test = {{1,2}, {3, 2}};
		System.out.println(PointInCircle(test));
	}
	
	//111112222333445
	public static String MakeSequence(int N) 
	{
		String s = "";
		for(int i = 1; i<N+1; i++) {
			//0,1,2,3,4
			for(int j = N+1; j>i; j--) {
				//0,1,2,3,4
				s += Integer.toString(i);
			}
		}
		//System.out.println(s);
		return s;
	}
	
	
	public static String CalculateGradeLetter(String strGrade, String strBonus)
	{
		//exception handleing
		if (strGrade.trim() == "" || strBonus.trim() == "") {
			return "-2";
		}
		int g;
		int b;
		try {
			g = Integer.parseInt(strGrade);
			b = Integer.parseInt(strBonus);

		} catch (Exception e) {
			return "-3";
		}

		
		if ((g+b) >=70) {
			return "A";
		}else if ((g+b) >= 60) {
			return "B";
		}else if ((g+b) >= 50) {
			return "C";
		}else if ((g+b) >= 40) {
			return "D";
		}
		return "F";
		
	}
	public static double CalculateExpression(double n, double x, double y, double z) {
		return 7.2*n*((x*x) + (y*y) + (z*z));	
	}
	public static double PMT (double P, double r, double n) {
		double rr = (r/100)/12;
		double nn = n*12;
		return (P*rr*Math.pow(1+rr, nn))/ (Math.pow(1+rr, nn) -1);
	}
	public static double CalculateAngle (double a, double b, double c) {
		
		//determine if the points make a valid triangle
		if (!(a+b>c) && (a+c>b) && (b+c>a)){
		    return -1.0;
		}
		
		double A = (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a,  2)) / (2*b*c);
		//A = Math.toDegrees(A);
		if (A>1 || A<0) {
			return -1.0;
		}
		return Math.toDegrees(Math.acos(A));
	}

	public static ArrayList<Integer> PointInCircle(int[][] points) {
		int h = 3;
		int k = 2;
		int r = 5;

		ArrayList<Integer> output = new ArrayList<>();
		for (int[] i:points) {
			double a = Math.pow(i[0]-h, 2) + Math.pow(i[1]-k, 2);
			
			if (a < 5*5) {
				output.add(3);
			}else if(a==5*5) {
				output.add(2);
			}else if(a>5*5) {
				output.add(1);
			}else {
				output.add(-1);
			}
		}
		return output;

	}}
