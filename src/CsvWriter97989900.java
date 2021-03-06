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

public class CsvWriter97989900 {

	public static void generateCsvFile(FileWriter writer) {
		try {
			
			int count = 0;
			String line = "";
			String files[] = {
					"C:\\Users\\Naman\\Dropbox\\dissertation\\ed-data\\processeddata\\04-97989900\\ED97",
					"C:\\Users\\Naman\\Dropbox\\dissertation\\ed-data\\processeddata\\04-97989900\\ED98",
					"C:\\Users\\Naman\\Dropbox\\dissertation\\ed-data\\processeddata\\04-97989900\\ED99",
					"C:\\Users\\Naman\\Dropbox\\dissertation\\ed-data\\processeddata\\04-97989900\\ED00" };
			
			
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
					writer.append(line.substring(11, 14));
					writer.append(',');

					// Sex
					writer.append(line.charAt(15));
					writer.append(',');

					// Race
					writer.append(line.charAt(17));
					writer.append(',');

					// Self Paid
					char selfpaid=line.charAt(19);
					if(selfpaid=='5'){
					    writer.append('1');
					}else{
						writer.append('0');
					}
					writer.append(',');

					// Visit Weight
					writer.append(line.substring(284, 289).trim());
					writer.append(',');

					// region
					writer.append(line.charAt(290));
					writer.append(',');

					// hospital code
					writer.append(line.substring(293, 295).trim());
					writer.append(',');

					// hospital owner
					writer.append(line.charAt(292));
					writer.append(',');

					// Alcohol/Drug Problem
					char problemchar = line.charAt(73);
					String alcoholProblem = "0";
					String drugProblem = "0";
					//No Data found so set 0 to impude
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