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

public class CsvWriter9596 {
	public static void main(String[] args) {
		generateCsvFile();
	}

	private static void generateCsvFile() {
		// Connection con=null;
		String sFileName = "C:\\Users\\Naman\\Dropbox\\dissertation\\ed-data\\processeddata\\02-9596\\merged9596.csv";
		try {
			
			FileWriter writer = new FileWriter(sFileName);
			writer.append("Month");
			writer.append(',');
			writer.append("Year");
			writer.append(',');
			writer.append("Day of Visit");
			writer.append(',');
			writer.append("Age");
			writer.append(',');
			writer.append("Sex");
			writer.append(',');
			writer.append("Race");
			writer.append(',');
			writer.append("Self Paid");
			writer.append(',');
			writer.append("Visit Weight");
			writer.append(',');
			writer.append("Region");
			writer.append(',');
			writer.append("Hospital Code");
			writer.append(',');
			writer.append("Hospital Owner");
			writer.append(',');
			writer.append("Alcohol Problem");
			writer.append(',');
			writer.append("Drug Problem");
			writer.append('\n');
			int count = 0;
			String line = "";
			String files[] = {
					"C:\\Users\\Naman\\Dropbox\\dissertation\\ed-data\\processeddata\\02-9596\\ED95",
					"C:\\Users\\Naman\\Dropbox\\dissertation\\ed-data\\processeddata\\02-9596\\ED96" };
			
			
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
					writer.append(line.substring(10, 13));
					writer.append(',');

					// Sex
					writer.append(line.charAt(14));
					writer.append(',');

					// Race
					writer.append(line.charAt(13));
					writer.append(',');

					// Self Paid
					char selfpaid=line.charAt(17);
					if(selfpaid=='4'){
					    writer.append('1');
					}else{
						writer.append('0');
					}
					writer.append(',');

					// Visit Weight
					writer.append(line.substring(174, 180).trim());
					writer.append(',');

					// region
					writer.append(line.charAt(180));
					writer.append(',');

					// hospital code
					writer.append(line.substring(183, 186).trim());
					writer.append(',');

					// hospital owner
					writer.append(line.charAt(181));
					writer.append(',');

					// Alcohol/Drug Problem
					char problemchar = line.charAt(73);
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
			
			writer.flush();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}