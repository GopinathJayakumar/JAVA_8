package day3;

public class printNextChar {

	public static void main(String[] args) {
		String txt = "A1B2C3";	
		for (int i = 0; i < txt.length(); i++) {			
			System.out.print((char)((int)txt.charAt(i)+1));
		}
		System.out.println();		
	}	
}
