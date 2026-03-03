

public class runtime {
	public static void main(String[] args) {
		int a = 100;
		double b = 2.3, c = -52.2;
		boolean d = true;
		String e = "I am", f = "a student";
		byte g = 0;
		char h = '!';
		
		double pi = 3.142;
		String name = "max";
		long x;
		double y;
		String z;
		
		y=a +b; //dont think it will run as they are diff variable types
		//ok this one ran, probably becuase i defined y as a double to begin with
		
		//y = a+d; //this one defo wont run
		//correct
		
		z =e+f; //should run as i am concataing stings
		//correct
		
		//y = bc;//powerpoint said it would run but it didnt
		//it didnt run so need an * in it
		
		pi = 22/7;//should run as this is a decimal
		//it only displays as three even tho pi is defined as a double
		//might round because the actual fraction of 22/7 is too long to be represented as a decimal?
		
		//z = name/g;// dont think it will run
		//correct
		
		//z = c/g; // dont think it will run as i have stored g as a byte
		//correct
		
		////x = Math.pow(x,  3);
		//doesnt run because you cant use math and pow?!?!
		
		z = name + " is " + f +h;// think it will run because i have defined the string first
		//correct
		
		//y = (name + 10)/(name +h);// dont think it will run becuase name plus ten is a string and you cant perform maths on it
		//correct
		
		y = (a+b)/(b+c);// will run as y is a double so all athremetic
		//correct
		
		y = 100.3;
		y = (y/(a+b))-c;// will run because once again it has all the right data types
		//correct
		
		//next one wont run as you cant define something to the power in the declration
		
		//name = "is" +f -h;//wont run as you cant wubtract a string
		//correct
		
		y = (pi+1/pi+2)/pi+3;// will run as declared types are ok
		//correct
		
		y = b/g;
		
		System.out.println(y);
		
		
	};
};
