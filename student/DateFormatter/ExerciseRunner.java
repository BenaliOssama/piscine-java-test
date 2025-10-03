import java.text.SimpleDateFormat;
import java.lang.reflect.Method;


public class ExerciseRunner {
    public static void main(String[] args) {
        Class claz = SimpleDateFormat.class;
        Method[] methods = claz.getMethods();

        for (int i = 0 ; i < methods.length; i++){
            System.out.println(methods[i].getName());
        }
    }
}

