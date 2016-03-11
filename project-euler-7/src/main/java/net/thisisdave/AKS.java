package net.thisisdave;

/**
 * Based on AKS Primality Test
 */
public class AKS {

    enum Number{
        COMPOSITE,
        PRIME
    }

    public Number calculateType(int number){
        Number returnType = null;
        isValidInput(number);

        if(isPower(number)){
            return Number.COMPOSITE;
        }


        return returnType;
    }


    /**
     * Stage one of the AKS Primalisty Test
     * Checks if the given number is a power of another number. If so, the given number must be a Composite number
     *
     * @param number
     * @return true if the number is composite, otherwise it is false
     */
    private boolean isPower(int number){
        double a;
        for(int b=2; b <= (Math.log(number) / Math.log(2));b++){
            a = Math.pow(number,(1/b));
            if(Math.floor(a) == Math.ceil(a)){
                return true ;
            }
        }
        return false;
    }

    private boolean isValidInput(int number){
        if(number < 1){
            throw new ArithmeticException(String.format("The provided number must be 1 or greater. Provided number was: %d",number));
        }
        return true;
    }

}
