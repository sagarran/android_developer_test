

	public class RomanNumerals {
	    
	       private final int num;   // The number represented by this Roman numeral.
	       
	       /* The following arrays will be used by the toString() function to construct
	        * the standard Roman numeral representation of the number.  For each i,
	        * the number numbers[i] is represented by the corresponding string, romans[i].
	        */
	       
	       private static int[]    numbers = { 1000,  900,  500,  400,  100,   90,  
	                                             50,   40,   10,    9,    5,    4,    1 };
	                                          
	       private static String[] romans = { "M",  "CM",  "D",  "CD", "C",  "XC",
	                                           "L",  "XL",  "X",  "IX", "V",  "IV", "I" };
	          
	       /*
	        * Constructor, Creates the Roman number with the int value specified
	        * by the parameter.  
	        * @throws NumberFormatException if the parameter vaule is less than 1.
	        */
	       public RomanNumerals(int naturalNumbers) {
	          if (naturalNumbers < 1)
	             throw new NumberFormatException("Value of RomanNumeral must be positive.");
	          
	          num = naturalNumbers;
	       }
	       
	    
	       /*
	        * Constructor creates the Roman number with the given representation.
	        * For example, RomanNumeral("xvi") is 16.  If the parameter is not identfied as a
	        * legal Roman numeral, a NumberFormatException is thrown.  Both upper and
	        * lower case letters are allowed.
	        * @throws NumberFormatException if the parameter is not a legal Roman numeral
	        */
	       public RomanNumerals(String roman) {
	             
	          if (roman.length() == 0)
	             throw new NumberFormatException("An empty string does not define a Roman numeral.");
	             
	          roman = roman.toUpperCase();  
	          
	          int i = 0;       // The position in the string, roman;
	          int naturalNumber = 0;  // Natural number equivalent of the part of the string that has
	                           //    been converted so far.
	          
	          while (i < roman.length()) {
	          
	             char letter = roman.charAt(i);        // Letter at the current position in the string.
	             int number = romanToNumber(letter);  // Numerical equivalent of the letter.
	                             
	             i++;  // Move on to the next position in the string
	             
	             if (i == roman.length()) {
	                   // There is no letter in the string following the one we have just processed.
	                   // So just add the number corresponding to the single letter to naturalNumber.
	                naturalNumber += number;
	             }
	             else {
	                   // Look at the next character in the string.  If it has a larger Roman numeral
	                   // equivalent than number, then the two letters are counted together as
	                   // a Roman numeral with value (nextNumber - number).
	                int nextNumber = romanToNumber(roman.charAt(i));
	                if (nextNumber > number) {
	                     // Combine the two letters in the string to get one value, and move on to next position in string.
	                   naturalNumber += (nextNumber - number);
	                   i++;
	                }
	                else {
	                     // Don't combine the letters.  Just add the value of the one letter onto the number.
	                   naturalNumber += number;
	                }
	             }
	             
	          }  // end while
	          
	         
	             
	          num = naturalNumber;
	          
	       } // end constructor
	       
	    
	       /*
	        * Find the integer value of the letter considered to be as a Roman numeral.  Throws
	        * NumberFormatException if letter is not a legal Roman numeral.
	        */
	       private int romanToNumber(char letter) {
	          switch (letter) {
	             case 'I':  return 1;
	             case 'V':  return 5;
	             case 'X':  return 10;
	             case 'L':  return 50;
	             case 'C':  return 100;
	             case 'D':  return 500;
	             case 'M':  return 1000;
	             default:   throw new NumberFormatException(
	                          "Illegal character \"" + letter + "\" in Roman numeral");
	          }
	       }
	       
	    
	       /**
	        * Return the standard representation of this Roman numeral.
	        */
	       public String toString() {
	          String roman = "";  // The roman numeral.
	          int D = num;        // D represents the part of num that has
	                              //   to be still converted to Roman numeral representation.
	          for (int i = 0; i < numbers.length; i++) {
	             while (D >= numbers[i]) {
	                roman += romans[i];
	                D -= numbers[i];
	             }
	          }
	          return roman;
	       }
	       
	     
	       /**
	        * Return the value of this Roman numeral as an int.
	        */
	       public int toInteger() {
	          return num;
	       }
	     
	       
	    } // end class RomanNumerals

