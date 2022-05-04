package se.kth.iv1350.hackers.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AmountTest {
    private Amount amountWithTwo;
    private Amount amountWithZero;
    
    @BeforeEach
    public void setUp(){
       amountWithTwo = new Amount(2);
       amountWithZero = new Amount(0);
    }

    @AfterEach
    void tearDown(){
        amountWithTwo = null;
        amountWithZero = null;
    }

    @Test
    void testEqual(){
        double amountOfOther = 2;
        Amount other = new Amount(amountOfOther);
        boolean expectedResult = true;
        boolean result = amountWithTwo.equals(other);
        assertEquals(expectedResult, result, "The Amount objects do not share the same values.");
    }
    @Test
    void testNotEqual(){
        double amountOfOther = 1;
        Amount other = new Amount(amountOfOther);
        boolean expectedResult = false;
        boolean result = amountWithTwo.equals(other);
        assertEquals(expectedResult, result, "The Amount objects do not share the same values.");
    }

    @Test
    void testIncrease(){
        double amountOfOperand1 = 2;
        double amountOfOperand2 = 1;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expectedResult = new Amount(amountOfOperand1 + amountOfOperand2);
        Amount result = operand1.increase(operand2);
        assertEquals(expectedResult, result, "Wrong addition result"); 
    }

    @Test
    void testIncreaseNegResult(){
        double amountOfOperand1 = -2;
        double amountOfOperand2 = 1;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expectedResult = new Amount(amountOfOperand1 + amountOfOperand2);
        Amount result = operand1.increase(operand2);
        assertEquals(expectedResult, result, "Wrong addition result"); 
    }

    @Test
    void testIncreaseZeroResultNegOperand(){
        double amountOfOperand1 = -1;
        double amountOfOperand2 = 1;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expectedResult = new Amount(amountOfOperand1 + amountOfOperand2);
        Amount result = operand1.increase(operand2);
        assertEquals(expectedResult, result, "Wrong addition result"); 
    }

    @Test
    void testDecrease(){
        double amountOfOperand1 = 2;
        double amountOfOperand2 = 1;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expectedResult = new Amount(amountOfOperand1 - amountOfOperand2);
        Amount result = operand1.decrease(operand2);
        assertEquals(expectedResult, result, "Wrong subtraction result.");
    }

    @Test
    void testDecreaseNegResult(){
        double amountOfOperand1 = 1;
        double amountOfOperand2 = 2;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expectedResult = new Amount(amountOfOperand1 - amountOfOperand2);
        Amount result = operand1.decrease(operand2);
        assertEquals(expectedResult, result, "Wrong subtraction result.");
    }

    @Test 
    void testDecreaseZeroResultNegOperand(){
        double amountOfOperand1 = -1;
        double amountOfOperand2 = -1;
        Amount operand1 = new Amount (amountOfOperand1);
        Amount operand2 = new Amount (amountOfOperand2);
        Amount expectedResult = new Amount(amountOfOperand1 - amountOfOperand2);
        Amount result = operand1.decrease(operand2);
        assertEquals(expectedResult, result, "Wrong subtraction result");
    }

    @Test
    void multiplyTest(){
        double amountOfOperand1 = 2;
        double amountOfOperand2 = 1;
        Amount operand1 = new Amount (amountOfOperand1);
        Amount operand2 = new Amount (amountOfOperand2);
        Amount expectedResult = new Amount(amountOfOperand1 * amountOfOperand2);
        Amount result = operand1.multiply(operand2);
        assertEquals(expectedResult, result, "Wrong multiplication result");
    }

    @Test
    void multiplyNegOperand(){
        double amountOfOperand1 = -2;
        double amountOfOperand2 = 1;
        Amount operand1 = new Amount (amountOfOperand1);
        Amount operand2 = new Amount (amountOfOperand2);
        Amount expectedResult = new Amount(amountOfOperand1 * amountOfOperand2);
        Amount result = operand1.multiply(operand2);
        assertEquals(expectedResult, result, "Wrong multiplication result");
    }

    @Test
    public void testNotEqualsJavaLangObject(){
        Object other = new Object();
        boolean expRes = false;
        boolean result = amountWithZero.equals(other);
        assertEquals(expRes, result,    "Amount instance equal java.lang.Object.");
    }


}
