import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
	
	public static void main(String args[]){
		try {
			FileWriter writer = new FileWriter(new File("D:\\integrated.csv"));
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
			System.out.println("Processing for year 92..");
			CsvWriter92.generateCsvFile(writer);
			System.out.println("Processing for year 93 94");
			CsvWriter9394.generateCsvFile(writer);
			System.out.println("Processing for year 95 96");
			CsvWriter9596.generateCsvFile(writer);
			System.out.println("Processing for year 97 98 99 00");
			CsvWriter97989900.generateCsvFile(writer);
			System.out.println("Processing for year 01 02");
			CsvWriter0102.generateCsvFile(writer);
			System.out.println("Processing for year 03 04");
			CsvWriter0304.generateCsvFile(writer);
			System.out.println("Processing for year 05");
			CsvWriter05.generateCsvFile(writer);
			System.out.println("Processing for year 06");
			CsvWriter06.generateCsvFile(writer);
			System.out.println("Processing for year 07 08");
			CsvWriter0708.generateCsvFile(writer);
			System.out.println("Processing for year 09");
			CsvWriter09.generateCsvFile(writer);
			System.out.println("Processing for year 10");
			CsvWriter10.generateCsvFile(writer);
			System.out.println("Processssed all year data");
			System.out.println("Closing the output stream");
			writer.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
