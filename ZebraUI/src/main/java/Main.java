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
        Dispatcher dispatcher = new Dispatcher();

        PrxdatWorker worker = new PrxdatWorker();

        Gson gsonPrxDat = new GsonBuilder()
                .setExclusionStrategies(new PrxExclStrat())
                .registerTypeAdapter(HttpResponse.class, new HttpResponseSerializer())
                .create();

        port(7880);

        staticFiles.externalLocation(System.getProperty("user.dir")+"/web2");

        //Renders the webPage
        get("/", (req, res) -> responder.renderContent("web2/index.html"));

        get("/prxMetaData", (req, res) -> {
                    res.type("application/json");
                    return gsonPrxDat.toJson(worker.fetchPrxDat());
                }
        );

        get("/startRecording", (req, res) -> dispatcher.startRecording());

        get("/stopRecording", (req, res) -> dispatcher.stopRecording());

        get("/clearRecording", (req, res) -> dispatcher.clearRecording());

        get("/getNumberOfRecordedItems", (req, res) -> {
            res.type("application/json");
            return  dispatcher.getNumberOfItems();
        });

        //Returns the response data for a specific call
        get("/responseContent/:id", (req, res) -> {
                    res.type("application/json");
                    return gsonPrxDat.toJson(worker.fetchResponseContent(Integer.parseInt(req.params(":id"))));
                }
        );

        ProxySniffer console = new ProxySniffer();
        console.main(new String[]{"-RESTAPIServer", "-ExecAgent"});

    }

}
