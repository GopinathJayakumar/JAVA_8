package day4;

public class JavaBasic {



	public static void main(String[] args) {

		//Control Flow
		// - Loops
		// - Conditions


		// Learn Arrays

		String txt = "Testleaf";

		//Way 1
		String[] txt1 = {"Selenium", "Appium", "WebService", "Python", "Java"};

		//Way 2
		String[] text = new String[5]; 
		text[0] = "Selenium"; 
		text[1] = "Appium";
		text[2] = "WebService"; 
		text[3] = "Python";
		text[4] = "Java";
		System.out.println(text.length);

		//if , swith Case

		//Loop - for, foreach, do and while
		for(int i = 0; i< txt1.length; i++) {
			System.out.println(txt1[i]);
		}
		
		//dataType variable : collection
		
		for (String eachText : text) {
			System.out.println(eachText);
		}
		
		
















	}

}
