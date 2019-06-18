package day3;

public class ReverseNumber {

/*	    public static void main(String[] args) {

	        int num = 12345986, reversed = 0;

	        while(num != 0) {
	            int digit = num % 10;
	            reversed = reversed * 10 + digit;
	            num /= 10;
	        }

	        System.out.println("Reversed Number: " + reversed);
	    }
	}
*/
public static void main(String[] args) {

    int num = 1234567, reversed = 0;

    for(;num != 0; num /= 10) {
        int digit = num % 10;
        reversed = reversed * 10 + digit;
    }

    System.out.println("Reversed Number: " + reversed);
}
}