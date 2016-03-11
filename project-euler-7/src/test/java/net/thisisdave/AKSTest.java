package net.thisisdave;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Tests for AKS
 */
public class AKSTest {

    private AKS aks;

    @Before
    public void setup(){
        aks = new AKS();
    }

    @Test(expected = ArithmeticException.class)
    public void valueIsInvalid(){
        try {
            Method method = AKS.class.getDeclaredMethod("isPower");
            method.setAccessible(true);
            method.invoke(aks, -1);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e){
            e.printStackTrace();
        }
    }

    @Test
    public void numberIsPower(){
        try {
            Method method = AKS.class.getDeclaredMethod("isPower");
            method.setAccessible(true);
            method.invoke(aks, 1);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e){
            e.printStackTrace();
        }
    }

}
