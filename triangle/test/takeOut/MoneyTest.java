package takeOut;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {
	private Money money;
	@Test
	public void test_can_take_out() {
		money = new Money();
		assertEquals (true, money.can_take_out(1));
		assertEquals (true, money.can_take_out(2));
		assertEquals (false, money.can_take_out(84));
		
	}

}
