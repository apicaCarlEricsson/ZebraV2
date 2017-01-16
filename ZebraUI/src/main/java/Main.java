/**
 * Created by carlericsson on 26/12/16.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dfischer.proxysniffer.HttpPageBreak;
import dfischer.proxysniffer.HttpRequest;
import dfischer.proxysniffer.ProxyDataRecord;
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
                .create();

        Gson gsonPrxRecord = new GsonBuilder()
                .setExclusionStrategies(new PrxRecordExclStrat())
                .registerTypeAdapter(HttpRequest.class, new HttpRequestSerializer())
                .create();

        ProxyDataRecord record=(ProxyDataRecord)worker.stuff().get(1);

        //System.out.println(gson.toJson(record.getHttpRequest()));

       // System.out.println(gsonPrxDat.toJson(worker.prxdat));

        /*for (Object o:worker.stuff()){
            System.out.println();

            System.out.println(gsonPrxRecord.toJson((ProxyDataRecord)o));
        }*/

        //System.out.println(gsonPrxRecord.toJson(worker.prxdat.getProxyData()));

        port(7880);

        staticFiles.externalLocation(System.getProperty("user.dir")+"/web2");

        get("/", (req, res) -> responder.renderContent("web2/index.html"));

        get("/prxMetaData", (req, res) -> {
            res.type("application/json");
            return gsonPrxDat.toJson(worker.prxdat);
                }
            );

        get("/prxRecordData", (req, res) -> gsonPrxRecord.toJson(worker.prxdat.getProxyData()));


    }

}
