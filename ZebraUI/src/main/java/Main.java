/**
 * Created by carlericsson on 26/12/16.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dfischer.proxysniffer.HttpPageBreak;
import dfischer.proxysniffer.ProxyDataRecord;
import dfischer.utils.*;

import java.net.URL;
import dfischer.utils.PrxJob;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        Responder responder = new Responder();

        PrxdatWorker worker = new PrxdatWorker();

        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new PrxExclStrat())
                .create();

        ProxyDataRecord record=(ProxyDataRecord)worker.stuff().get(1);

        //System.out.println(gson.toJson(record.getHttpRequest()));

        System.out.println(gson.toJson(worker.prxdat));

        port(7880);

        staticFiles.externalLocation(System.getProperty("user.dir")+"/web2");

        //get("/", (req, res) -> responder.renderContent("web2/index.html"));

        //get("/rest", (req, res) -> );


    }

}
