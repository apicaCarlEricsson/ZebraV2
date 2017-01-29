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

        get("/savePrxDat", (req, res) -> {
            res.type("application/json");
            if (!worker.isProjectSaved()) {
                return "{\"isSaved\": false}";
            }
            else{
                worker.saveProject(worker.fetchPrxDat().getProjectName());
                return "{\"isSaved\": true}";
            }
        });

        get("/savePrxDat/:name", (req, res) -> {
            res.type("application/json");
            return worker.saveProject(req.params(":name"));

        });

        get("/clearSession", (req, res) -> {
            worker.clearPrxDat();
            res.type("application/json");
            return "{\"isCleared\":true}";
        });

        get("/startRecording", (req, res) -> {
            String projectname = worker.fetchPrxDat().getProjectName();
            if (!(projectname.equalsIgnoreCase("-1")||projectname.equalsIgnoreCase("tempNull"))){
                dispatcher.loadSession(worker.fetchPrxDat().getProjectName());
                return dispatcher.startRecording();
            }else {
                return dispatcher.startRecording();
            }
        });

        get("/stopRecording", (req, res) -> {
            String projectname = worker.fetchPrxDat().getProjectName();
            dispatcher.stopRecording();
            if (!(projectname.equalsIgnoreCase("-1")||projectname.equalsIgnoreCase("tempNull"))){
                worker.reloadPrxDat(projectname, dispatcher.saveRecording(projectname));
            }else{
                worker.reloadPrxDat("tempNull", dispatcher.saveRecording());
                worker.deleteTempDat();
            }
            return 200;
        });

        get("/clearRecording", (req, res) -> {
            worker.clearPrxDat();
            return dispatcher.clearRecording();
        });

        get("/getNumberOfRecordedItems", (req, res) -> {
            res.type("application/json");
            return  dispatcher.getNumberOfItems();
        });

        get("/addPageBreakRec/:name", (req, res) -> {
            String projectname = worker.fetchPrxDat().getProjectName();
            dispatcher.insertPageBreak(req.params(":name"),3,35);
            if (!(projectname.equalsIgnoreCase("-1")||projectname.equalsIgnoreCase("tempNull"))){
                worker.reloadPrxDat(projectname, dispatcher.saveRecording(projectname));
            }else{
                worker.reloadPrxDat("tempNull", dispatcher.saveRecording());
                worker.deleteTempDat();
            }
            return 200;
        });

        get("/generateLoadTest", (req, res) -> {
            worker.generateLoadTest();
            res.type("application/json");
            return "{\"generated\": true}";
        });

        ProxySniffer console = new ProxySniffer();
        console.main(new String[]{"-RESTAPIServer", "-ExecAgent"});

    }

}
