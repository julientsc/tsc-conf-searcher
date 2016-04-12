package model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import process.Extractor;

public class Conference {

	private int year;
	private URL url;
	
	private HashMap<String, InternetPage> pages = new HashMap<>();
	
	public Conference(int year, URL url) {
		this.year = year;
		this.url = url;
		
		
		
		try {
			InternetPage webPage = Extractor.getPage(url, this);
			pages.put(url.toString(), webPage);
			
			Document doc = Jsoup.parse(webPage.getContent(), url.toString());
			
			Elements elts = doc.select("a");
			for(int i = 0 ; i < elts.size() ; i++) {
				Element link = doc.select("a").get(i);
				String absHref = link.attr("abs:href"); // "http://jsoup.org/"

				try {
					if(!pages.containsKey(absHref) && absHref.contains(url.getHost())) {
						URL sUrl = new URL(absHref);
						InternetPage ip = Extractor.getPage(sUrl, this);
						ip.process();
						pages.put(absHref, ip);
					}

				} catch (MalformedURLException e) {	}
//				pages.put(absHref, Extractor.getPage(new URL(absHref)));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	
	
}
