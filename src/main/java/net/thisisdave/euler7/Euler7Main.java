package net.thisisdave.euler7;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Euler7Main {

    private static Logger logger = LoggerFactory.getLogger(Euler7Main.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();
        int requestedPosition = Integer.parseInt(args[0]);
        logger.info(String.format("Finding prime number matching position %d...", requestedPosition));

        Euler7Main euler7Main = new Euler7Main();
        int position = 0;

        for (double i = 0;; i++) {
            if(position == requestedPosition){
                break;
            }
            if(euler7Main.isPrime(i)){
                position++;
                logger.info(String.format("Found prime: %f on index %d", i, position));
            }
//            logger.info(String.format("Current position: %d", position));
        }
    }

    private boolean isPrime(double number){

//        logger.debug("Processing number " + number);

        if(number <= 0) {
            return false;
        }

        if(number == 2){
//            logger.debug(String.format("Found prime!: %f", number));
            return true;
        }

        if(number % 2 == 0){
            return false;
        }


        double sqrt = Math.ceil(Math.sqrt(number));
        double other = sqrt - 1;

        if(other < 3){
            return true;
        }
        for(;other!=2;other--){
            if(sqrt % other == 0){
                return false;
            }
        }
//        logger.debug(String.format("Found prime!: %f", number));
        return true;

    }
}
