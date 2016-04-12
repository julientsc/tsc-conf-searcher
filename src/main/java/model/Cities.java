package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cities {
	
	private static Cities instance = null;
	
	private List<City> cities = new ArrayList<>();
	
	private Cities() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/cities15000.txt"));
		
		String line = null;
		while((line = br.readLine())!=null) {
			String[] col = line.split("\t");
			
			String[] alternatesNames = col[3].split(",");
			List<String> alternateNamesList =  new ArrayList<>();
			for (int i = 0 ; i < alternatesNames.length ; i++) {
				alternateNamesList.add(alternatesNames[i]);
			}
			
			City city = new City(Integer.valueOf(col[0]), col[1], Double.valueOf(col[4]), Double.valueOf(col[5]), Integer.valueOf(col[14]), col[8], alternateNamesList);
			cities.add(city);
		}	
		br.close();
	}
	
	public HashMap<String, Integer> searchCities(List<String> lines) {
		HashMap<String, Integer> cs = new HashMap();
		
		for (String line : lines) {
			line = line.toLowerCase();
			String line2 = "";
			for(int i = 0 ; i < line.length() ; i++) {
				char c = line.charAt(i);
				if(c >= 'a' && c <= 'z' || c==' ') {
					line2 += c;
				}
			}
			line = line2;
			String[] tokens = line.split(" ");
			for(int i = 0 ; i < tokens.length ; i++)  {
				for (City city : cities) {
					if(tokens[i].equals(city.getName().toLowerCase())) {
						if(!cs.containsKey(city)) {
							cs.put(city.getName(), 0);
						}
//						cs.put(city.getName(), cs.get(city)+1);
					}
				}
			}
		}
		
		return cs;
	}
	
	public static Cities getInstance() throws IOException {
		if(instance == null)
			instance = new Cities();
		return instance;
	}

}
