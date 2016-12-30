/**
 * Created by carlericsson on 26/12/16.
 */
import dfischer.utils.*;

import java.net.URL;
import dfischer.utils.PrxJob;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        Responder responder = new Responder();

        port(7880);

        staticFiles.externalLocation(System.getProperty("user.dir")+"/web2");

        get("/", (req, res) -> responder.renderContent("web2/index.html"));
    }

}
