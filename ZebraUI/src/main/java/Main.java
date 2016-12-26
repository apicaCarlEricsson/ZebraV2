/**
 * Created by carlericsson on 26/12/16.
 */
import java.net.URL;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        Responder responder = new Responder();

        port(7880);

        String testPath = "/Users/carlericsson/Desktop/\"New Zebra\"/\"New Design\"/ZebraV2/";

        externalStaticFileLocation(testPath);

        System.out.println(responder.renderContent(testPath+"main.html"));

        get("/", (req, res) -> responder.renderContent(testPath+"main.html"));
    }

}
