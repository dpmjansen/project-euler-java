package net.thisisdave;

import java.util.Arrays;

/**
 * Created by David on 13-3-2016.
 */
public class PrimeFinder {

    private int requestedPrime;
    private int[] foundPrimes;

    public static void main(String[] args) {
        PrimeFinder finder = new PrimeFinder();
        finder.requestedPrime = 5;
        finder.evaluate();
    }

    public PrimeFinder(){
        foundPrimes = new int[0];
    }

    public void evaluate(){

        int counter = 1;
        while(foundPrimes.length != requestedPrime){

            int value = isPrime(counter);
            if(value != -1){
                foundPrimes = Arrays.copyOf(foundPrimes,foundPrimes.length +1);
                foundPrimes[foundPrimes.length - 1] = value;
            }
            if(foundPrimes.length == requestedPrime){
                break;
            }
            counter++;
        }

        System.out.println(foundPrimes[requestedPrime]);

    }


    /**
     *
     *
     * @param a
     * @return -1 if not a prime, else it will return the number
     */
    private int isPrime(int a){

        if(a == 2){
            return a;
        }

        if(a > 2 && a % 2 == 0){
            return -1;
        }

        int sqrt = (int) Math.sqrt(a);

        for(int i = 0; i < foundPrimes.length;i++){
            int currentPrime = foundPrimes[i];

            if(currentPrime > sqrt){
                return a;
            }

            if(sqrt % currentPrime == 0){
                return -1;
            }

        }

        //Should not be possible
        return -1;
    }

}
