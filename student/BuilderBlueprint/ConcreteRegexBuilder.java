import java.util.List;
import java.util.ArrayList;

// ConcreteRegexBuilder class
public class ConcreteRegexBuilder implements RegexBuilder {
    List<String> component;

    @Override
    public void buildLiteral(String literal){
        if (component == null) {
            component = new ArrayList<String>();
        }
        component.add(literal);
    }

    @Override
    public void buildAnyCharacter(){
        if (component == null) {
            component = new ArrayList<String>();
        }
        component.add(".");
    }

    @Override
    public void buildDigit(){
        if (component == null) {
            component = new ArrayList<String>();
        }
        component.add("\\d");
    }

    @Override
    public void buildWhitespace(){
        if (component == null) {
            component = new ArrayList<String>();
        }
        component.add("\\s");
    }

    @Override
    public void buildWordCharacter(){
        if (component == null) {
            component = new ArrayList<String>();
        }
        component.add("\\w");
    }

    @Override
    public Regex getResult() {
        return new Regex(component);
    }
}

