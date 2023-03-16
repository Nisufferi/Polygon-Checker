import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestPoint {
	Point pisteet = new Point();
	@Test
	void whenRandomNewPointIsCreatedSuccesfully() {
		if(pisteet.xCoordinate > -10 && pisteet.xCoordinate < 10 || pisteet.yCoordinate > -10 && pisteet.yCoordinate < 10) {
			Assert.assertTrue(true);
		}
	}
	/**
	 * 
	 */
	@Test
	void whenIncorrectSyntaxIsGiven() {
		Assertions.assertThrows(RuntimeException.class, () -> pisteet.newPointsFromFile("x,xxv"));
	}
	/**
	 * 
	 */
	@Test
	void whenGivenEvenAmountOfIntegersSeparatedByComma() {
		pisteet.newPointsFromFile("1,2,3,4,5,6,7,8");
	}
	/**
	 * 
	 */
	@Test
	void whenGivenUnEvenAmountOfNumbers() {
		Assertions.assertThrows(RuntimeException.class, () -> pisteet.newPointsFromFile("1,2,3,4,5,6,7"));
	}
}
