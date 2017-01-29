import com.google.gson.Gson;

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

    Gson gson;

    public Responder (){
        gson = new Gson();
    }

    public String renderContent(String htmlFile) {
        try {
            File file = new File(htmlFile);
            return new String(Files.readAllBytes(Paths.get(file.toURI())));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    class saveResponse {
        String isSaved;

        public saveResponse (){

        }
    }




}
