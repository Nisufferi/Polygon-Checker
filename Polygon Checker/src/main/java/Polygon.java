import java.util.ArrayList;
import java.util.List;

public class Polygon {
	Integer polygonPointCount;
	List<Point> polygonPoints = new ArrayList<Point>();
	/**
	 * @param polygonCoordinates
	 */
	public void newPolygon(String polygonCoordinates) {
		String[] coordinates = polygonCoordinates.split("\\s*[,]\\s*");
		for (int i = 0; i < coordinates.length; i += 2) {
			int x = 0;
			int y = 0;
			try {
				x = Integer.parseInt(coordinates[i]);
				y = Integer.parseInt(coordinates[i + 1]);
			} catch (RuntimeException e) {
				
			}
			polygonPoints.add(new Point(x, y));
		}
		polygonPointCount = polygonPoints.size();
	}
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean contains(int x, int y) {
		int i;
		int j;
		boolean result = false;
		for(i = 0, j = polygonPoints.size() - 1; i < polygonPoints.size(); j = i++) {
			if((polygonPoints.get(i).yCoordinate > y) != (polygonPoints.get(j).yCoordinate > y) && (x < (polygonPoints.get(j).xCoordinate - polygonPoints.get(i).xCoordinate) * (y - polygonPoints.get(i).yCoordinate) / (polygonPoints.get(j).yCoordinate - polygonPoints.get(i).yCoordinate) + polygonPoints.get(i).xCoordinate)) {
				result = !result;
			}
		}
		return result;
	}
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isCoordinateOnPolygonBorder(int x, int y) {
		int cX = x;
		int cY = y;
		Boolean onBorder = false;
		for(int i = 0, j = polygonPointCount - 1; i < polygonPointCount; j = i++) {
			onBorder = false;
			int aX = polygonPoints.get(i).xCoordinate;
			int aY = polygonPoints.get(i).yCoordinate;
			int bX = polygonPoints.get(j).xCoordinate;
			int bY = polygonPoints.get(j).yCoordinate;
			
			double dx = aX - bX;
			double dy = aY - bY;
			double ab = Math.sqrt(dx * dx + dy * dy);
			
			dx = aX - cX;
			dy = aY - cY;
			double ac = Math.sqrt(dx * dx + dy * dy);
			
			dx = bX - cX;
			dy = bY - cY;
			double bc = Math.sqrt(dx * dx + dy * dy);
			
			if(ac + bc - ab <= 0.2) {
				onBorder =  true;
			}
		}
		return onBorder;
	}
	/**
	 * @return
	 */
	public String getPolygonCoordinates() {
		String coords = "";
		for (Point point : polygonPoints) {
			coords += ("(" + point.xCoordinate.toString() + "," + point.yCoordinate.toString() + ")");
		}
		return coords;
	}
	/**
	 * @return
	 */
	public int getPoints() {
		return polygonPointCount;
	}
	/**
	 * @return
	 */
	public List<Point> getCoordinates() {
		return polygonPoints;
	}
	
}

