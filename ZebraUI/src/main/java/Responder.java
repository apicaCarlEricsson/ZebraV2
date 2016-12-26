import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by carlericsson on 26/12/16.
 */
public class Responder {

    public String renderContent(String htmlFile) {
        try {
            // If you are using maven then your files
            // will be in a folder called resources.
            // getResource() gets that folder
            // and any files you specify.
            //URL url = getClass().getResource(htmlFile);

            // Return a String which has all
            // the contents of the file.
            //String content = new String(Files.readAllBytes(Paths.get(htmlFile)));
            File file = new File(htmlFile);
            //Path path = file.toPath();
            return new String(Files.readAllBytes(Paths.get(file.toURI())));
            //return new String(Files.readAllBytes(path), Charset.defaultCharset());
        } catch (IOException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

    }
}
