package exec;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import model.Conference;
import model.InternetPage;
import process.Extractor;
import process.Text;

public class SearchDates {

	
	
	
	public static boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	
	public static List<String> getDateLine(List<String> lines, int year) {
		List<String> dates = new ArrayList<>();
		for (String line : lines) {
			if(line.length() > 50)
				continue;
			if(line.contains(String.valueOf(year))) {
				String l = line.replaceAll("[-,\\|/()&;\\.]|th|st", " ");
				String[] terms = l.split(" ");
				int nbInteger = 0;
				List<Integer> tokenNb = new ArrayList<>();
				for(int i = 0 ; i < terms.length ; i++) {
					String term = terms[i].trim();
					if(isNumeric(term)) {
						nbInteger++;
						tokenNb.add(i);
					}
				}
				if(nbInteger>1 && follow(tokenNb)) {
					if(!dates.contains(line) && !line.contains("update"))
						dates.add(line);
				}
			}
		}
		return dates;
	}
	
	private static boolean follow(List<Integer> tokenNb) {
		for(int i = 0 ; i < tokenNb.size() - 1 ; i++) {
			int l = tokenNb.get(i+1) - tokenNb.get(i);
			if(l<3)
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws MalformedURLException, IOException {

		List<Conference> conferences = new ArrayList<>();
//		conferences.add(new Conference(2014, new URL("http://eccv2014.org")));
//		conferences.add(new Conference(2013, new URL("http://iswc2013.semanticweb.org")));
//		conferences.add(new Conference(2016, new URL("http://www.connectsecurityworld.com")));
//		conferences.add(new Conference(2015, new URL("http://iswc2015.semanticweb.org")));
//		conferences.add(new Conference(2016, new URL("http://iswc2016.semanticweb.org")));
//		conferences.add(new Conference(2012, new URL("http://eccv2012.unifi.it/conference/important-dates/")));
//		conferences.add(new Conference(2015, new URL("http://pamitc.org/iccv15/")));
//		conferences.add(new Conference(2012, new URL("http://www.wwwconference.org/www2012/")));

//		conferences.add(new Conference(2016, new URL("http://www.semantics.cc")));
//		conferences.add(new Conference(2016, new URL("http://www.staticanalysis.org/sas2016/")));
		conferences.add(new Conference(2011, new URL("http://www.iccv2011.org/general-info/important-dates")));
		
		
		
		
//		for (Conference conference : conferences) {
//			InternetPage webPage = Extractor.getPage(conference);
//			Document doc = Jsoup.parse(webPage.getContent());
//			List<String> lines = Text.getLines(doc.html());
//			List<String> dates = getDateLine(lines, conference.getYear());
//			
//			System.out.println(conference.getUrl() + " " + conference.getYear());
//			for (String date : dates) {
//				System.out.println(" => " + date);
//			}
//			System.out.println();
//		}
		
		
	}

}
