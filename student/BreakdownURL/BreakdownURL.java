import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashMap;
import java.util.Map;

public class BreakdownURL{
    public Map<String, String> parseURL(String url) {
	System.out.println("test = " + url);
        // Implementation to parse and validate URLs using regex
	// https://www.example.com:8080/path?name=value	
	// https://www.example.com:9090/path/to/resource?param1=value1&param2=value2
	String protocol = "(https?)";
	String domain = "((?:\\w+)?\\.?[\\w-]+\\.\\w+)";
	String port = "(\\d+)?";
	String path = "(/(?:[^?]+)?)?";
	String key = "(\\w+=.*)?";

	Map<String, String> map = new HashMap();
	Pattern pattern = Pattern.compile(
	"^" + protocol + "://" +  domain + ":?" + port + path + "\\??" + key 
	);
	Matcher matcher = pattern.matcher(url);

	if (matcher.find()){
		map.put("protocol", matcher.group(1));
		map.put("domain", matcher.group(2));
		if (matcher.group(3) != null){
			map.put("port", matcher.group(3));
		}
		if (matcher.group(4) != null){
			map.put("path", matcher.group(4));
		}
		/*
		else{
			map.put("path", "/");
		}
		*/
		if (matcher.group(5) != null){
			map.put("query", matcher.group(5));
		}
	}


	return map;
    }
}


