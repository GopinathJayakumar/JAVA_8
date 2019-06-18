package day3;

public class FindOccurences {
	
	public static void main(String[] args) {
		
		String check = "Cognizanta";
				
// Solution 1		
		// Find the length of the String :{{length}}
		// Move to each character item :{{charAt[i]}}
		// Check if it has the expected character, if yes -> count ++
		int occuranceOfN = 0;
		char[] charArray = check.toCharArray();
		for (char c : charArray) {
			// don't use equals here
			if(c=='a'){
				occuranceOfN ++;
			}
		}	
		System.out.println("Occurance of a is :" +occuranceOfN);
		
// Solution 2
		int occurance = 0;
		for (int i=0; i<check.length(); i ++) {
			// don't use equals here
			if(check.charAt(i)=='a'){
				occurance ++;
			}
		}		
		System.out.println("Occurance of a is :" +occurance);

// Solution 3 {One liner}
		// Split using character :{{split("c")}}
		// Get the array size :{{length-1}}		
		// Anything else??		
		if(check.endsWith("a")){
			System.out.println(check.split("a").length);
		}else{
			System.out.println(check.split("a").length-1);
		}

// Solution 4:  How about replaceAll??
		// count before replace - count after replace??		
		System.out.println(check.length()-check.replace("a","").length());
		
		


	}

}
