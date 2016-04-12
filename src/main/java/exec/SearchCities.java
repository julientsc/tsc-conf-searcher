package exec;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import model.Cities;
import model.City;
import model.Conference;
import model.InternetPage;
import process.Extractor;
import process.Text;

public class SearchCities {
	

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
		conferences.add(new Conference(2011, new URL("http://www.iccv2011.org/")));
		
		
//		for (Conference conference : conferences) {
//			InternetPage webPage = Extractor.getPage(conference.getUrl());
//			Document doc = Jsoup.parse(webPage.getContent());
//			
//			List<String> lines = Text.getLines(doc.html());
//			
//			HashMap<String,Integer> cities = Cities.getInstance().searchCities(lines);
//			
//			for (String city : cities.keySet()) {
//				System.out.println(city);
//			}
//			
//			
//			
//		}
		
		
		
//		for (Conference conference : conferences) {
//			InternetPage webPage = Extractor.getPage(conference.getUrl());
//			Document doc = Jsoup.parse(webPage.getContent());
//			List<String> lines = Text.getLines(doc.html());
//			
//			
//		}
			
	}
}
