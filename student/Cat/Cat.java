import java.io.*;
import java.nio.file.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
	    if (args == null || args.length == 0) {
		    return;
	    }
        Path input = Paths.get(args[0]);
        OutputStream out = System.out;
        Files.copy(input, out);
        //out.flush();
    }
}
