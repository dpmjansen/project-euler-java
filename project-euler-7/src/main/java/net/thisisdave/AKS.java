package net.thisisdave;

/**
 * Based on AKS Primality Test
 */
public class AKS {

    enum Number{
        COMPOSITE,
        PRIME
    }

    public Number calculateType(double number){
        Number returnType = null;
        isValidInput((int)number);

        if(isPower(number)){
            return Number.COMPOSITE;
        }


        return Number.COMPOSITE;
    }


    /**
     * Stage one of the AKS Primality Test
     * Checks if the given number is a power of another number. If so, the given number must be a Composite number
     * example:
     *  If n = a.pow(b) for integers a > 1 and b > 1, output composite.
     *  For [ b=2, b <= log2(n), b++,
     *  a=n1/b;
     *  If [ a is integer, Return[Composite]]
     *  ];
     *  a=n1/2...n1/4={5.568, 3.141, 2.360}
     *
     *  (From wikipedia)
     *
     * @param number
     * @return true if the number is composite, otherwise it is false
     */
    private boolean isPower(double number){
        double a;
        for(double b=2; b <= (Math.log(number) / Math.log(2));b++){
            a = Math.pow(number,(1/b));
            if(Math.floor(a) == Math.ceil(a)){
                return true ;
            }
        }
        return false;
    }

    /**
     * Stage two of AKS. It will return the smallest R value
     * @param number
     * @return smallest R
     */
    private int smallestR(double number){
        double maxK = Math.floor(Math.pow((Math.log(number)) / (Math.log(2)),2));
        double maxR= Math.max(3,Math.ceil(Math.pow(((Math.log(number))/Math.log(2)),5)));
        int r = 0;
        double result;
        boolean nextR = true;
        for(r=2; nextR && r < maxR; r++){
            nextR = false;
            for(int k=1; (!nextR) && (k <= maxK);k++){
                result = (Math.pow(number,k)) % r;
                nextR=((result == 1) || (result == 0));
            }
        }
        r--;
        return r;
    }

    private boolean isValidInput(int number) {
        if(number < 1){
            throw new ArithmeticException(String.format("The provided number must be 1 or greater. Provided number was: %d",number));
        }
        return true;
    }

}
