package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import calculator.Calculation;

public class CalcTest {

    private int amount;
    private int cost;
    private int allowance;
    private float resultExpected;

    @Before
    public void setUp() {
        resultExpected = 1540.0f;
        amount = 54;
        cost =10;
        allowance =1000;
    }

    @Test
    public void test() {
        Calculation.calcNetSalary(amount,cost,allowance);
        assertEquals(resultExpected, Calculation.netSalary, 0.0002);

    }

}