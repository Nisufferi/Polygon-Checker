import java.util.ArrayList;
import java.util.List;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Polygon polygon = new Polygon();
		Point point = new Point();
		FileHandler fileHandler = new FileHandler();
		List<Point> testPoints = new ArrayList<Point>();
		
		String polygonCoordinates = fileHandler.getPolygonFileAsString();
		if(polygonCoordinates == null) {
			polygon.newPolygon("-5,-5,-5,5,5,5,5,-5");
		}
		else if(polygonCoordinates != null) {
			polygon.newPolygon(polygonCoordinates);
		}
		
		String coordinates = fileHandler.getPointsFileAsString();
		if(coordinates == null) {
			for (int i = 0; i < 10; i++) {
				testPoints.add(new Point());
			}
		}
		else if(coordinates != null) {
			testPoints = point.newPointsFromFile(coordinates);
		}
		
		isPointInPolygonOrBorder(polygon, point, fileHandler, testPoints);
		
		System.out.println("Luotu tiedosto selvitys.txt");
	}
	/**
	 * @param polygon
	 * @param point
	 * @param fileHandler
	 * @param testPoints
	 */
	static void isPointInPolygonOrBorder(Polygon polygon, Point point, FileHandler fileHandler, List<Point> testPoints) {
		String textToWrite = "";
		for(int i = 0; i < testPoints.size(); i++) {
			Boolean onBorder = false;
			onBorder = polygon.isCoordinateOnPolygonBorder(testPoints.get(i).xCoordinate, testPoints.get(i).yCoordinate);
			Boolean resultInside = polygon.contains(testPoints.get(i).xCoordinate, testPoints.get(i).yCoordinate);
			textToWrite += ("The coordinates: " + testPoints.get(i).xCoordinate + "," + testPoints.get(i).yCoordinate + " " );
			if(onBorder) {
				textToWrite += ("Are on BORDER of the polygon:" + polygon.getPolygonCoordinates()+ "\n");
			}
			else if(resultInside) {
				textToWrite += ("Are inside the polygon:" + polygon.getPolygonCoordinates()+ "\n");
			}
			else if(!resultInside) {
				textToWrite += ("Are NOT inside the polygon:" + polygon.getPolygonCoordinates()+ "\n");
			}
		}
		fileHandler.writeStatement(textToWrite);
	}
}
