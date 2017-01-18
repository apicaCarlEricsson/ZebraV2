/**
 * Created by carlericsson on 26/12/16.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import dfischer.jobcontroller.JobControllerMainThread;
import dfischer.jobcontroller.JobControllerNetCmd;
import dfischer.proxysniffer.*;
import dfischer.utils.*;

import java.net.URL;
import dfischer.utils.PrxJob;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        Responder responder = new Responder();

        PrxdatWorker worker = new PrxdatWorker();

        Gson gsonPrxDat = new GsonBuilder()
                .setExclusionStrategies(new PrxExclStrat())
                .registerTypeAdapter(HttpResponse.class, new HttpResponseSerializer())
                .create();

        port(7880);

        staticFiles.externalLocation(System.getProperty("user.dir")+"/web2");

        //Renders the webPage
        get("/", (req, res) -> responder.renderContent("web2/index.html"));


        //Returns most of the data tied to the PrxDat
        /*get("/prxMetaData", (req, res) -> {
            res.type("application/json");
            return gsonPrxDat.toJson(worker.fetchPrxDat());
                }
            );*/

        get("/prxMetaData", (req, res) -> {
                    res.type("application/json");
                    return gsonPrxDat.toJson(worker.fetchPrxDat());
                }
        );

        //Returns the response data for a specific call
        get("/responseContent/:id", (req, res) -> {
                    res.type("application/json");
                    return gsonPrxDat.toJson(worker.fetchResponseContent(Integer.parseInt(req.params(":id"))));
                }
        );

    }

}
