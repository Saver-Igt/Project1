package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculator.Tax;

public class TaxTest {
	private int amount;
    private int cost;
    private int allowance;
    private float resultExpected;
    private float percent; 
	@Before
    public void setUp() {
        resultExpected = 2400.0f;
        amount = 70;
        cost =100;
        allowance =1000;
        percent=30.0f;
    }
	@Test
	public void test() {
		Tax tax = new Tax(percent);
		tax.calcNetSalary(amount, cost, allowance);
		assertEquals(resultExpected, tax.calc(), 0.0002);
		
	}

}
