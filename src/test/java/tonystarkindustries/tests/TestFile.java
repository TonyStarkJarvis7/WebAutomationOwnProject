package tonystarkindustries.tests;

import java.util.ArrayList;
import java.util.Arrays;

public class TestFile {

	static String month =""; 
	public static void main(String[] args) {
		
		ArrayList<String> al=new ArrayList<String>(Arrays.asList("February","March", "April"));
		for(String s: al) {
			month=s; 
			String monthName="January";
			boolean flag=true;
			while(flag) {
				if(monthName!=month) {
					System.out.println("Click on right arrow");
					System.out.println("Extract monthName");
					System.out.println("Updating monthName variable");
				}else {
					System.out.println("Extract dates of that month");
					flag=false;
				}
			}
			
		}
		
	}

}
