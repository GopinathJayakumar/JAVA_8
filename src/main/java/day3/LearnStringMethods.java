package day3;

public class LearnStringMethods {
	
	public static void main(String[] args) {
		
		String txt = "Hello Gopi , Welcome to TestLeaf";
		
		//Way 1
		/*
		 * char[] ch = txt.toCharArray();
		 * 
		 * for (int i = ch.length-1; i >=0; i--) { System.out.print(ch[i]); }
		 */
		int count  =0;
		
		//way 2
		for (int i = txt.length()-1; i >= 0; i--) {
			
			if(txt.charAt(i) == 'o') {
			count = count+1;	
			}
			
			
			
		}
		
		System.out.print(count);
		
		
		
		
		
		
		
		
		
		
		
		
	//	System.out.println(txt.replace("Gopi", "Dinesh"));
		
		
		
		//System.out.println(txt.toLowerCase());
		//System.out.println(txt.toUpperCase());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * System.out.println(txt.length());
		 * 
		 * System.out.println(txt.trim().length());
		 */
		
		
		
		
		
		
		
		
		
	
		
		
		
		/*
		 * char[] ch = txt.toCharArray();
		 * 
		 * for(int i = 0; i<ch.length; i++) { System.out.println(ch[i]); }
		 */
		
		
	//	System.out.println(txt.length());
	//	System.out.println(txt.charAt(2));
		
	//	System.out.println(txt.indexOf('o'));
	//	System.out.println(txt.lastIndexOf('o'));
		/*
		 * System.out.println(txt1.concat(txt2)); System.out.println(txt1+txt3);
		 * System.out.println(txt3+txt4);
		 */		
		
		/*
		 * int txt3 = 3; String txt5 = Integer.toString(txt3);
		 * 
		 * int txt4 = 6;
		 * 
		 * System.out.println(txt5+txt4);
		 */
		
		/*
		 * System.out.println(txt.substring(0, 7));
		 * System.out.println(txt.substring(11));
		 */	}

}
