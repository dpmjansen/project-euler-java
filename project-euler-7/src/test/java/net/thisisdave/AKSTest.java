package net.thisisdave;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.fail;

/**
 * Tests for AKS
 */
public class AKSTest {

    private AKS aks;

    @Before
    public void setup(){
        aks = new AKS();
    }

    @Test
    public void valueIsInvalid(){
        try {
            Method method = AKS.class.getDeclaredMethod("isValidInput", int.class);
            method.setAccessible(true);
            method.invoke(aks, -1);
            fail("Should throw ArithmeticException");
        } catch (InvocationTargetException e){
            if(!e.getTargetException().getClass().equals(ArithmeticException.class)){
                fail("Should throw ArithmeticException");
            }
        } catch (IllegalAccessException | NoSuchMethodException e){
            fail("Should throw ArithmeticException");
        }
    }

    /**
     * Hard to test, but inspection based on other data shows that for n=31 the result should be false.
     * Furthermore the passthrough value for this method should respectively be {5.568, 3.141, 2.360} which is true, but
     * only shown when debugging the method. Will work on easier collection of results in the future.
     */
    @Test
    public void numberIsNotPower(){
        try {
            Method method = AKS.class.getDeclaredMethod("isPower",double.class);
            method.setAccessible(true);
            int number = 31;
            boolean result = (boolean)method.invoke(aks, number);
            Assert.assertFalse(String.format("Number is not an power: %d",number),result);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e){
            e.printStackTrace();
        }
    }

    @Test
    public void smallestR() {
        try {
            int number = 31;
            int expectedR = 29;
            Method method = AKS.class.getDeclaredMethod("smallestR", double.class);
            method.setAccessible(true);
            int smallestR = (int) method.invoke(aks, number);
            System.out.println(smallestR);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
