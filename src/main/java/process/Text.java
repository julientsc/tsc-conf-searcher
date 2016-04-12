package process;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

public class Text {

	public static List<String> getLines(String html) {
		if(html==null)
	        return new ArrayList<>();
	    
	    Document document = Jsoup.parse(html);
	    document.outputSettings(new Document.OutputSettings().prettyPrint(false));//makes html() preserve linebreaks and spacing
	    document.select("br").append("\\n");
	    document.select("p").prepend("\\n\\n");
	    String s = document.html().replaceAll("\\\\n", "\n").replaceAll("[\\||(|)]", "\n");
	    String txt = Jsoup.clean(s, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
		
		List<String> lines = new ArrayList<>();
		String line = new String();
		for(int i = 0 ; i < txt.length() - 1 ; i++) {
			if(txt.charAt(i)=='\n') {
				line = line.trim().toLowerCase();
				if(!line.equals("")) {
					if((int)line.charAt(line.length()-1) != 65533) {
						lines.add(line.replaceAll("[^\\p{ASCII}]", ""));
					}
				}
				line = new String();
			}
			else if(!(txt.charAt(i) == ' ' && txt.charAt(i+1) == ' ')) {
				if(txt.charAt(i) < 512)
					line += txt.charAt(i);
				else if(line.length() == 0 || line.charAt(line.length() - 1) != ' ')
					line += ' ';
			}
		}
		return lines;
	}
}
