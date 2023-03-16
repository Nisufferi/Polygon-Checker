import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
	/**
	 * @return
	 */
	public String getPolygonFileAsString() {
		try {
			File filePolygon = new File("polygoni.txt");
			if(filePolygon.exists()) {
				return txtFileToString(filePolygon);
			}
			else return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * @return
	 */
	public String getPointsFileAsString() {
		try {
			File filePoints = new File("pisteet.txt");
			if(filePoints.exists()) {
				return txtFileToString(filePoints);
			}
			else return null;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String txtFileToString(File file) throws FileNotFoundException {
		String txtFileAsString = null;
		Scanner scanner = null;
		scanner = new Scanner(file);
		txtFileAsString = scanner.next();
		scanner.close();
		return txtFileAsString;
	}
	/**
	 * @param statementRow
	 */
	public void writeStatement(String statementRow) {
		try {
			File selvitys = new File("selvitys.txt");
			FileWriter fileWriter = new FileWriter(selvitys);
			fileWriter.write(statementRow);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
