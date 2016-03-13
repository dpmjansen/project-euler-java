package net.thisisdave;

/**
 * Created by David on 13-3-2016.
 */
public class Problem7 {

    public static void main(String[] args) {
        Problem7.getSolution();
    }

    public static void getSolution(){
        int num = 0;
        int i = 1;
        while(num < 10001){
            i++;
            if(isPrime(i)){
                num++;
            }
        }
        System.out.println((i));
    }

    public static boolean isPrime(long n) {
        for (long i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
