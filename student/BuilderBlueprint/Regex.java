import java.util.List;

// Regex class
public class Regex {
    private StringBuilder pattern;

    public Regex() {
	pattern = new StringBuilder();
    }
    public Regex(List<String> component) {
	pattern = new StringBuilder();
       for(String s : component){
	       pattern.append(s);
       }
    }

    public String getPattern() {
        return pattern.toString();
    }

    @Override
    public String toString(){
	//String res = "";
	//for (String s : pattern) {
	//	res += s;
	//}
        //return res;
	return getPattern();
    }
}
