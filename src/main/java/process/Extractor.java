package process;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.Conference;
import model.InternetPage;
import tools.Cache;

public class Extractor {

	public static HashMap<String, InternetPage> IPs = null;
	
	public static InternetPage getPage(URL sUrl, Conference conference) throws IOException {
		Cache<HashMap<String, InternetPage>> cache = new Cache<HashMap<String, InternetPage>>("cache.json", );
		if(IPs == null) {
			new TypeToken<HashMap<String, InternetPage>>()
			try {
				IPs = cache.load();
			} catch (IOException e) {
				IPs = new HashMap<>();
			}
		}
		
		if(IPs.containsKey(sUrl.toString())) 
			return IPs.get(sUrl.toString());
		
		System.out.println("Download " + sUrl);
		URLConnection connection = sUrl.openConnection();
		InputStream inputStream = connection.getInputStream();
		
		StringBuilder sb = new StringBuilder();
		byte[] buffer = new byte[1024];
	
		while(inputStream.read(buffer)>0) {
			sb.append(new String(buffer));
			buffer = new byte[1024];
		}
		
		InternetPage ip = new InternetPage(sb.toString(), sUrl, conference.getYear());
		IPs.put(sUrl.toString(), ip);
		cache.save(IPs);
		
		return ip;
	}

	

	
	
}