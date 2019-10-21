package codewars_6kyu;

/*
Write a function that takes an integer as input, and returns the number of bits that are equal to one in the binary representation of that number. You can guarantee that input is non-negative.

Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case
 */



public class BitCounting {



        public int countBits(int n){
            // Show me the code!
            String binary=Integer.toBinaryString(n);
            int b=0;
            for(char c : binary.toCharArray())
            {
                if (c=='1'){b++;}
            }
            return b;
        }



}
