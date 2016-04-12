package model;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import exec.SearchDates;
import process.Text;

public class InternetPage {

	private URL url = null;
	private String content = null;
	private int year;

	public InternetPage(String content, URL url, int year) {
		super();
		this.url = url;
		this.year = year;
		this.content = content;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void process() throws IOException {

		Document doc = Jsoup.parse(getContent());
		List<String> lines = Text.getLines(doc.html());
		
		// - - -
		
		List<String> dates = SearchDates.getDateLine(lines, year);
		
		System.out.println("Dates");
		System.out.println(url+ " " + year);
		for (String date : dates) {
			System.out.println(" => " + date);
		}
		
		// - - -
		
		System.out.println("Cities");
		HashMap<String,Integer> cities = Cities.getInstance().searchCities(lines);
		for (String city : cities.keySet()) {
			System.out.println(" => " + city);
		}
		
	}

}
