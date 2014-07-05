import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class CsvWriter9394 {
	/*public static void main(String[] args) {
		generateCsvFile();
	}
*/
	public static void generateCsvFile(FileWriter writer) {
		try {
			int count = 0;
			String line = "";
			String files[] = {
					"C:\\Users\\Naman\\Dropbox\\dissertation\\ed-data\\processeddata\\02-9394\\ED93",
					"C:\\Users\\Naman\\Dropbox\\dissertation\\ed-data\\processeddata\\02-9394\\ED94" };
			
			
			for (int i = 0; i <files.length; i++) {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(files[i]));
				while ((line = bufferedReader.readLine()) != null) {
					String monthString = line.substring(0, 2);

					writer.append(monthString);
					writer.append(',');

					String dayString = line.substring(2, 4);
					String yearString = "19" + line.substring(4, 6);

					writer.append(yearString);
					writer.append(',');

					Calendar calendar = new GregorianCalendar(
							Integer.parseInt(yearString),
							Integer.parseInt(monthString),
							Integer.parseInt(dayString));
					Integer dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

					writer.append(dayOfWeek.toString());
					writer.append(',');

					// Age
					writer.append(line.substring(6, 8));
					writer.append(',');

					// Sex
					writer.append(line.charAt(8));
					writer.append(',');

					// Race
					writer.append(line.charAt(9));
					writer.append(',');

					// Self Paid
					writer.append(line.charAt(16));
					writer.append(',');

					// Visit Weight
					writer.append(line.substring(160,165).trim());
					writer.append(',');

					// region
					writer.append(line.charAt(165));
					writer.append(',');

					// hospital code
					writer.append(line.substring(168, 171).trim());
					writer.append(',');

					// hospital owner
					writer.append(line.charAt(167));
					writer.append(',');

					// Alcohol/Drug Problem
					char problemchar = line.charAt(70);
					String alcoholProblem = "0";
					String drugProblem = "0";
					if (problemchar == '2') {
						alcoholProblem = "1";
					} else if (problemchar == '3') {
						drugProblem = "1";
					}

					// Set alcohol Problem
					writer.append(alcoholProblem);
					writer.append(',');

					// Set Drug Problem
					writer.append(drugProblem);
					writer.append('\n');

					count++;
				}
				bufferedReader.close();
				System.out.println(i);
				System.out.println(count);
				count=0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}