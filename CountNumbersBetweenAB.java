/*
 * The problems is to find the count of numbers between A and B (inclusive) that have sum of digits equal to S.
 *Also print the smallest such number between A and B (inclusive).
 *
 */
package countnumbersbetweenab;

import java.util.ArrayList;

public class CountNumbersBetweenAB {
    // Computing the sum of the digits of a given number
    public static long getSum(long num){    
        int sum = 0; // At the beginning sum is 0
        while(num > 0) { 
            sum += num % 10; // sum = sum + num % 10 ; is the other way of writing this expression.
            num = num / 10; //Update the value of num to avoid infinite loop.
        }
        return sum;// Returning the value of the the sum after the loop if finished.
    }
    /**
     * 
     * @param a lower range bound
     * @param b higher range bound
     * @param s the number to be compared with the sum of digits of the numbers between a & b inclusive
     */
    public static long isSumEqual(long a , long b, long s){
        
        ArrayList<Long> list = new ArrayList<>();
        long min = 0;
        long max = 0;
        long counter = 0;
        for (long i = a; i <= b; i++) {
            if( getSum(i) == s){
                counter++; 
                list.add(i);                 
             }   
        }
        if( !list.isEmpty()){
            min = list.get(0);
            max = list.get(list.size()-1);
        }    
        System.out.println(counter + " numbers between "+a +" and "+ b + " have the sum of digits equal to "+ s);
        System.out.println(min + " is the smallest number between "+a+" and "+b +"  with the sum of digits equal to "+ s);
        System.out.println(max + " is the bigest number between "+a+" and "+b +"  with the sum of digits equal to "+ s);
        return counter;
        
    }
    //Testing the program in the main method.
    public static void main(String[] args) {
        isSumEqual(5,17,5);// 2 numbers and 5 is the smallest of them
        isSumEqual(11,22,4);// 2 numbers and 13 is the smallest of them
        isSumEqual(11,54,7);//.....
        isSumEqual(100,500,7);//.....
    }
    
}
