import java.util.Map;

public class ExerciseRunner {
    public static void main(String[] args) {
        BreakdownURL parser = new BreakdownURL();

        // Test case 1
        String URL1 = "https://www.example.com:8080/path?name=value";
        Map<String, String> components1 = parser.parseURL(URL1);
        System.out.println("Components of URL 1: " + components1);

        // Test case 2
        String URL2 = "http://example.com/";
        Map<String, String> components2 = parser.parseURL(URL2);
        System.out.println("Components of URL 2: " + components2);
        // Test case 3
        String URL3 = "https://www.example.com/path";
		//"https://www.example.com:9090/path/to/resource?param1=value1&param2=value2";
        Map<String, String> components3 = parser.parseURL(URL3);
        System.out.println("Components of URL 3: " + components3);
    }
}
