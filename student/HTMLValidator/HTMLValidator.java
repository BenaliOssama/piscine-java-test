import java.util.regex.*;
import java.util.*;

// pattern.compile
// pattern.matcher
// matcher.find
// stack.peak
// matcher.group
// (/?)

public class HTMLValidator {
    public boolean validateHTML(String html) {
	if (html == null){
		return true;
	}
	System.out.println(html);
        Pattern tagPattern = Pattern.compile("<(/?)(html|body|div|p|b|i|h1|h2)>");
        Matcher matcher = tagPattern.matcher(html);

        List<String> matches = new ArrayList<>();

        while (matcher.find()) {
            String tag = matcher.group(1) + matcher.group(2); // adds "/" for closing tags
            matches.add(tag);
        }

        if (matches.isEmpty()) {
	    return true;
        }
	Stack stack = new Stack();
	for (String tag : matches) {
		if (tag.startsWith("/")){
			if (stack.isEmpty()){
				return false;
			}
			if (stack.peek().equals(tag.substring(1))){
				stack.pop()	;
			}else {
				return false;
			}
		}else{
			stack.push(tag);
		}
	}
        return stack.isEmpty();
    }

}

