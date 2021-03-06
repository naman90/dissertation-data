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

public class CsvWriter09 {


	public static void generateCsvFile(FileWriter writer) {
		try {
			int count = 0;
			String line = "";
			String files[] = {"C:\\Users\\Naman\\Dropbox\\dissertation\\ed-data\\processeddata\\0909\\ED2009" };
			
			
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
					writer.append(line.substring(27, 29));
					writer.append(',');

					// Self Paid
					writer.append(line.charAt(35));
					writer.append(',');

					// Visit Weight
					writer.append(line.substring(390,396).trim());
					writer.append(',');

					// region
					writer.append(line.charAt(396));
					writer.append(',');

					// hospital code
					writer.append(line.substring(403,405).trim());
					writer.append(',');

					// hospital owner
					writer.append(line.charAt(398));
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