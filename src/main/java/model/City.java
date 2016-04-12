package model;

import java.util.List;

public class City {
	
	private int geonameId;
	private String name;
	private double latitude;
	private double longitude;
	private long population;
	private String coutry;
	private List<String> alternateNames;

	public City(int geonameId, String name, double latitude, double longitude, long population, String coutry,
			List<String> alternateNames) {
		super();
		this.geonameId = geonameId;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.population = population;
		this.coutry = coutry;
		this.alternateNames = alternateNames;
	}

	public int getGeonameId() {
		return geonameId;
	}

	public void setGeonameId(int geonameId) {
		this.geonameId = geonameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public String getCoutry() {
		return coutry;
	}

	public void setCoutry(String coutry) {
		this.coutry = coutry;
	}

	public List<String> getAlternateNames() {
		return alternateNames;
	}

	public void setAlternateNames(List<String> alternateNames) {
		this.alternateNames = alternateNames;
	}

	/*
	geonameid         : integer id of record in geonames database
	name              : name of geographical point (utf8) varchar(200)
	asciiname         : name of geographical point in plain ascii characters, varchar(200)
	alternatenames    : alternatenames, comma separated, ascii names automatically transliterated, convenience attribute from alternatename table, varchar(10000)
	latitude          : latitude in decimal degrees (wgs84)
	longitude         : longitude in decimal degrees (wgs84)
	feature class     : see http://www.geonames.org/export/codes.html, char(1)
	feature code      : see http://www.geonames.org/export/codes.html, varchar(10)
	country code      : ISO-3166 2-letter country code, 2 characters
	cc2               : alternate country codes, comma separated, ISO-3166 2-letter country code, 200 characters
	admin1 code       : fipscode (subject to change to iso code), see exceptions below, see file admin1Codes.txt for display names of this code; varchar(20)
	admin2 code       : code for the second administrative division, a county in the US, see file admin2Codes.txt; varchar(80) 
	admin3 code       : code for third level administrative division, varchar(20)
	admin4 code       : code for fourth level administrative division, varchar(20)
	population        : bigint (8 byte int) 
	elevation         : in meters, integer
	dem               : digital elevation model, srtm3 or gtopo30, average elevation of 3''x3'' (ca 90mx90m) or 30''x30'' (ca 900mx900m) area in meters, integer. srtm processed by cgiar/ciat.
	timezone          : the timezone id (see file timeZone.txt) varchar(40)
	modification date : date of last modification in yyyy-MM-dd format
	*/
	
}
