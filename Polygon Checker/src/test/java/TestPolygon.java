import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestPolygon {
	@Test
	void whenNewPolygonIsCreated() {
		Polygon polygon = new Polygon();
		polygon.newPolygon("-4,-4,-4,4,4,4,4,-4");
	}
	/**
	 * 
	 */
	@Test
	void whenIncorrectSyntaxIsGiven() {
		Polygon polygon = new Polygon();
		polygon.newPolygon(",1,2,");
	}
	
	/**
	 * 
	 */
	@Test
	void whenStringContainsNotNumbers() {
		Polygon polygon = new Polygon();
		polygon.newPolygon("xy");
	}

	/**
	 * 
	 */
	@Test
	void whenCorrectSyntaxIsGiven() {
		Polygon polygon = new Polygon();
		polygon.newPolygon("1,2,3,4");
	}
	@Test
	void testTriangle() {
		Polygon polygon = new Polygon();
		polygon.newPolygon("-2,-2,0,2,2,-2");
		Assert.assertTrue(polygon.isCoordinateOnPolygonBorder(0, 2));
		Assert.assertTrue(polygon.contains(0, 0));
	}
}
