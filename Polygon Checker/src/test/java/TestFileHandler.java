import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

class TestFileHandler {
	FileHandler fileHandler = new FileHandler();
	/**
	 * 
	 */
	@Test
	void ifPolygonFileDoesntExist() {
		assertNull(fileHandler.getPolygonFileAsString());
	}
	@Test
	void ifPointsFileDoesntExist() {
		assertNull(fileHandler.getPointsFileAsString());
	}
	@Test
	void testWriteStatementWithString() {
		fileHandler.writeStatement("12345678");
	}
	

}
