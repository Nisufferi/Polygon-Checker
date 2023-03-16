import java.util.ArrayList;
import java.util.List;

public class Point {
	Integer xCoordinate;
	Integer yCoordinate;
	/**
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		xCoordinate = x;
		yCoordinate = y;
	}
	/**
	 * 
	 */
	public Point() {
		xCoordinate = (int)Math.floor(Math.random() *(9 - (-1) + 1) + (-1));
		yCoordinate = (int)Math.floor(Math.random() *(9 - (-1) + 1) + (-1));
	}
	/**
	 * @param pointCoordinates
	 * @return
	 */
	public List<Point> newPointsFromFile(String pointCoordinates) {
		String[] coordinates = pointCoordinates.split("\\s*[,]\\s*");
		List<Point> testPoints = new ArrayList<Point>();
		if(coordinates.length % 2 != 0) {
			throw new RuntimeException("Requires even amount of numbers.");
		}
		for (int i = 0; i < coordinates.length; i += 2) {
			int x = Integer.parseInt(coordinates[i]);
			int y = Integer.parseInt(coordinates[i + 1]);
			
			testPoints.add(new Point(x, y));
		}
		return testPoints;
	}
	/**
	 * @return
	 */
	public Integer getXCoordinate() {
		return xCoordinate;
	}
	/**
	 * @return
	 */
	public Integer getYCoordinate() {
		return yCoordinate;
	}
}
