import java.util.Scanner;

public class Roman2Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String romanNumeral;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a Roman numeral or an integer that you wish to convert \n");
        System.out.println("Type exit when you want to quit!!! \n");
         
         while (true) {
   
            System.out.println();
            romanNumeral = scan.next();
            
            if (romanNumeral.equals("exit"))
            {
            	break;
            }
               
            if(romanNumeral.matches("\\d+")) // If the user input is of type integer then do the following
            {
            	int number = Integer.parseInt(romanNumeral);
            	
                try {
                    RomanNumerals N = new RomanNumerals(number);
                    System.out.println(N.toInteger() + " = " + N.toString());
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    System.out.println(e.getMessage());
                }
            }
            
            
            else {
            	String roman = romanNumeral.toString();
            	roman = roman.toUpperCase();
               try {
                   RomanNumerals N = new RomanNumerals(roman);
                   System.out.println(roman.toString() + " = " + N.toString() + " = " + N.toInteger());
               }
               catch (NumberFormatException e) {
                   System.out.println("Invalid input.");
                   System.out.println(e.getMessage());
               }
            }
   
         }  // end while
         
         System.out.println("The program has ended");
         scan.close();
	}

}
