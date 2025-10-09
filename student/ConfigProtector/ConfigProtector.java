import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class ConfigProtector {

    public String hideSensitiveData(String configFile, List<String> sensitiveKeys) {
	    String protectedConfig = configFile;

	    for (String key: sensitiveKeys){
		Pattern pattern = Pattern.compile("(?m)^(" + key + "=)(.*)$");
		Matcher matcher = pattern.matcher(protectedConfig);

		protectedConfig = matcher.replaceAll(match -> {
			return match.group(1) + "*".repeat(match.group(2).length());

		});
	    }

	    return protectedConfig;
    }
}

