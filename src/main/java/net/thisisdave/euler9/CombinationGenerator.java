package net.thisisdave.euler9;

/**
 * Created by David on 26-10-2015.
 */
public class CombinationGenerator {

    private int smallestNumber;
    private int middleNumber;
    private int biggestNumber;

    private int totalOutcome;


    public CombinationGenerator(int totalOutcome){
        this.totalOutcome = totalOutcome;
        smallestNumber = 1;
        middleNumber = smallestNumber + 1;
        biggestNumber = totalOutcome - middleNumber - smallestNumber;
    }

    


}
