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

public class CsvWriter06 {
	public static void main(String[] args) {
		generateCsvFile();
	}

	private static void generateCsvFile() {
		// Connection con=null;
		String sFileName = "C:\\Users\\Naman\\Dropbox\\dissertation\\ed-data\\processeddata\\07-0506\\merged06.csv";
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
			String files[] = {"C:\\Users\\Naman\\Dropbox\\dissertation\\ed-data\\processeddata\\07-0506\\ED2006" };
			
			
			for (int i = 0; i <files.length; i++) {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(files[i]));
				while ((line = bufferedReader.readLine()) != null) {
					String monthString = line.substring(0, 2);

					writer.append(monthString);
					writer.append(',');
					
					String yearString = line.substring(2, 6);

					writer.append(yearString);
					writer.append(',');

					
					//Day of Week
					writer.append(line.charAt(6));
					writer.append(',');

					// Age
					writer.append(line.substring(7, 10));
					writer.append(',');

					// Sex
					writer.append(line.charAt(24));
					writer.append(',');

					// Race
					writer.append(line.charAt(26));
					writer.append(',');

					// Self Paid
					writer.append(line.charAt(31));
					writer.append(',');

					// Visit Weight
					writer.append(line.substring(404,410).trim());
					writer.append(',');

					// region
					writer.append(line.charAt(410));
					writer.append(',');

					// hospital code
					writer.append(line.substring(416,419).trim());
					writer.append(',');

					// hospital owner
					writer.append(line.charAt(412));
					writer.append(',');

					// Alcohol/Drug Problem
					//char problemchar = line.charAt(38);
					String alcoholProblem = "0";
					String drugProblem = "0";
					
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