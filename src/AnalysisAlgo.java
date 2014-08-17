import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;


public class AnalysisAlgo {

	public static void main(String arr[]) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("D:\\integrated.csv"));
		String metadata=reader.readLine();
		TreeMap<Integer, TreeMap<Integer, ArrayList<PatientRecord>>> yearMap = new TreeMap<>();
		String line="";
		while( (line=reader.readLine())!=null){
		 String[] split=	line.split(",");
		 Integer month = Integer.parseInt(split[0]);
		 Integer year = Integer.parseInt(split[1]);
		 PatientRecord record = new PatientRecord(split[2],split[3],split[4],split[5],split[6]);
		 TreeMap<Integer, ArrayList<PatientRecord>> monthsMap= yearMap.get(year);
		 if(monthsMap==null ){
			 monthsMap = new TreeMap<>();
			 ArrayList<PatientRecord> recordArray= new ArrayList<>();
			 recordArray.add(record);
			 monthsMap.put(month, recordArray);
			 yearMap.put(year, monthsMap);
		 }else{
			 if(monthsMap.containsKey(month)){
				 monthsMap.get(month).add(record);
			 }else{
				 ArrayList<PatientRecord> recordArray= new ArrayList<>();
				 recordArray.add(record);
				 monthsMap.put(month, recordArray);
			 }
			 
		 }
		  System.out.println(System.currentTimeMillis());
		}
		 
		System.out.print("Preparing Data");
		Object[][] summary = new Object[13][21];
		summary[0][0]= new String("Month");
		int i=0;
		for(Integer year: yearMap.keySet()){
			i++;
			summary[0][i]=year.toString();
		}
		for(i=1;i<=12;i++){
			summary[i][0]= Integer.toString(i);
		}
		
		/*for(int i=1;i<=yearMap.keySet().size();i++)
			summary[0][i]= yearMap.keySet().*/
		i=1;
		TreeMap<Integer, TreeMap<Integer, Integer>> simplifiedTreeMap = new TreeMap<>();
		for(Integer yearSet:yearMap.keySet()){
			TreeMap<Integer, Integer> monthsSimplifiedMap= new TreeMap<>();
			TreeMap<Integer, ArrayList<PatientRecord>> monthsOriginalMap=yearMap.get(yearSet);
			for(Integer monthSet: monthsOriginalMap.keySet()){
				monthsSimplifiedMap.put(monthSet, monthsOriginalMap.get(monthSet).size());
			}
			simplifiedTreeMap.put(yearSet, monthsSimplifiedMap);
			int j=1;
			for(Integer crowdingTotalInMonth: monthsSimplifiedMap.values()){
			    summary[j][i]= crowdingTotalInMonth;
				j++;
			}
			i++;
			//System.out.println( yearSet+"**"+monthsSimplifiedMap.toString());
		}
		
		System.out.print("Saving Graph");
			System.out.println(Arrays.deepToString(summary));
		
		/* FileWriter writer=null;
			try {
				File file = new File("D:\\integrated.json");
				writer=new FileWriter(file);
				if(file.exists()){
					file.delete();
					file.createNewFile();
				}else{
					file.createNewFile();
				}
				XStream xstream = new XStream(new JettisonMappedXmlDriver());
				xstream.setMode(XStream.NO_REFERENCES);
				writer.write( xstream.toXML(simplifiedTreeMap));
				
				
			}finally{
				if(writer!=null)
					writer.close();
			}
			*/
			System.out.println("Finished Saving");
		 
	}
}
	
	 class PatientRecord {
		Integer dayOfVisit;
		Integer age;
		Integer sex;
		Integer race;
		Integer selfPaid;
		
		public PatientRecord(String dayofVisit,String age,String sex,String race,String selfpaid){
			this.dayOfVisit= Integer.parseInt(dayofVisit);
			this.age= Integer.parseInt(age);
			this.sex= Integer.parseInt(sex);
			this.race= Integer.parseInt(race);
			this.selfPaid= Integer.parseInt(selfpaid);
		}
	}

