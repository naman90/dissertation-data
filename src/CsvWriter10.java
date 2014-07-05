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

public class CsvWriter10 {
	
	public static void generateCsvFile(FileWriter writer) {
		try {
			int count = 0;
			String line = "";
			String files[] = {"C:\\Users\\Naman\\Dropbox\\dissertation\\ed-data\\processeddata\\1010\\ED2010.txt" };
			
			
			for (int i = 0; i <files.length; i++) {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(files[i]));
				while ((line = bufferedReader.readLine()) != null) {
					String monthString = line.substring(0, 2);

					writer.append(monthString);
					writer.append(',');
					
					//String yearString = line.substring(2, 6);

					writer.append("2010");
					writer.append(',');

					
					//Day of Week
					writer.append(line.charAt(2));
					writer.append(',');

					// Age
					writer.append(line.substring(3, 6));
					writer.append(',');

					// Sex
					writer.append(line.charAt(20));
					writer.append(',');

					// Race
					writer.append(line.substring(23, 25));
					writer.append(',');

					// Self Paid
					writer.append(line.charAt(31));
					writer.append(',');

					// Visit Weight
					writer.append(line.substring(288,293).trim());
					writer.append(',');

					// region
					writer.append(line.charAt(294));
					writer.append(',');

					// hospital code
					writer.append(line.substring(301,304).trim());
					writer.append(',');

					// hospital owner
					writer.append(line.charAt(296));
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
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}