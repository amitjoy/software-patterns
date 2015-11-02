package tum.pse;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class MoneyTest {
//	@Ignore("Don't execute")
	@Test(expected=NullPointerException.class, timeout = 1)
	public void simpleAdd() {
		Money m12CHF = new Money(12, "CHF");
		Money m14CHF = new Money(14, "CHF");
		Money expected = new Money(26, "CHF");
		Money observed = m12CHF.add(m14CHF);
		assertTrue(expected.equals(observed));

		Money m12EUR = new Money(12, "EUR");
		Money m14USD = new Money(14, "USD");
		Money observedSumDifferentCurrency = m12EUR.add(m14USD);
		assertNull(observedSumDifferentCurrency);
	}
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Executed");
	}
}
