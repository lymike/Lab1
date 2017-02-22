package pkg1;
import java.util.Scanner;

public class Retirement_Calculator {

	private static Scanner uI;

	public static void main(String[] args) {
		
		uI = new Scanner(System.in);
		
		System.out.println("How many years do you plan to work?");
		double YOW = uI.nextDouble();
		
		System.out.println("What's the pencentage of your expected average return on investment before retirement?");
		double WAR = (uI.nextDouble()/100);
		while (WAR < 0 || WAR > 0.2) {
			System.out.println("Please input value between 0 and 20.");
			WAR = (uI.nextDouble()/100);
		}
		
		System.out.println("How long do you want to draw?");
		double YR = uI.nextDouble();
		
		System.out.println("What's the pencentage of your expected average return on investment after retirement?");
		double RAR = (uI.nextDouble()/100);
		while (RAR < 0 || RAR > 0.03) {
			System.out.println("Please input value between 0 and 3.");
			RAR = (uI.nextDouble()/100);
		}
		
		System.out.println("How much income do you require after retirement?");
		double RI = uI.nextDouble();
		
		System.out.println("How much SSI per month do you expect?");
		double MSSI = uI.nextDouble();
		
		double NPMT = YOW * 12;
		double RPMT = WAR/12;
		double NPV = YR * 12;
		double RPV = RAR/12;
		double Y = RI - MSSI;	
		
		double PV = Y * (1 - 1/Math.pow(1 + RPV, NPV)) / RPV;
		double PMT = PV * (RPMT/(Math.pow(1 + RPMT, NPMT) - 1));
		
		System.out.printf("Your total savings: $%.2f", PV);
		System.out.printf("\n" + "The Amount you need to save per month: $%.2f", PMT);
		
	}

	

}
